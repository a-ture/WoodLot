import {Component, Input, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-sezione-albero',
  templateUrl: './sezione-albero.component.html',
  styleUrls: ['./sezione-albero.component.scss']
})
export class SezioneAlberoComponent implements OnInit {

  public panes = [
    {name: 'Tuoi', content: 'One'},
  ];

  activePane = 0;

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

  @Input()
  public listaAlberi !: ProdottoOrdine[]

  constructor() {}

  ngOnInit(): void {

  }

}
