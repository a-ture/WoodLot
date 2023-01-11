import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-intestazione',
  styleUrls: ['./intestazione.component.scss'],
  template: `
    <div class="mx-3 row text-center d-flex justify-content-center">
      <h1 class="mt-5 fw-semibold">Chi siamo</h1>
      <p class="fs-5 fw-lighter">La riforestazione è una delle azioni più efficaci nel contrasto alla crisi climatica.
        <br>Noi ci impegniamo a far nascere nuovi alberi nelle regioni del mondo vittime di grandi deforestazioni.</p>
      <img src="assets/img/chiSiamo/01.png" class="w-75">
    </div>
  `
})
export class IntestazioneComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): void {
  }

}
