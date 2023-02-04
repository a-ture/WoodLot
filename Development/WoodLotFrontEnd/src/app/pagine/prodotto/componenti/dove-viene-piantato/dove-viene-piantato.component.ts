import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../entita/albero/albero";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dove-viene-piantato',
  styleUrls: ['./dove-viene-piantato.component.scss'],
  template: `
    <div class="container text-center mt-1 mb-5">
      <h2>Dove viene piantato</h2>
      <p>{{albero?.paeseOrigine?.descrizione}}</p>
      <img class="img-fluid"
           src="assets/img/paginaProdotto/paeseOrigine/{{albero?.paeseOrigine?.nome}}.png">
    </div>

  `
})
export class DoveVienePiantatoComponent implements OnInit {


  public albero !: Albero

  constructor(private serviceProdotto: ProdottoService,private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const nome = params['nomeProdotto'];
      this.serviceProdotto.getProdottoInformazioni(nome).subscribe(data => {
        this.albero = data;
      });
    });
  }

}
