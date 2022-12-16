import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-foto-con-bottone',
  templateUrl: './foto-con-bottone.component.html',
  styleUrls: ['./foto-con-bottone.component.scss']
})
//TODO aggiungire il collegamento al bottone
export class FotoConBottoneComponent implements OnInit {

  public listaImmagini = [
    "../../../../../assets/img/diventaUnContadino/25.jpg",
    "../../../../../assets/img/diventaUnContadino/24.jpg",
    "../../../../../assets/img/diventaUnContadino/2.jpg",
    "../../../../../assets/img/diventaUnContadino/6.jpg",
    "../../../../../assets/img/diventaUnContadino/5.jpg",
    "../../../../../assets/img/diventaUnContadino/37.jpg",
    "../../../../../assets/img/diventaUnContadino/17.jpg",
    "../../../../../assets/img/diventaUnContadino/22.jpg",
    "../../../../../assets/img/diventaUnContadino/23.jpg",
    "../../../../../assets/img/diventaUnContadino/19.jpg",
    "../../../../../assets/img/diventaUnContadino/20.jpg",
    "../../../../../assets/img/diventaUnContadino/21.jpg",
    "../../../../../assets/img/diventaUnContadino/18.jpg",
    "../../../../../assets/img/diventaUnContadino/12.jpg"
  ]

  constructor() { }

  ngOnInit(): void {

  }

}
