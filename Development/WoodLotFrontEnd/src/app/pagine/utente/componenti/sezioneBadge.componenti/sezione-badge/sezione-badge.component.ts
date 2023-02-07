import {Component, Input, OnInit} from '@angular/core';
import {Ordine} from "../../../../../entita/ordine/ordine";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

//TODO aggiungere logica per sblocco badge
@Component({
  selector: 'app-sezione-badge',
  templateUrl: './sezione-badge.component.html',
  styleUrls: ['./sezione-badge.component.scss']
})
export class SezioneBadgeComponent implements OnInit {

  @Input() lista !: ProdottoOrdine[]

  public listaBadge = [
    "Giramondo", "Matricola", "Multitasking", "Tarzan"
  ]

  public listaDescrizioneBadge = [
    "Supera i confini e pianta almeno un albero in 4 paesi diversi.",
    "Inizia la tua esperienza e pianta il tuo primo albero.",
    "Gli alberi sanno essere utili in molti modi. Pianta alberi che assolvono ad almeno 6 dei loro 8 usi e benefici.",
    "Sii come Tarzan, pianta almeno 20 alberi"
  ]

  public listaSourceImage = [
    "assets/img/profiloUtente/badge/giramondo.png",
    "assets/img/profiloUtente/badge/matricola.png",
    "assets/img/profiloUtente/badge/multitasking.png",
    "assets/img/profiloUtente/badge/tarzan.png",
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

  bloccato(nome: String): boolean {
    if (nome == 'Matricola') {
      if (this.lista.length > 0)
        return false
    }
    if (nome == 'Tarzan') {
      if (this.lista.length > 20)
        return false
    } else if (nome == 'Giramondo') {
      let a = 0, p = 0, g = 0, i = 0
      this.lista.forEach((e) => {
        if (e.albero.paeseOrigine?.nome == 'Italia')
          i++
        else if (e.albero.paeseOrigine?.nome == 'Guatemala')
          g++
        else if (e.albero.paeseOrigine?.nome == 'Perù')
          p++
        else if (e.albero.paeseOrigine?.nome == 'Argentina')
          a++
      })
      if (a != 0 && p != 0 && g != 0 && i != 0)
        return false;
    } else if (nome == 'Multitasking') {
      let trovato = false
      this.lista.forEach((e) => {
        if (e.albero.benefici && e.albero.usiLocali && (e.albero.benefici.length + e.albero.usiLocali.length) > 6) {
          trovato = true
          return
        }
      })
      if (trovato)
        return false
    }
    return true;
  }

}
