import {Component, Input, OnInit} from '@angular/core';
import {Albero} from "../../../../../entita/albero/albero";

@Component({
  selector: 'app-carousel-immagini',
  templateUrl: './carousel-immagini.component.html',
  styleUrls: ['./carousel-immagini.component.scss']
})
export class CarouselImmaginiComponent implements OnInit {


  @Input() public nome !: String
  public path ="assets/img/alberi/"
  public sourceImage!:any[]

  constructor() {

  }

  ngOnInit(): void {
    this.sourceImage = [
      {id: 1, src: this.path+this.nome.toLowerCase().replace(' ','')+"/1.webp", title: this.nome},
      {id: 2, src: this.path+this.nome.toLowerCase().replace(' ','')+"/2.webp", title: this.nome},
      {id: 3, src: this.path+this.nome.toLowerCase().replace(' ','')+"/3.webp", title: this.nome},

    ]
  }

}
