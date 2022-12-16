import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-immagine',
  styleUrls: ['./immagine.component.scss'],
  template: `
    <c-card>
      <img [cCardImg] src="{{sourceImage}}" >
    </c-card>
  `
})
export class ImmagineComponent implements OnInit {

  @Input()
  public sourceImage!: String



  constructor() { }

  ngOnInit(): void {
  }

}
