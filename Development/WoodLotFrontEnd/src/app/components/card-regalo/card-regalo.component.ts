import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-card-regalo',
  styleUrls: ['./card-regalo.component.scss'],
  template:`
    <div class="col p-2">
      <div class="card h-100" style="background-color:#C4D89F">
        <div class="text-center">
          <img src="{{sourceimage}}"
               width="93px" height="93px">
        </div>
        <div class="card-body">
          <h5 class="card-title">{{titolo}}</h5>
          <a [cModalToggle]="staticBackdropModal.id" class="card-link" style="color:black">Scopri di più!</a>
        </div>
      </div>
    </div>

    <c-modal #staticBackdropModal backdrop="static" id={{titolo}}>
      <c-modal-header>
        <h2  cModalTitle>{{titoloModal}}</h2>
      </c-modal-header>
      <c-modal-body>
        <img src="{{sourceimage}}" width="98" height="98" class="col m-3">
            <div clas="col-8 text-center">
              {{descrizioneModal}}
            </div>
      </c-modal-body>
      <c-modal-footer>
        <button [cModalToggle]="staticBackdropModal.id" cButton color="secondary" class="w-100"
                style="background-color:#5E7250; color:white">
          Regala un albero!
        </button>
      </c-modal-footer>
    </c-modal>
  `
})
export class CardRegaloComponent implements OnInit {

  @Input()
  public sourceimage !: String

  @Input()
  public titolo !: String

  @Input()
  public titoloModal !: String

  @Input ()
  public descrizioneModal !: String

  constructor() { }

  ngOnInit(): void {
  }


}
