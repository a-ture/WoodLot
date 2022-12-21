import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-badge',
  styleUrls: ['./badge.component.scss'],
  template: `
    <c-card class="text-center" style="border-color: black;">
      <img cCardImg="top" src="{{sourceImage}}" class="sblocca"  >
      <c-card-body>
        <h5 cCardTitle>{{nome}}</h5>
        <button [cModalToggle]="verticallyCenteredModal.id" cButton>Sblocca</button>
      </c-card-body>
    </c-card>

    <c-modal #verticallyCenteredModal alignment="center" id={{nome}}>
      <c-modal-header>
        <h5 cModalTitle>{{nome}}</h5>
      </c-modal-header>
      <c-modal-body>
        <div class="row d-flex align-items-center">
          <div class="col-4">
            <img src="{{sourceImage}}" cCardImg="top" >
          </div>
          <div class="col-8">
            <p>{{descrizione}}</p>
          </div>
        </div>
      </c-modal-body>
      <c-modal-footer>
        <button [cModalToggle]="verticallyCenteredModal.id" cButton>
          Capito
        </button>
      </c-modal-footer>
    </c-modal>
  `
})
export class BadgeComponent implements OnInit {

  @Input()
  public nome !: String

  @Input()
  public descrizione !: String

  @Input()
  public sourceImage !: String

  constructor() {
  }

  ngOnInit(): void {
  }

}
