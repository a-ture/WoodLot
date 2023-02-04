import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {InclusoNelPrezzoComponent} from "../incluso-nel-prezzo/incluso-nel-prezzo.component";
import {ActivatedRoute} from "@angular/router";
import {Albero} from "../../../../../entita/albero/albero";


@Component({
  selector: 'app-card-info-prodotto',
  templateUrl: './card-info-prodotto.component.html',
  styleUrls: ['./card-info-prodotto.component.scss']
})
export class CardInfoProdottoComponent implements OnInit {

  public albero : Albero | undefined
  modalInclusoNelPrezzo: MdbModalRef<InclusoNelPrezzoComponent> | null = null;

  constructor(private serviceProdotto: ProdottoService, private modalService: MdbModalService, private route: ActivatedRoute) {

    this.route.params.subscribe(params => {
      const nome = params['nomeProdotto'];
      this.serviceProdotto.getProdottoInformazioni(nome).subscribe(data => {
        this.albero = data;
      });
    });
  }

  ngOnInit(): void {

  }

  openModal() {
    this.modalInclusoNelPrezzo = this.modalService.open(InclusoNelPrezzoComponent)
  }
}
