import {Component, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";
import {Contadino} from "../../../../../entita/contadino/contadino";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-riassegnazione-alberi',
  templateUrl: './riassegnazione-alberi.component.html',
  styleUrls: ['./riassegnazione-alberi.component.scss']
})
export class RiassegnazioneAlberiComponent implements OnInit {

  public listaAlberi !: ProdottoOrdine[]
  selectedItem!: ProdottoOrdine;
  contadinoSelezionato: number = 0
  contadinoAttualeMap: { [alberoId: number]: Contadino|undefined } = {};
  public visibleModalModificaRiassegnazione = false;
  public listaContadini!: Contadino[]
  contadinoPrecedenteMap: { [alberoId: number]: Contadino|undefined } = {};

  constructor(private serviceContadino: ContadinoService) {

  }

  ngOnInit(): void {
    this.serviceContadino.getAlberiDaRiassegnare().subscribe(
      (data) => {
        this.listaAlberi = data;
        this.listaAlberi.forEach((albero) => {
          this.contadinoPrecedenteMap[albero.id] =  albero.contadino;
          this.contadinoAttualeMap[albero.id] = undefined;
        });
      },
      (error) => {
        console.log(error);
      }
    );

    this.serviceContadino.getContadini().subscribe(
      (data) => {
        this.listaContadini = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  toggleModalRiassegnazione() {
    this.visibleModalModificaRiassegnazione = !this.visibleModalModificaRiassegnazione;
  }


  handleRiassegnazione() {


    const contadinoSelezionato = this.listaContadini.find(contadino => contadino.id === Number(this.contadinoSelezionato));
    if (contadinoSelezionato) {
      this.contadinoPrecedenteMap[this.selectedItem.id] = this.selectedItem.contadino;
      // cerca l'elemento selezionato all'interno dell'array
      const selectedItemIndex = this.listaAlberi.findIndex(item => item === this.selectedItem);

      if (selectedItemIndex !== -1) {
        // modifica il contadino associato all'elemento selezionato
        this.listaAlberi[selectedItemIndex].contadino = contadinoSelezionato;

      }
      this.contadinoAttualeMap[this.selectedItem.id] = contadinoSelezionato;
    } else {
      console.log('Nessun contadino trovato.');
    }
    this.toggleModalRiassegnazione();
  }

  getContadiniCompatibili(nomePaese: String): Contadino[] {
    let contadini: Contadino[] = [];
    this.listaContadini.forEach(e => {
      if (e.coordinateGeografiche === nomePaese && this.selectedItem.contadino?.id !== e.id) {
        contadini.push(e)
      }
    })
    return contadini
  }

  confermaAssegnamento() {
    this.listaAlberi.forEach(e => {
      e.stato = "Assegnato"
      console.log(e)
      this.serviceContadino.aggiornaStato(e).subscribe(
        () => {
          this.serviceContadino.getAlberiDaRiassegnare().subscribe(
            (data) => {
              this.listaAlberi = data
            }
          )
        },
        (error) => {
          console.log(error)
        }
      )
    });

  }

  handleModalRiassegnazione(event: any) {
    this.visibleModalModificaRiassegnazione = event;
  }

  checkContadinoAttualeUndefined(): boolean {
    return Object.values(this.contadinoAttualeMap).some(contadino => contadino === undefined);
  }


}
