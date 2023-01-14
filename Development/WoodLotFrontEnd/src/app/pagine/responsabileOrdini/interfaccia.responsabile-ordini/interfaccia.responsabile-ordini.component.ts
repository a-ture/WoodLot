import {Component, OnInit} from '@angular/core';
import {ResponsabileOrdiniService} from "../../../servizi/responsabileOrdini/responsabile-ordini.service";
import {StatisticheService} from "../../../servizi/statistiche/statistiche.service";

@Component({
  selector: 'app-interfaccia-responsabile-ordini',
  templateUrl: './interfaccia.responsabile-ordini.component.html',
  styleUrls: ['./interfaccia.responsabile-ordini.component.scss']
})
export class InterfacciaResponsabileOrdiniComponent implements OnInit {

  public responsabileOrdini
  public listaNomi = ["Alberi piantati", "Contadini coinvolti", "Ordini Effettuati", "Paesi"]
  public listaNumeri

  public panes = [
    {name: 'Ordini', content: 'One'},
    {name: 'Pagamenti', content: 'Two'},
    {name: 'Contadini', content: 'Three'},
  ];

  activePane = 0;

  constructor(private serviceResponsabileOrdini: ResponsabileOrdiniService, private serviceStatistiche: StatisticheService) {
    this.responsabileOrdini = serviceResponsabileOrdini.getResponsabileOrdini()
    this.listaNumeri = serviceStatistiche.getStatisticheResponsabileOrdini()
  }

  ngOnInit(): void {
  }

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

}
