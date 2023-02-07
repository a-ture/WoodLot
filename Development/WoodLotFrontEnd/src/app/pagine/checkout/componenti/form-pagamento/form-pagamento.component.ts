import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../../servizi/carrello/carrello.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormPagamentoService
} from "../../../../servizi/validazioneFormPagamento/validazione-form-pagamento.service";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {OrdineEffettuatoComponent} from "../ordine-effettuato/ordine-effettuato.component";
import {Carrello} from "../../../../entita/carrello/carrello";
import {OrdineService} from "../../../../servizi/ordine/ordine.service";
import {Ordine} from "../../../../entita/ordine/ordine";


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
        numeroCartaDiCredito: new FormControl('', [Validators.required,
          Validators.maxLength(serviceValidazioneFomrPagamento.regoleForm.numeroCartaDiCreditoMax),
          Validators.pattern(serviceValidazioneFomrPagamento.regoleForm.numeroCartaDiCredito)]),
        dataScadenza: new FormControl('', [Validators.required]),
        cvv: new FormControl('', [Validators.required, Validators.pattern(serviceValidazioneFomrPagamento.regoleForm.cvv)]),
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
}
