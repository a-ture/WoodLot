import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-ciclo-di-vita-albero',
  styleUrls: ['./ciclo-di-vita-albero.component.scss'],
  template: `
    <div class="py-5">
      <h1 class="mt-2 text-center">Il ciclo di vita di un albero Woodlot</h1>
      <div class=" d-flex justify-content-center mt-5">
        <img src="assets/img/catalogo/cicloDiVita.png" class=" col-8">
      </div>
    </div>
    <h3 class="mx-5 my-3 text-center">Regala un albero, rendi il pianeta più verde</h3>
    <div class=" row mx-4">
      <app-foto-con-testo [sourceImage]="'assets/img/catalogo/01.jpg'"
                          [descrizione]="'Pensa al regalo più bello che ti abbiano mai fatto.Cosa lo ha reso così ' +
                           'speciale? Probabilmente era inaspettato, e aveva un significato particolare che lo ha reso ' +
                            'perfetto proprio per te. Stai cercando un regalo così? Vorresti che durasse nel tempo, ' +
                             'e creasse un filo invisibile fra te e chi lo riceve? Ci sono infinite occasioni in cui regalare un albero può ' +
                           'diventare l’idea in più con cui stupire le persone che ami. Regala un albero. Raggiungi chiunque, ' +
                            'in qualsiasi momento, con un pensiero che va dritto al cuore.'"
                          [class]="'col-md-7 col-sm-12'"
      ></app-foto-con-testo>
    </div>
  `
})
export class CicloDiVitaAlberoComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

}
