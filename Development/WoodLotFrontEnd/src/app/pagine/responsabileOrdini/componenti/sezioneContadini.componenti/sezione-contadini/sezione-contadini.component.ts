import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-sezione-contadini',
  templateUrl: './sezione-contadini.component.html',
  styleUrls: ['./sezione-contadini.component.scss']
})
export class SezioneContadiniComponent implements OnInit {
  selectedMenu: String = "Elenco contadini"

  goTo(paramText: String) {
    this.selectedMenu = paramText
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
