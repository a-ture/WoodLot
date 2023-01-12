import { Component, OnInit } from '@angular/core';
import {MdbModalRef} from "mdb-angular-ui-kit/modal";

@Component({
  selector: 'app-incluso-nel-prezzo',
  templateUrl: './incluso-nel-prezzo.component.html',
  styleUrls: ['./incluso-nel-prezzo.component.scss']
})
export class InclusoNelPrezzoComponent implements OnInit {

  constructor(public modalRef: MdbModalRef<InclusoNelPrezzoComponent>) { }

  ngOnInit(): void {
  }

}
