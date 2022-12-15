import { Component, OnInit } from '@angular/core';
import {ProdottoService} from "../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-consiglio-alberi-list',
  templateUrl: './consiglio-alberi-list.component.html',
  styleUrls: ['./consiglio-alberi-list.component.scss']
})
export class ConsiglioAlberiListComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.png"

  public listaAlberi

  constructor(private serviceProdotto : ProdottoService) {
    this.listaAlberi = serviceProdotto.getProdotti().slice(0,4);
  }

  ngOnInit(): void {
  }

}
