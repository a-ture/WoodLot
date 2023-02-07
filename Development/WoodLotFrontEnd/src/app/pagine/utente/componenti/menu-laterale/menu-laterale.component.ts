import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../entita/prodottoOrdine/prodotto-ordine";


//TODO aggiungere il routing

@Component({
  selector: 'app-menu-laterale',
  templateUrl: './menu-laterale.component.html',
  styleUrls: ['./menu-laterale.component.scss']
})
export class MenuLateraleComponent implements OnInit {

  @Input()
  public listaAlberi !: ProdottoOrdine[]


  selectedMenu: String = "Badge"

  goTo(paramText: String) {
    this.selectedMenu = paramText
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
