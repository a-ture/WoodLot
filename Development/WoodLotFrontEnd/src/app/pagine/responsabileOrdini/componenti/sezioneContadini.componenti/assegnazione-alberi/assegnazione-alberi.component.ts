import {Component, OnInit} from '@angular/core';
import {ContadinoService} from "../../../../../servizi/contadino/contadino.service";

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

  public listaAlberi

  constructor(private serviceContadino: ContadinoService) {
    this.listaAlberi = serviceContadino.getAlberiNonAssegnati()
  }

  ngOnInit(): void {
  }

}
