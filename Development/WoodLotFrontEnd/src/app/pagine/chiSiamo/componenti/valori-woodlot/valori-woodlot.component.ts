import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-valori-woodlot',
  templateUrl: './valori-woodlot.component.html',
  styleUrls: ['./valori-woodlot.component.scss']
})
export class ValoriWoodlotComponent implements OnInit {

  public listaTitoli = [
    "Piantiamo alberi per contrastare la crisi climatica.",
    "Vogliamo generare un impatto sociale e duraturo",
    "Lo facciamo davvero, e puoi tracciarlo"
  ]

  public listaTesto = [
    "Scelte e azioni quotidiane individuali, influiscono sul futuro della terra." +
    "Il nostro progetto nasce per permettere a chiunque di fare la sua parte nel contrastare la crisi climatica",
    "Tutti gli alberi che piantiamo, vengono donati a famiglie contadine locali generando sicurezza alimentare e" +
    " sostegno economico.",
    "Tutti gli alberi hanno un codice univoco che li identifica. Grazie al nostro sistema di tracciamento e trasparenza," +
    " puoi monitorare la crescita di ogni singolo albero della tua foresta attraverso periodici aggiornamenti personalizzati."
  ]

  public listaSource = [
    "fa-solid fa-seedling",
    "fa-solid fa-apple-whole",
    "fa-solid fa-map-location-dot",
  ]


  public listaColore = [
    "success",
    "danger",
    "info",
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
