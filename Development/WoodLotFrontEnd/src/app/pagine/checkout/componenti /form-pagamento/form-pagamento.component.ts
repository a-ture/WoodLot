import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../../servizi/carrello/carrello.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormPagamentoService
} from "../../../../servizi/validazioneFormPagamento/validazione-form-pagamento.service";
import {FormCheckComponent} from "@coreui/angular";

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

  constructor(private serviceCarrelloProdotto: CarrelloService,
              serviceValidazioneFomrPagamento: ValidazioneFormPagamentoService) {
    this.listProdotti = serviceCarrelloProdotto.getCarrello()
    this.formPagamento = new FormGroup(
      {
        metodoPagamento: new FormControl(false, Validators.requiredTrue),
        nomeTitolare: new FormControl('', Validators.required),
        numeroCartaDiCredito: new FormControl('', Validators.required),
        dataScadenza: new FormControl('', Validators.required),
        cvv: new FormControl('', Validators.required),
      }
    )
  }

  ngOnInit(): void {
  }

  public getTotalePezzi() {
    let conta = 0
    this.listProdotti.forEach(e => {
      conta += e.quantita
    })
    return conta
  }

  public getTotale() {
    let conta = 0
    this.listProdotti.forEach(e => {
      conta += (e.prezzo * e.quantita)
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
    }
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formPagamento.controls;
  }

}
