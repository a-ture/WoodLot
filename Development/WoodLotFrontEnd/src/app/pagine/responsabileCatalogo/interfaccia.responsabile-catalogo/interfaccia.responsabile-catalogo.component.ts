import {Component, OnInit} from '@angular/core';
import {ResponsabileCatalogoService} from "../../../servizi/responsabileCatalogo/responsabile-catalogo.service";
import {StatisticheService} from "../../../servizi/statistiche/statistiche.service";
import {ProdottoService} from "../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-interfaccia-responsabile-catalogo',
  templateUrl: './interfaccia.responsabile-catalogo.component.html',
  styleUrls: ['./interfaccia.responsabile-catalogo.component.scss']
})
export class InterfacciaResponsabileCatalogoComponent implements OnInit {

  public responsabileCatalogo
  public listaNumeri
  public listNomi = ["Alberi piantati", "Tonnellate di CO2 assorbite", "Contadini coinvolti", "Paesi"]
  public listaProdotti

  constructor(private serviceResponsabileCatalogo: ResponsabileCatalogoService,
              private serviceStatistiche: StatisticheService, private serviceProdotti: ProdottoService) {
    this.responsabileCatalogo = serviceResponsabileCatalogo.getResponsabileCatalogo()
    this.listaNumeri = serviceStatistiche.getStatistiche()
    this.listaProdotti = serviceProdotti.getProdotti();
  }

  public panes = [
    {name: 'Aggiungi', content: 'One'},
    {name: 'Elimina', content: 'Two'},
  ];

  activePane = 0;

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

  ngOnInit(): void {
  }

}
