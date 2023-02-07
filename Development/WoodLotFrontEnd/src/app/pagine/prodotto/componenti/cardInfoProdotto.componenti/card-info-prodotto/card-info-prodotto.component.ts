import {Component, OnInit} from '@angular/core';
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {InclusoNelPrezzoComponent} from "../incluso-nel-prezzo/incluso-nel-prezzo.component";
import {ActivatedRoute, Router} from "@angular/router";
import {Albero} from "../../../../../entita/albero/albero";
import {ProdottoCarrello} from "../../../../../entita/prodottoCarrello/prodotto-carrello";
import {CarrelloService} from "../../../../../servizi/carrello/carrello.service";
import {Carrello} from "../../../../../entita/carrello/carrello";


@Component({
  selector: 'app-card-info-prodotto',
  templateUrl: './card-info-prodotto.component.html',
  styleUrls: ['./card-info-prodotto.component.scss']
})
export class CardInfoProdottoComponent implements OnInit {

  public albero!: Albero
  errorMessage: string = ''
  modalInclusoNelPrezzo: MdbModalRef<InclusoNelPrezzoComponent> | null = null;

  constructor(private router: Router, private serviceCarrello: CarrelloService, private serviceProdotto: ProdottoService, private modalService: MdbModalService, private route: ActivatedRoute) {

    this.route.params.subscribe(params => {
      const nome = params['nomeProdotto'];
      this.serviceProdotto.getProdottoInformazioni(nome).subscribe((data) => {
        this.albero = data;
      });
    });
  }

  ngOnInit(): void {

  }

  openModal() {
    this.modalInclusoNelPrezzo = this.modalService.open(InclusoNelPrezzoComponent)
  }

  acquista() {
    this.errorMessage = ''
    const storedCarrello = sessionStorage.getItem('carrello');
    sessionStorage.removeItem('carrello')
    if (this.albero != undefined && storedCarrello != null) {
      let carrello = JSON.parse(storedCarrello)

      let prodottoCarrello = new ProdottoCarrello(this.albero, carrello)
      carrello.prodottiCarrello.push(prodottoCarrello)
      console.log(carrello)
      this.serviceCarrello.aggiungereProdotto(prodottoCarrello, carrello.id).subscribe(
        (data: Carrello) => {
          carrello = data
          sessionStorage.setItem("carrello", JSON.stringify(carrello))
          this.router.navigate(['/carrello']);
        },
        (error) => {
          this.errorMessage = JSON.stringify(error)
        }
      );
    }
  }
}
