import { Component, OnInit } from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../entita/albero/albero";

@Component({
  selector: 'app-card-prodotto-list',
  templateUrl: './card-prodotto-list.component.html',
  styleUrls: ['./card-prodotto-list.component.scss']
})
export class CardProdottoListComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"

  public listaAlberi !:Albero[];

  constructor(private serviceProdotto : ProdottoService) {
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaAlberi = alberi;
    })
  }

  ngOnInit(): void {
  }

}
