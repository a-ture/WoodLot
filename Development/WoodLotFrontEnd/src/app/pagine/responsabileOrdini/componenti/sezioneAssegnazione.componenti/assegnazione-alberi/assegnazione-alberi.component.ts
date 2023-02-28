import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";

@Component({
  selector: 'app-assegnazione-alberi',
  templateUrl: './assegnazione-alberi.component.html',
  styleUrls: ['./assegnazione-alberi.component.scss']
})
export class AssegnazioneAlberiComponent implements OnInit {

  selectedMenu: String = ""

  goTo(paramText: String) {
    this.selectedMenu = paramText
  }

  public listaAlberi !: ProdottoOrdine[]

  constructor(private serviceContadino: ContadinoService) {
    serviceContadino.getAlberiNonAssegnati().subscribe(
      (data) => {
        this.listaAlberi = data
      }
    )
  }

  ngOnInit(): void {
  }

}
