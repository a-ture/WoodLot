import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {InclusoNelPrezzoComponent} from "../incluso-nel-prezzo/incluso-nel-prezzo.component";

@Component({
  selector: 'app-card-info-prodotto',
  templateUrl: './card-info-prodotto.component.html',
  styleUrls: ['./card-info-prodotto.component.scss']
})
export class CardInfoProdottoComponent implements OnInit {

  public albero
  modalInclusoNelPrezzo: MdbModalRef<InclusoNelPrezzoComponent> | null = null;

  constructor(private serviceProdotto: ProdottoService, private modalService: MdbModalService) {
    this.albero = serviceProdotto.getProdottoInformazioni("castagno");
  }

  ngOnInit(): void {
  }

  openModal(){
    this.modalInclusoNelPrezzo = this.modalService.open(InclusoNelPrezzoComponent)
  }
}
