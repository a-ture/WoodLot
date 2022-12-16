import {Component, Input, OnInit} from '@angular/core';
import {Foresta} from "../../../../../entita/foresta/foresta";

@Component({
  selector: 'app-card-foresta-list',
  templateUrl: './card-foresta-list.component.html',
  styleUrls: ['./card-foresta-list.component.scss']
})
export class CardForestaListComponent implements OnInit {

  @Input()
  public listaAlberiForesta !: Foresta[]

  public listaSourceImage = [
    "assets/img/profiloUtente/foreste/foresta.jpeg",
    "assets/img/profiloUtente/foreste/foresta1.png"
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
