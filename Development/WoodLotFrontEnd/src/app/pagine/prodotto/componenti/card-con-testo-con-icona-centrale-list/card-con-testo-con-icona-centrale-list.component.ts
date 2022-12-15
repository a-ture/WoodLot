import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-con-testo-con-icona-centrale-list',
  templateUrl: './card-con-testo-con-icona-centrale-list.component.html',
  styleUrls: ['./card-con-testo-con-icona-centrale-list.component.scss']
})
export class CardConTestoConIconaCentraleListComponent implements OnInit {

  public listaTitoli = [
    "Trasparenza e tracciabilità",
    "Un racconto che dura nel tempo",
    "Un regalo originale"
  ]

  public listaTesto = [
    "Tutti gli alberi sono geolocalizzati e fotografati quando vengono piantati. Dal momento dell'acquisto è necessario" +
    " attendere da alcune dettimane a qualche mese prima che un albero sia pronto per essere piantato.",
    "Ogni albero ha una sua storia, scoprirai le sue caratteristiche e seguirai la storia del progetto di cui fa parte.",
    "Regalare un albero è semplicissimo. Puoi farli durante la procedura d'acquisto o in qualche momento dal tuo " +
    "profilo, scegliendo la modalità che preferisci (via mail, messaggio o stampando un biglietto da consegnare a mano)."
  ]

  public listaSource = [
    "fas fa-map-pin",
    "fas fa-book",
    "fas fa-gift"
  ]

  public listaColore = [
    "success",
    "primary",
    "danger"
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
