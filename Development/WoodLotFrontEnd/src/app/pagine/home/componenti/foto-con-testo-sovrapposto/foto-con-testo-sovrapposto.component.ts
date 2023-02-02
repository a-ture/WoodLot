import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-foto-con-testo-sovrapposto',
  styleUrls: ['./foto-con-testo-sovrapposto.component.scss'],
  template: `
    <div
      class="p-5 text-center bg-image"
      style="
      background-image: url('assets/img/home/08.jpeg');
      height: 680px;
    ">
      <div class="d-flex justify-content-center align-items-center h-100">
        <div class="text-white my-4 py-4" style="background-color: rgba(0, 0, 0, 0.6);">
          <h1 class="mb-3">Pianta un albero!</h1>
          <h4 class="m-3 fst-italic">Siamo il primo sito che ti
            permette di piantare un albero a distanza e seguire online la
            storia del progetto che contribuirà a realizzare. Piantando i
            tuoi alberi sosterrai comunità di contadini locali e renderai più
            verde il nostro pianeta.</h4>
          <a class="btn btn-outline-light btn-lg" href="#!" role="button">
            Scegli</a>
        </div>
      </div>
    </div>

  `
})
export class FotoConTestoSovrappostoComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

}
