import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-sezione-assegnazione',
  templateUrl: './sezione-assegnazione.component.html',
  styleUrls: ['./sezione-assegnazione.component.scss']
})
export class SezioneAssegnazioneComponent implements OnInit {
  selectedMenu: String = "Riassegnazione alberi"

  goTo(paramText: String) {
    this.selectedMenu = paramText
  }

  constructor() {

  }

  ngOnInit(): void {
  }

}
