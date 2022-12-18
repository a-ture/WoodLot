import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-foto-con-testo-sovrapposto',
  styleUrls: ['./foto-con-testo-sovrapposto.component.scss'],
  template: `
    <div
      class="p-5 text-center bg-image"
      style="
      background-image: url('assets/img/home/08.JPG');
      height: 400px;
    "
    >
      <div class="mask">
        <div class="d-flex justify-content-center align-items-center h-100">
          <div class="text-white">
            <h1 class="mb-3">Questo Natale regala un albero per il futuro</h1>
            <h4 class="m-3 fst-italic">Ci sono tanti alberi e ciascuno ha il proprio significato.
              Scegli quello giusto per la persona giusta e regalalo con un click.</h4>
            <a class="btn btn-outline-light btn-lg" href="#!" role="button">
              Scegli e regala</a>
          </div>
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
