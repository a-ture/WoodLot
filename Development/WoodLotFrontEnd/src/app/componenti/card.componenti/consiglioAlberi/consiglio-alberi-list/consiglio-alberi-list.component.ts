import { Component, OnInit } from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../entita/albero/albero";

@Component({
  selector: 'app-consiglio-alberi-list',
  templateUrl: './consiglio-alberi-list.component.html',
  styleUrls: ['./consiglio-alberi-list.component.scss']
})
export class ConsiglioAlberiListComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"

  public listaAlberi !:Albero[];

  constructor(private serviceProdotto : ProdottoService) {
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaAlberi = alberi.slice(0, 4);
    })
  }

  ngOnInit(): void {
  }

}
