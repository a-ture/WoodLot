import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";
import {Pagamento} from "../../../../../entita/pagamento/pagamento";

@Component({
  selector: 'app-card-pagamento',
  templateUrl: './card-pagamento.component.html',
  styleUrls: ['./card-pagamento.component.scss']
})
export class CardPagamentoComponent implements OnInit {

  @Input()
  public prodottoOrdine !: ProdottoOrdine

  @Input()
  public sourceImage !: String

  @Output()
  public cambiamentoEffettuato: EventEmitter<any> = new EventEmitter();

  errorMessage: string = '';
  formPagamento!: FormGroup
  submitted = false;
  formErrori: any;
  public visiblePagamento = false;
  public visibleFoto = false;

  toggleModalPagamento() {
    this.visiblePagamento = !this.visiblePagamento;
  }

  handleModalPagamento(event: any) {
    this.visiblePagamento = event;
  }

  toggleModalFoto() {
    this.visibleFoto = !this.visibleFoto;
  }

  handleModalFoto(event: any) {
    this.visibleFoto = event;
  }

  constructor(private serviceContadino: ContadinoService) {
    this.formPagamento = new FormGroup({
      motivazione: new FormControl('', Validators.required)
    })
  }

  ngOnInit(): void {
  }

  getPagamento() {
    return (this.prodottoOrdine.prezzoUnitario * 80 / 100)
  }

  onSubmitPagamento(): void {

    console.log(this.prodottoOrdine)
    let contadino = this.prodottoOrdine.contadino
    let motivazione = "Compenso contadino " + contadino?.nome + " " + contadino?.cognome + " per la piantumazione dell'albero";
    let importo = this.getPagamento()
    if (contadino) {
      let pagamento = new Pagamento(0, importo, new Date, motivazione, contadino)
      console.log(pagamento)
      this.serviceContadino.effettuarePagamento(pagamento).subscribe(
        () => {
          // aggiornare lo stato ha piantato
          this.prodottoOrdine.stato = 'Piantato'
          this.serviceContadino.aggiornaStato(this.prodottoOrdine).subscribe(
            () => {
              console.log(this.prodottoOrdine)
              this.toggleModalPagamento()
              this.cambiamentoEffettuato.emit()
            }, (error) => {
              console.log(error)
              this.errorMessage = JSON.stringify(error.data)
            },
          )
        },
        (error) => {
          console.log(error)
          this.errorMessage = JSON.stringify(error.data)
        }
      )
    }

  }


  handleConfirmClick() {
    let idContadino = this.prodottoOrdine.contadino?.id;
    if (idContadino) {
      console.log(idContadino)
      this.serviceContadino.eliminaFoto(idContadino + "", this.prodottoOrdine.id + "").subscribe(
        () => {
          console.log(idContadino)
          this.prodottoOrdine.stato = "Riassegnazione";
          this.serviceContadino.aggiornaStato(this.prodottoOrdine).subscribe(
            () => {
              console.log(this.prodottoOrdine);
              this.toggleModalFoto();
              this.cambiamentoEffettuato.emit();
            }, (error) => {
              console.log(error);
              this.errorMessage = JSON.stringify(error.data);
            });
        },
        (error) => {
          console.log(error);
          this.errorMessage = JSON.stringify(error.data);
        }
      );
    }
  }
}
