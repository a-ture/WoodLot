import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";
import {Contadino} from "../../../../../entita/contadino/contadino";

@Component({
  selector: 'app-elenco-contadini',
  templateUrl: './elenco-contadini.component.html',
  styleUrls: ['./elenco-contadini.component.scss']
})
export class ElencoContadiniComponent implements OnInit {

  public listaContadini !: Contadino[]
  public listaContadiniPaginaCorrente !: Contadino[]
  pageSize = 10;
  currentPage = 1;
  totalItems = 0;
  constructor(private serviceContadini: ContadinoService) {
    serviceContadini.getContadini().subscribe(
      (data) => {
        this.listaContadini = data
        this.totalItems = this.listaContadini.length
        this.updateOrdiniPaginaCorrente();
      }
    )
  }
  updateOrdiniPaginaCorrente() {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.listaContadiniPaginaCorrente = this.listaContadini.slice(startIndex, endIndex);
  }

  onPageChange(pageNumber: number) {
    this.currentPage = pageNumber;
    this.updateOrdiniPaginaCorrente();
  }
  ngOnInit(): void {
  }

}
