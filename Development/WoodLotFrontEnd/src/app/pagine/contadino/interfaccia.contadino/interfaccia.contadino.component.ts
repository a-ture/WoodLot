import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../servizi/contadino/contadino.service";
import {StatisticheService} from "../../../servizi/statistiche/statistiche.service";
import {ProdottoOrdine} from "../../../entita/prodottoOrdine/prodotto-ordine";
import {Contadino} from "../../../entita/contadino/contadino";

@Component({
  selector: 'app-interfaccia-contadino',
  templateUrl: './interfaccia.contadino.component.html',
  styleUrls: ['./interfaccia.contadino.component.scss']
})
export class InterfacciaContadinoComponent implements OnInit {

  public contadino !: Contadino
  public listaNumeri !: string[]
  public listNomi = ["Alberi piantati", "Frutti raccolti", "kg di anidride carbonica assorbita"]
  public listAlberiContadino !: ProdottoOrdine[]

  constructor(private contadinoService: ContadinoService, private statisticheService: StatisticheService) {
    this.contadino = contadinoService.getContadino()
    statisticheService.getStatischeContadino(this.contadino.id).subscribe((data: string[]) => {
      this.listaNumeri = data
    })
    contadinoService.getAlberiContadini(this.contadino.id).subscribe((data: ProdottoOrdine[]) => {
      this.listAlberiContadino = data
    })
  }

  public panes = [
    {name: 'Assegnati', content: 'One'},
    {name: 'Piantato', content: 'Two'},
    {name: 'Bocciolo', content: 'Three'},
    {name: 'Fiore', content: 'Four'},
    {name: 'Frutto', content: 'Five'},
    {name: 'Dormienza', content: 'Sixe'},
  ];

  activePane = 0;

  onTabChange($event: number) {
    this.activePane = $event;
    console.log('onTabChange', $event);
  }

  getAlberiPerStato(stato: String) {
    let lista = new Array<ProdottoOrdine>()
    this?.listAlberiContadino?.forEach(e => {
      if (e.stato === stato)
        lista.push(e)
    })
    return lista
  }

  ngOnInit(): void {
  }

}
