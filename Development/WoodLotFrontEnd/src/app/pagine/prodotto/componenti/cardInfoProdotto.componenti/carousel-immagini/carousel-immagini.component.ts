import {Component, Input, OnInit} from '@angular/core';
import {Albero} from "../../../../../entita/albero/albero";

@Component({
  selector: 'app-carousel-immagini',
  templateUrl: './carousel-immagini.component.html',
  styleUrls: ['./carousel-immagini.component.scss']
})
export class CarouselImmaginiComponent implements OnInit {


  @Input() public albero!:Albero
  public path ="assets/img/alberi/"
  public sourceImage!:any[]

  constructor() {

  }

  ngOnInit(): void {
    this.sourceImage = [
      {id: 1, src: this.path+this.albero.nome.toLowerCase()+"/1.webp", title: this.albero.nome},
      {id: 2, src: this.path+this.albero.nome.toLowerCase()+"/2.webp", title: this.albero.nome},
      {id: 3, src: this.path+this.albero.nome.toLowerCase()+"/3.webp", title: this.albero.nome},

    ]
  }

}
