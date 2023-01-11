import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../servizi/contadino/contadino.service";
import {StatisticheService} from "../../../servizi/statistiche/statistiche.service";
import {ProdottoOrdine} from "../../../entita/prodottoOrdine/prodotto-ordine";

class ArrayList<T> {
}

@Component({
  selector: 'app-interfaccia-contadino',
  templateUrl: './interfaccia.contadino.component.html',
  styleUrls: ['./interfaccia.contadino.component.scss']
})
export class InterfacciaContadinoComponent implements OnInit {

  public contadino
  public listaNumeri
  public listNomi = ["Alberi piantati", "Frutti raccolti", "Anidride Carbonica"]
  public listAlberiContadino

  constructor(private contadinoService: ContadinoService, private statisticheService: StatisticheService) {
    this.contadino = contadinoService.getContadino()
    this.listaNumeri = statisticheService.getStatischeContadino()
    this.listAlberiContadino = contadinoService.getAlberiContadino()
  }

  public panes = [
    {name: 'Piantato', content: 'One'},
    {name: 'Bocciolo', content: 'Two'},
    {name: 'Fiore', content: 'Three'},
    {name: 'Frutto', content: 'Four'},
    {name: 'Dormienza', content: 'Five'},
  ];

  activePane = 0;

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

  getAlberiPerStato(stato: String) {
    let lista = new Array<ProdottoOrdine>()
    this.listAlberiContadino.forEach(e => {
      if (e.stato == stato)
        lista.push(e)
    })

    return lista
  }

  ngOnInit(): void {
  }

}
