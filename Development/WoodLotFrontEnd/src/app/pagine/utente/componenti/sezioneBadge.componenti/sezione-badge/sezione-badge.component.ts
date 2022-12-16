import {Component, OnInit} from '@angular/core';
//TODO aggiungere logica per sblocco badge
@Component({
  selector: 'app-sezione-badge',
  templateUrl: './sezione-badge.component.html',
  styleUrls: ['./sezione-badge.component.scss']
})
export class SezioneBadgeComponent implements OnInit {

  public listaBadge = [
    "Astrologo", "Benefattore", "Giramondo", "Matricola", "Tutto fare", "Tarzan"
  ]

  public listaDescrizioneBadge = [
    "Mira alle stelle e pianta l'albero del tuo segno zodiacale.",
    "Sii generoso e regala almeno un albero. Otterrai il riconoscimento quando la persona a cui hai regalato l'albero," +
    " lo riscatterà, diventandone così custode e iniziando a seguirne la storia.",
    "Supera i confini e pianta almeno un albero in 3 paesi diversi.",
    "Inizia la tua esperienza e pianta il tuo primo albero.",
    "Gli alberi sanno essere utili in molti modi. Pianta alberi che assolvono ad almeno 6 dei loro 8 usi e benefici.",
    "Non essere timido e pubblica la tua prima foresta."
  ]

  public listaSourceImage = [
    "assets/img/profiloUtente/badge/astrologo.png",
    "assets/img/profiloUtente/badge/benefattore.png",
    "assets/img/profiloUtente/badge/giramondo.png",
    "assets/img/profiloUtente/badge/matricola.png",
    "assets/img/profiloUtente/badge/multitasking.png",
    "assets/img/profiloUtente/badge/tarzan.png",
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
