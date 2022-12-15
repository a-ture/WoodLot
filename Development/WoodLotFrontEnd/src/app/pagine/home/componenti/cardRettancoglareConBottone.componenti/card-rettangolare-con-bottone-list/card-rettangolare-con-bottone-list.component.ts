import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-rettangolare-con-bottone-list',
  templateUrl: './card-rettangolare-con-bottone-list.component.html',
  styleUrls: ['./card-rettangolare-con-bottone-list.component.scss']
})
export class CardRettangolareConBottoneListComponent implements OnInit {

  public listCosaPuoiFare = [
    "Regala", "Pianta", "Crea il tuo WoodLot"
  ]

  public listSourceImage = [
    "assets/img/home/13.png",
    "assets/img/home/12.png",
    "assets/img/home/11.svg"
  ]

  public listDescrizione = [
    "Un regalo originale per l’ambiente e per le persone a cui vuoi bene",
    "Tante specie ognuna con le sue caratteristiche ed i suoi poteri",
    "Pianta alberi e crea il tuo bosco virtuale",
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
