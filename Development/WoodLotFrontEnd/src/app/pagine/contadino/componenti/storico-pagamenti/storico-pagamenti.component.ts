import {Component, Input, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../servizi/contadino/contadino.service";
import {Pagamento} from "../../../../entita/pagamento/pagamento";

@Component({
  selector: 'app-storico-pagamenti',
  templateUrl: './storico-pagamenti.component.html',
  styleUrls: ['./storico-pagamenti.component.scss']
})
export class StoricoPagamentiComponent implements OnInit {



  public listaPagamenti !: Pagamento[]

  constructor(private servicePagamento: ContadinoService) {

    servicePagamento.getPagamenti(servicePagamento.getContadino().id).subscribe((data: Pagamento[]) => {
      this.listaPagamenti = data
    })
  }

  ngOnInit(): void {
  }

}
