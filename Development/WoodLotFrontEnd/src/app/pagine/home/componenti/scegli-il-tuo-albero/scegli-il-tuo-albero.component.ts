import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../entita/albero/albero";

@Component({
  selector: 'app-scegli-il-tuo-albero',
  templateUrl: './scegli-il-tuo-albero.component.html',
  styleUrls: ['./scegli-il-tuo-albero.component.scss']
})
export class ScegliIlTuoAlberoComponent implements OnInit {

  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"

  public listaAlberi !:Albero[];

  constructor(private serviceProdotto: ProdottoService) {
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaAlberi = alberi.slice(0, 4);
    })
  }

  ngOnInit(): void {
  }

}
