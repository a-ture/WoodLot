import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-filtro',
  styleUrls: ['./filtro.component.scss'],
  template: `
    <c-dropdown direction="dropend">
      <button cButton cDropdownToggle style="background-color:#5E7250; border-color:#5E7250; border-radius: 15px;">
        {{nomeFiltro}}
      </button>
      <ul cDropdownMenu>
        <li><a *ngFor="let element of elementi" cDropdownItem>{{element}}</a></li>
      </ul>
    </c-dropdown>
  `
})
export class FiltroComponent implements OnInit {

  @Input()
  public nomeFiltro !: String

  @Input()
  public elementi !: String[]


  constructor() {
  }

  ngOnInit(): void {
  }

}
