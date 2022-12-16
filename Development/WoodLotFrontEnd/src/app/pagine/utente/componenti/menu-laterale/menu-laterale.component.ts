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
  public listaForeste !: Foresta[]

  selectedMenu : String = "Home"

  goTo(paramText:String){
    this.selectedMenu=paramText
  }

  constructor() { }

  ngOnInit(): void {
  }

}
