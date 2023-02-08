import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Albero} from "../../../../../entita/albero/albero";
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-sezione-elimina',
  templateUrl: './sezione-elimina.component.html',
  styleUrls: ['./sezione-elimina.component.scss']
})
export class SezioneEliminaComponent implements OnInit {


  public listaProdotti !: Albero[]

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"

  constructor(private serviceProdotto: ProdottoService) {
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaProdotti = alberi;
    })
  }

  ngOnInit(): void {
  }

  public handleProductDeleted() {
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaProdotti = alberi;
    });
  }

}
