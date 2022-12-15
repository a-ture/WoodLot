import { Component, OnInit } from '@angular/core';

//TODO aggiungere il routing
@Component({
  selector: 'app-menu-laterale',
  templateUrl: './menu-laterale.component.html',
  styleUrls: ['./menu-laterale.component.scss']
})
export class MenuLateraleComponent implements OnInit {

  selectedMenu : String = "Home"

  goTo(paramText:String){
    this.selectedMenu=paramText
  }

  constructor() { }

  ngOnInit(): void {
  }

}
