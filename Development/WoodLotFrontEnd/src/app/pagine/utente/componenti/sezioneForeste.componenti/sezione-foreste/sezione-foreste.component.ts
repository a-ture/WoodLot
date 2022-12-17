import {Component, Input, OnInit} from '@angular/core';
import {Foresta} from "../../../../../entita/foresta/foresta";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-sezione-foreste',
  templateUrl: './sezione-foreste.component.html',
  styleUrls: ['./sezione-foreste.component.scss']
})
export class SezioneForesteComponent implements OnInit {

  @Input()
  public listaForesteCreate !: Foresta[]

  @Input()
  public listaForesteSupportate !: Foresta[]

  @Input()
  public listaAlberiDaPiantare !: ProdottoOrdine[]

  public panes = [
    {name: 'Create', content: 'One'},
    {name: 'Supportate', content: 'Two'},
    {name: 'Crea la tua foresta', content: 'Three'},
  ];

  activePane = 0;

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

  constructor() {
  }


  ngOnInit(): void {
  }

}
