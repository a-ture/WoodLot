import {Component, OnInit} from '@angular/core';
import {MdbModalRef} from "mdb-angular-ui-kit/modal";

@Component({
  selector: 'app-ordine-effettuato',
  templateUrl: './ordine-effettuato.component.html',
  styleUrls: ['./ordine-effettuato.component.scss']
})
export class OrdineEffettuatoComponent implements OnInit {


  constructor(public modalRef: MdbModalRef<OrdineEffettuatoComponent>) {
  }

  ngOnInit(): void {
  }

}
