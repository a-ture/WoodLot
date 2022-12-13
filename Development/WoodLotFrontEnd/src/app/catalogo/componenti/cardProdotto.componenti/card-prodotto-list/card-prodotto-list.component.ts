import { Component, OnInit } from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-card-prodotto-list',
  templateUrl: './card-prodotto-list.component.html',
  styleUrls: ['./card-prodotto-list.component.scss']
})
export class CardProdottoListComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.png"

  public listaAlberi

  constructor(private serviceProdotto : ProdottoService) {
    this.listaAlberi = serviceProdotto.getProdotto();
  }

  ngOnInit(): void {
  }

}
