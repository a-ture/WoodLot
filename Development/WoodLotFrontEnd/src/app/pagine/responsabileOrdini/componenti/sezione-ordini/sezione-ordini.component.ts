import {Component, OnInit} from '@angular/core';
import {OrdineService} from "../../../../servizi/ordine/ordine.service";
import {Ordine} from "../../../../entita/ordine/ordine";

@Component({
  selector: 'app-sezione-ordini',
  templateUrl: './sezione-ordini.component.html',
  styleUrls: ['./sezione-ordini.component.scss']
})
export class SezioneOrdiniComponent implements OnInit {

  public listaOrdini !: Ordine[]
  public ordiniPaginaCorrente !: Ordine[];
  pageSize = 3;
  currentPage = 1;
  totalItems = 0;

  constructor(private serviceOrdini: OrdineService) {
    serviceOrdini.getOrdini().subscribe(
      (data) => {
        this.listaOrdini = data
        this.totalItems = this.listaOrdini.length
        this.updateOrdiniPaginaCorrente();
      }
    )
  }


  updateOrdiniPaginaCorrente() {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.ordiniPaginaCorrente = this.listaOrdini.slice(startIndex, endIndex);
  }

  onPageChange(pageNumber: number) {
    this.currentPage = pageNumber;
    this.updateOrdiniPaginaCorrente();
  }

  ngOnInit(): void {

  }

}
