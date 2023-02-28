import {Component, OnInit} from '@angular/core';
import {ProdottoOrdine} from "../../../../../entita/prodottoOrdine/prodotto-ordine";
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";

@Component({
  selector: 'app-riassegnazione-alberi',
  templateUrl: './riassegnazione-alberi.component.html',
  styleUrls: ['./riassegnazione-alberi.component.scss']
})
export class RiassegnazioneAlberiComponent implements OnInit {

  public listaAlberi !: ProdottoOrdine[]

  constructor(private serviceContadino: ContadinoService) {
    serviceContadino.getAlberiDaRiassegnare().subscribe(
      (data) => {
        this.listaAlberi = data
      }
    )
  }

  ngOnInit(): void {
  }

}
