import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-rettangolare-con-testo-list',
  templateUrl: './card-rettangolare-con-testo-list.component.html',
  styleUrls: ['./card-rettangolare-con-testo-list.component.scss']
})
export class CardRettangolareConTestoListComponent implements OnInit {

  public listaTitoliBeneficiAmbientali = [
    "Assorbimento CO2 a livello globale",
    "Tutela della biodiversità",
    "Contrasto erosione del suolo e desetificazione",
    "Riforestazione"]

  public listaSourceBeneficiAmbientali = [
    "assets/img/diventaUnContadino/1.jpg",
    "assets/img/diventaUnContadino/3.jpg",
    "assets/img/diventaUnContadino/4.jpg",
    "assets/img/diventaUnContadino/7.jpg"
  ]

  public listaTitoliBeneficiEconomiciESociali = [
    "Finanziamento diretto ai contadini locali",
    "Scelta alberi da piantare fatta insieme ai contadini",
    "Copertura costi fino a fase produttiva albero",
    "Opportunità di reddito"
  ]

  public listaSourceBeneficiEconomiciESociali = [
    "assets/img/diventaUnContadino/8.jpg",
    "assets/img/diventaUnContadino/9.jpg",
    "assets/img/diventaUnContadino/10.jpg",
    "assets/img/diventaUnContadino/11.jpg",
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
