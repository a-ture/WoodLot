import {Component, Input} from '@angular/core';
import {Orso} from "../../../entity/Orso";
import {OrsoService} from "../../../service/orso.service";

@Component({
  selector: 'app-orso-view',
  templateUrl: './orso-view.component.html',
  styleUrls: ['./orso-view.component.scss']
})
export class OrsoViewComponent {

  @Input() orso!:Orso
  public checked:boolean = true;

}
