import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-foto-con-testo-list',
  templateUrl: './foto-con-testo-list.component.html',
  styleUrls: ['./foto-con-testo-list.component.scss']
})
export class FotoConTestoListComponent implements OnInit {

  public listTitoli = [
    "E se un albero muore?", "Una storia da raccontare."
  ]

  public listTesto = [
    "Facciamo tutto il possibile per non far morire neanche un albero, ma in ogni caso se il tuo albero dovesse morire, " +
    "lo sostituiremo e tu potrai seguire la storia del nuovo albero. ",
    "Dalle prime foto nel vivaio fino al momento della piantumazione. Potrai vedere il tuo albero germogliare, crescere," +
    " dare i primi frutti: attraverso il codice univoco potrai infatti monitorare quando fiorirà e assistere alla prima " +
    "produzione di frutta che generalmente avviene dopo circa 3 anni."
  ]

  public listSourceImage = [
    "assets/img/home/07.jpg",
    "assets/img/home/04.jpeg"
  ]

  public listClassi = [
    "col-md-7 col-sm-12", "col-md-7 order-md-2 col-sm-12"
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
