import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../servizi/contadino/contadino.service";

@Component({
  selector: 'app-storico-pagamenti',
  templateUrl: './storico-pagamenti.component.html',
  styleUrls: ['./storico-pagamenti.component.scss']
})
export class StoricoPagamentiComponent implements OnInit {

  public listaPagamenti

  constructor(private servicePagamento: ContadinoService) {
    this.listaPagamenti = servicePagamento.getPagamenti()
  }

  ngOnInit(): void {
  }

}
