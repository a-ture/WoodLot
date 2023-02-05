import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../../servizi/carrello/carrello.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormPagamentoService
} from "../../../../servizi/validazioneFormPagamento/validazione-form-pagamento.service";

import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {OrdineEffettuatoComponent} from "../ordine-effettuato/ordine-effettuato.component";

@Component({
  selector: 'app-form-pagamento',
  templateUrl: './form-pagamento.component.html',
  styleUrls: ['./form-pagamento.component.scss']
})
export class FormPagamentoComponent implements OnInit {

  public listProdotti

  formPagamento: FormGroup
  submitted = false;
  formErrori: any;

  modalOrdineEffettuato: MdbModalRef<OrdineEffettuatoComponent> | null = null;

  metodoPagamento = [
    "MasterCard",
    "Visa",
    "American Express"
  ]

  constructor(private serviceCarrelloProdotto: CarrelloService,
              private serviceValidazioneFomrPagamento: ValidazioneFormPagamentoService,
              private modalService: MdbModalService) {
    this.listProdotti = serviceCarrelloProdotto.getCarrello()
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
    this.listProdotti.forEach(e => {
      conta += (e.prezzo)
    })
    return conta
  }

  onValidate() {
    this.submitted = true;
    //fermati qui se il modulo non è valido
    return this.formPagamento.status === 'VALID';
  }

  onSubmit(): void {

    if (this.onValidate()) {
      // TODO: Submit form value
      console.warn(this.formPagamento.value);
      alert('SUCCESS!');
      this.openModalOrdine();
    } else {
      alert('Form non valido')
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
