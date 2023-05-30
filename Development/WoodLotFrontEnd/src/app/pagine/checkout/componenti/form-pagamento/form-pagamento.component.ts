import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../../servizi/carrello/carrello.service";
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";

import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {OrdineEffettuatoComponent} from "../ordine-effettuato/ordine-effettuato.component";
import {Carrello} from "../../../../entita/carrello/carrello";
import {OrdineService} from "../../../../servizi/ordine/ordine.service";
import {Ordine} from "../../../../entita/ordine/ordine";
import {
  ValidazioneFormPagamentoService
} from "../../../../servizi/validazioneFormPagamento/validazione-form-pagamento.service";


@Component({
  selector: 'app-form-pagamento',
  templateUrl: './form-pagamento.component.html',
  styleUrls: ['./form-pagamento.component.scss']
})
export class FormPagamentoComponent implements OnInit {

  public carrello !: Carrello

  formPagamento: FormGroup
  submitted = false;
  formErrori: any;
  errrorMessage: string = ''

  modalOrdineEffettuato: MdbModalRef<OrdineEffettuatoComponent> | null = null;

  metodoPagamento = [
    "MasterCard",
    "Visa",
    "American Express"
  ]

  constructor(private serviceCarrelloProdotto: CarrelloService,
              private serviceValidazioneFomrPagamento: ValidazioneFormPagamentoService,
              private modalService: MdbModalService,
              private serviceOrdini: OrdineService) {
    const storedCarrello = sessionStorage.getItem('carrello');
    if (storedCarrello != null) {
      this.carrello = JSON.parse(storedCarrello)
      console.log(this.carrello)
    }

    this.formPagamento = new FormGroup(
      {
        metodoPagamento: new FormControl('Visa'),
        nomeTitolare: new FormControl('', [Validators.required,
          Validators.maxLength(serviceValidazioneFomrPagamento.regoleForm.nomeTitolareCartaMax),
          Validators.pattern(serviceValidazioneFomrPagamento.regoleForm.nomeTitolareCarta)]),
        numeroCartaDiCredito: new FormControl('', [
          Validators.required,
          Validators.pattern(/^4[0-9]{12}(?:[0-9]{3})?$|^5[1-5][0-9]{14}$|^3[47][0-9]{13}$/),
        ]),
        dataScadenza: new FormControl('', [Validators.required,
          Validators.pattern(/^(0[1-9]|1[0-2])\/[0-9]{2}$/), this.validatoreDataScaduta
        ]),
        cvv: new FormControl('', [Validators.required,
          Validators.pattern(serviceValidazioneFomrPagamento.regoleForm.cvv)]),
      }
    )

    this.formErrori = this.serviceValidazioneFomrPagamento.errori;
  }

  ngOnInit(): void {
  }


  public getTotale() {
    let conta = 0
    this.carrello.prodottiCarrello.forEach(e => {
      conta += (e.albero.prezzo)
    })
    return conta
  }

  onValidate() {
    this.submitted = true;
    return this.formPagamento.status === 'VALID';
  }

  onSubmit(): void {
    if (this.onValidate()) {
      this.errrorMessage = ''
      if (this.carrello.utente.id) {
        this.serviceOrdini.effettuaOrdine(this.carrello.utente.id).subscribe(
          (data: Ordine) => {

            sessionStorage.removeItem('carrello')
            if (this.carrello.utente.id) {
              this.serviceCarrelloProdotto.getCarrello(this.carrello.utente.id).subscribe(
                (data: Carrello) => {
                  console.log(data)
                  let carrello = data
                  sessionStorage.setItem("carrello", JSON.stringify(carrello))
                  this.openModalOrdine();
                });
            }
          }, (error) => {
            this.errrorMessage = JSON.stringify(error.data)
          }
        );

      }
    }
  }


  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formPagamento.controls;
  }

  openModalOrdine() {
    this.modalOrdineEffettuato = this.modalService.open(OrdineEffettuatoComponent)
  }

  updateTipoCarta(numeroCarta: string) {
    if (numeroCarta.startsWith('4')) {
      this.formPagamento.patchValue({metodoPagamento: 'Visa'});
    } else if (numeroCarta.startsWith('5')) {
      this.formPagamento.patchValue({metodoPagamento: 'MasterCard'});
    } else if (numeroCarta.startsWith('3')) {
      this.formPagamento.patchValue({metodoPagamento: 'American Express'});
    }
  }


// Funzione di validazione personalizzata per la data di scadenza
  validatoreDataScaduta(control: AbstractControl): ValidationErrors | null {
    const valoreData = control.value;

    if (!valoreData) {
      return null; // Non eseguire la validazione se il campo è vuoto
    }

    const formatoData = /^(0[1-9]|1[0-2])\/[0-9]{2}$/;
    if (!formatoData.test(valoreData)) {
      return {formatoData: true}; // La data non rispetta il formato MM/YY
    }

    const [mese, anno] = valoreData.split('/');
    const dataScadenza = new Date(2000 + parseInt(anno, 10), parseInt(mese, 10) - 1);
    const dataOdierna = new Date();

    if (dataScadenza < dataOdierna) {
      return {dataScaduta: true}; // La data di scadenza è precedente alla data odierna
    }

    return null; // La data è valida
  }


}
