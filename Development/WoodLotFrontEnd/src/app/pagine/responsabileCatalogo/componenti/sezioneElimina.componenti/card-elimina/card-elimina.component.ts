import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";

@Component({
  selector: 'app-card-elimina',
  templateUrl: './card-elimina.component.html',
  styleUrls: ['./card-elimina.component.scss']
})
export class CardEliminaComponent implements OnInit {

  @Input()
  public titolo !: String

  @Input()
  public sourceImage !: String

  @Input()
  public prezzo !: number

  @Input()
  public paese !: String

  public visible = false;

  toggleModal() {
    this.visible = !this.visible;
  }

  handleModal(event: any) {
    this.visible = event;
  }

  @Output()
  productDeleted = new EventEmitter<any>();

  handleConfirmClick(idProdotto: String) {
    this.serviceProdotto.elimina(idProdotto)
      .subscribe(() => {
        this.productDeleted.emit();
      });
    this.toggleModal();
  }


  constructor(private serviceProdotto: ProdottoService) {
  }

  ngOnInit(): void {
  }

}
