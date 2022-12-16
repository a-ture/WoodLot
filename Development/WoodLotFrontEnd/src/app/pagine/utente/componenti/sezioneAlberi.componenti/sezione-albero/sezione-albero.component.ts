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
    {name: 'Regalati', content: 'Two'},
  ];

  activePane = 0;

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }
  @Input()
  public listaAlberi !: ProdottoOrdine[]

  constructor() {}

  //questo metodo restituisce gli alberi dell'utente, per la sezione "Tuoi"
  public getAlberiUtente(){
    let alberi = new Array<ProdottoOrdine>()
    this.listaAlberi.forEach( e =>{
      if (e.destinatarioRegalo == ""){
        alberi.push(e)
      }
    })
    return alberi
  }

  //questo metodo restituisce gli alberi che l'utente ha regalato, per la sezione "Regalati"
  public getAlberiRegalati(){
    let alberi = new Array<ProdottoOrdine>()
    this.listaAlberi.forEach( e =>{
      if (e.destinatarioRegalo != ""){
        alberi.push(e)
      }
    })
    return alberi
  }
  ngOnInit(): void {

  }

}
