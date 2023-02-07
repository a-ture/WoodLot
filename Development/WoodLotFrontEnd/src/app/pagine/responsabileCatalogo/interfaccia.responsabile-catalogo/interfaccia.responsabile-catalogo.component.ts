import {Component, OnInit} from '@angular/core';
import {ResponsabileCatalogoService} from "../../../servizi/responsabileCatalogo/responsabile-catalogo.service";
import {StatisticheService} from "../../../servizi/statistiche/statistiche.service";
import {ProdottoService} from "../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../entita/albero/albero";

@Component({
  selector: 'app-interfaccia-responsabile-catalogo',
  templateUrl: './interfaccia.responsabile-catalogo.component.html',
  styleUrls: ['./interfaccia.responsabile-catalogo.component.scss']
})
export class InterfacciaResponsabileCatalogoComponent implements OnInit {

  public responsabileCatalogo
  public listaNumeri !: string[]
  public listNomi = ["Alberi piantati", "Tonnellate di anidride carbonica assorbite", "Contadini coinvolti", "Paesi"]
  public listaProdotti !: Albero[]

  public panes = [
    {name: 'Aggiungi', content: 'One'},
    {name: 'Elimina', content: 'Two'},
  ];

  activePane = 0;

  constructor(private serviceResponsabileCatalogo: ResponsabileCatalogoService,
              private serviceStatistiche: StatisticheService, private serviceProdotto: ProdottoService) {
    this.responsabileCatalogo = serviceResponsabileCatalogo.getResponsabileCatalogo()
    serviceStatistiche.getStatistiche().subscribe((data: string[]) => {
      this.listaNumeri = data
    })
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaProdotti = alberi;
    })
  }

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

  ngOnInit(): void {
  }

}
