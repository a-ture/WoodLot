import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";
import {Contadino} from "../../../../../entita/contadino/contadino";

@Component({
  selector: 'app-assegnazione-alberi',
  templateUrl: './assegnazione-alberi.component.html',
  styleUrls: ['./assegnazione-alberi.component.scss']
})
export class AssegnazioneAlberiComponent implements OnInit {

  selectedMenu: String = ""
  selectedItem!: ProdottoOrdine;
  contadinoSelezionato: number = 0

  public visibleModalModifica = false;
  public visibleModalContadino = false;
  public visibleSuccess = false;
  public listaAlberi !: ProdottoOrdine[]
  public listaContadini!: Contadino[]

  constructor(private serviceContadino: ContadinoService) {

  }

  ngOnInit(): void {
    this.serviceContadino.getAlberiNonAssegnati().subscribe(
      (data) => {
        this.listaAlberi = data
        this.serviceContadino.getContadini().subscribe(
          (data) => {
            this.listaContadini = data
            this.listaContadini.forEach(e => {
              this.serviceContadino.getAlberiContadini(e.id).subscribe((data) => {
                  e.listaAlberi = data
                }
              )
            })
          }
        )
      }
    )
  }

  handleModalModifica(event: any) {
    this.visibleModalModifica = event;
  }

  handleSuccess(event: any) {
    this.visibleSuccess = event;
  }


  toggleModelSuccess() {
    this.visibleSuccess = !this.visibleSuccess;
  }

  toggleModalModifica() {
    this.visibleModalModifica = !this.visibleModalModifica;
  }

  handleModalContadino(event: any) {
    this.visibleModalContadino = event;
  }

  toggleModalContadino() {
    this.visibleModalContadino = !this.visibleModalContadino;
  }

  handleConfirmClickModifica() {
    const contadinoSelezionato = this.listaContadini.find(contadino => contadino.id === Number(this.contadinoSelezionato));
    if (contadinoSelezionato) {
      // cerca l'elemento selezionato all'interno dell'array
      const selectedItemIndex = this.listaAlberi.findIndex(item => item === this.selectedItem);

      if (selectedItemIndex !== -1) {
        // modifica il contadino associato all'elemento selezionato
        this.listaAlberi[selectedItemIndex].contadino = contadinoSelezionato;
      }
      this.selectedItem.contadino = contadinoSelezionato;
    } else {
      console.log('Nessun contadino trovato.');
    }
    this.toggleModalModifica();
  }


  goTo(paramText: String) {
    this.selectedMenu = paramText
    this.serviceContadino.assegnazioneAlberi().subscribe(
      (data) => {
        this.listaAlberi = data
        this.listaAlberi.forEach(e => {
          if (e.contadino?.id) {
            this.serviceContadino.getAlberiContadini(e.contadino?.id).subscribe((data) => {
                // @ts-ignore
                e.contadino.listaAlberi = data
              }
            )
          }
        })
      }
    )
  }

  getContadiniCompatibili(nomePaese: String): Contadino[] {
    let contadini: Contadino[] = [];
    this.listaContadini.forEach(e => {
      if (e.coordinateGeografiche === nomePaese) {
        contadini.push(e)
      }
    })
    return contadini
  }

  confermaAssegnamento() {
    let successo: boolean = false
    this.listaAlberi.forEach(e => {
      e.stato = "Assegnato"
      this.serviceContadino.aggiornaStato(e).subscribe(
        () => {
          successo = true
        },
        (error) => {
          console.log(error)
        }
      )
    });
    setTimeout(() => {
      // Continua l'esecuzione del codice dopo 1 secondi
      this.toggleModelSuccess()
      this.serviceContadino.getAlberiNonAssegnati().subscribe(
        (data) => {
          this.listaAlberi = data
          this.serviceContadino.getContadini().subscribe(
            (data) => {
              this.listaContadini = data
              this.listaContadini.forEach(e => {
                this.serviceContadino.getAlberiContadini(e.id).subscribe((data) => {
                    e.listaAlberi = data
                  }
                )
              })
            }
          )
        }
      )
      this.selectedMenu = ""
    }, 1000);
  }
}

