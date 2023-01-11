import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-elimina',
  templateUrl: './card-elimina.component.html',
  styleUrls: ['./card-elimina.component.scss']
})
export class CardEliminaComponent implements OnInit {

  @Input()
  public titolo !: String

  @Input()
  public sourceImage !: String

  @Input()
  public prezzo !: number

  @Input()
  public paese !: String

  public visible = false;

  toggleModal() {
    this.visible = !this.visible;
  }

  handleModal(event: any) {
    this.visible = event;
  }

  constructor() {
  }

  ngOnInit(): void {
  }

}
