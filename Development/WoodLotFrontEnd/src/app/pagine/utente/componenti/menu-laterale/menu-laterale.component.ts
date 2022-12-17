import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../entita/prodottoOrdine/prodotto-ordine";
import {Foresta} from "../../../../entita/foresta/foresta";

//TODO aggiungere il routing

@Component({
  selector: 'app-menu-laterale',
  templateUrl: './menu-laterale.component.html',
  styleUrls: ['./menu-laterale.component.scss']
})
export class MenuLateraleComponent implements OnInit {

  @Input()
  public listaAlberi !: ProdottoOrdine[]

  @Input()
  public listaForesteCreate !: Foresta[]

  @Input()
  public listaForesteSupportate !: Foresta[]

  selectedMenu: String = "Alberi"

  goTo(paramText: String) {
    this.selectedMenu = paramText
  }

  //trova gli alberi che possono essere piantati in una foresta
  public getAlberiDaPiantare() {
    let alberi = new Array<ProdottoOrdine>()
    this.listaAlberi.forEach(e => {
      if (e.nomeForesta == "") {
        alberi.push(e)
      }
    })
    return alberi
  }


  constructor() {
  }

  ngOnInit(): void {
  }

}
