import {Component, OnInit} from '@angular/core';
import {UtenteService} from "../../../servizi/utente/utente.service";
import {Utente} from "../../../entita/utente/utente";
import {CarrelloService} from "../../../servizi/carrello/carrello.service";
import {AutenticazioneService} from "../../../servizi/autenticazione/autenticazione.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  public attivo: boolean
  public elementiInCarrello: boolean = false

  //controlliamo se l'utente è loggato -> cosi possiamo cambiare dinamicamente i btn (logout/accedi)
  //controlliamo se l'utente ha almeno un articolo nel carrello per cambiare l'icon del carrello
  constructor(private router: Router, private autenticazioneService: AutenticazioneService, private serviceCarrello: CarrelloService) {
    this.attivo = autenticazioneService.eAttivo() //l' ho lasciato per vedere come si comporta se non è presente un utente
    const storedCarrello = sessionStorage.getItem('carrello');
    if (storedCarrello != null) {
      this.elementiInCarrello = true
    }
  }

  ngOnInit(): void {
  }

  logout() {
    this.autenticazioneService.logout()
    this.router.navigate(['']);
  }
}
