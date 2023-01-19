import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-scegli-il-tuo-albero',
  templateUrl: './scegli-il-tuo-albero.component.html',
  styleUrls: ['./scegli-il-tuo-albero.component.scss']
})
export class ScegliIlTuoAlberoComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.png"

  public listaAlberi

  constructor(private serviceProdotto: ProdottoService) {
    this.listaAlberi = serviceProdotto.getProdotti().slice(0, 4);
  }

  ngOnInit(): void {
  }

}
