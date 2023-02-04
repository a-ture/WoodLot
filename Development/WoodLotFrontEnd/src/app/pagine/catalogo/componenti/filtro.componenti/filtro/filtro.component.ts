import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-filtro',
  styleUrls: ['./filtro.component.scss'],
  template: `
    <c-dropdown direction="dropend" >
      <button cButton cDropdownToggle style="background-color:#5E7250; border-color:#5E7250; border-radius: 15px;"
              (click)="toggleDropdown()">
        {{nomeFiltro}}
      </button>
      <ul cDropdownMenu  [hidden]="!dropdownOpen">
        <li><a *ngFor="let element of elementi" cDropdownItem (click)="applyFilter(element)" >{{element}}</a></li>
      </ul>
    </c-dropdown>
  `
})
export class FiltroComponent implements OnInit {

  @Input()
  public nomeFiltro !: string

  @Input()
  public elementi !: string[]

  @Output()
  public filterApplied = new EventEmitter<{ filterName: string; filterValue: string; }>();

  public dropdownOpen = false;

  constructor() {
  }

  ngOnInit(): void {
  }

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }

  applyFilter(filter: string) {
    const filterData = {
      filterName: this.nomeFiltro,
      filterValue: filter
    };
    this.filterApplied.emit(filterData);
    this.dropdownOpen = false;

  }

}
