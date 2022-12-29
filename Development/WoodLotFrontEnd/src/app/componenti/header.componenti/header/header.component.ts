import {Component, OnInit} from '@angular/core';
import {UtenteService} from "../../../servizi/utente/utente.service";
import {Utente} from "../../../entita/utente/utente";
import {CarrelloService} from "../../../servizi/carrello/carrello.service";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  public utente: Utente | null
  public elementiInCarrello

  //controlliamo se l'utente è loggato -> cosi possiamo cambiare dinamicamente i btn (logout/accedi)
  //controlliamo se l'utente ha almeno un articolo nel carrello per cambiare l'icon del carrello
  constructor(private serviceUtente: UtenteService, private serviceCarrello: CarrelloService) {
    this.utente = serviceUtente.eAttivo() //l' ho lasciato per vedere come si coporta se non è presente un utente
   // this.utente= serviceUtente.getUtente()
    this.elementiInCarrello = serviceCarrello.getCarrello().length
  }

  ngOnInit(): void {
  }

}
