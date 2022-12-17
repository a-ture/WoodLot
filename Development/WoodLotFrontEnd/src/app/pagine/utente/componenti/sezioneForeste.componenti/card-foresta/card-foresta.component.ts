import {Component, Input, OnInit} from '@angular/core';
import {Foresta} from "../../../../../entita/foresta/foresta";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-card-foresta',
  templateUrl: './card-foresta.component.html',
  styleUrls: ['./card-foresta.component.scss']
})
export class CardForestaComponent implements OnInit {
  @Input()
  public sourceImage !: String

  @Input()
  public foresta !: Foresta

  @Input()
  public listaAlberi!: ProdottoOrdine[]

  @Input()
  public tipo !: String

  public getCo2Foresta() {
    let co2 = 0
    this.foresta.alberi.forEach(e => {
      co2 += e.co2
    })
    return co2
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
