import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-dove-viene-piantato',
  styleUrls: ['./dove-viene-piantato.component.scss'],
  template: `
    <div class="container text-center mt-1 mb-5">
      <h2>Dove viene piantato</h2>
      <p>{{albero.paese!.descrizione}}</p>
      <img class="img-fluid"
        src="assets/img/paginaProdotto/paeseOrigine/{{albero.paese!.nome}}.png">
    </div>

  `
})
export class DoveVienePiantatoComponent implements OnInit {

  public albero

  constructor(private serviceProdotto: ProdottoService) {
    this.albero = serviceProdotto.getProdottoInformazioni("castagno");
  }

  ngOnInit(): void {
  }

}
