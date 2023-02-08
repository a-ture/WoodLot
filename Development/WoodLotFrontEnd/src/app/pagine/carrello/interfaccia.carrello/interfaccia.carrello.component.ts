import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../servizi/carrello/carrello.service";
import {Carrello} from "../../../entita/carrello/carrello";
import {Router} from "@angular/router";


@Component({
  selector: 'app-interfaccia-carrello',
  templateUrl: './interfaccia.carrello.component.html',
  styleUrls: ['./interfaccia.carrello.component.scss']
})
export class InterfacciaCarrelloComponent implements OnInit {

  public error: string = ''
  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"

  public carrello !: Carrello

  constructor(private serviceCarrello: CarrelloService, private router: Router) {
    const storedCarrello = sessionStorage.getItem('carrello');
    if (storedCarrello != null) {
      this.carrello = JSON.parse(storedCarrello)
      console.log(this.carrello)
    }
  }


  public getTotale() {
    let conta = 0
    this.carrello.prodottiCarrello.forEach(e => {
      conta += e.albero.prezzo
    });
    return conta
  }

  public getTasse() {
    return (this.getTotale() * 22) / 100
  }

  public getTotaleSenzaTasse() {
    return this.getTotale() - this.getTasse()
  }

  public svuotaCarrello() {
    sessionStorage.removeItem('carrello')
    this.serviceCarrello.svuotareCarrello(this.carrello.id).subscribe(
      (data: Carrello) => {
        this.carrello = data
        console.log(data)
        sessionStorage.setItem('carrello', JSON.stringify(this.carrello));

      })
  }

  handleProductDeletedCart() {
    const storedCarrello = sessionStorage.getItem('carrello');
    if (storedCarrello != null) {
      this.carrello = JSON.parse(storedCarrello)
      console.log(this.carrello)
    }
  }

  vaiAlPagamento() {
    if (this.carrello.prodottiCarrello.length == 0)
      this.error = 'Il tuo carrello è vuoto! Aggiungi almeno un prodotto prima di continuare'
  }

  ngOnInit(): void {

  }

}
