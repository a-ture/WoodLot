import { Component } from '@angular/core';
import {OrsoService} from "../../../service/orso.service";
import {Orso} from "../../../entity/Orso";

@Component({
  selector: 'app-orso-view-list',
  templateUrl: './orso-view-list.component.html',
  styleUrls: ['./orso-view-list.component.scss']
})
export class OrsoViewListComponent {

  public getAll(){
    return this.orsoService.getOrsi();
  }

  constructor(private orsoService:OrsoService) {
  }
}
