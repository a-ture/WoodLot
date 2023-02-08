import {Component, OnInit} from '@angular/core';
import {CarrelloService} from "../../../servizi/carrello/carrello.service";
import {AutenticazioneService} from "../../../servizi/autenticazione/autenticazione.service";
import {Router} from "@angular/router";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {LoginComponent} from "../login/login.component";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  public attivo: boolean
  public elementiInCarrello: boolean = false

  modalLoginRef: MdbModalRef<LoginComponent> | null = null

  config = {
    backdrop: false,
    ignoreBackdropClick: true
  }
  //controlliamo se l'utente è loggato -> cosi possiamo cambiare dinamicamente i btn (logout/accedi)
  //controlliamo se l'utente ha almeno un articolo nel carrello per cambiare l'icon del carrello
  constructor(private modalService: MdbModalService, private router: Router, private autenticazioneService: AutenticazioneService, private serviceCarrello: CarrelloService) {
    this.attivo = autenticazioneService.eAttivo() //l' ho lasciato per vedere come si comporta se non è presente un utente
    const storedCarrello = sessionStorage.getItem('carrello');
    if (storedCarrello != null) {
      let carrello = JSON.parse(storedCarrello)
      if (carrello.prodottiCarrello?.length > 0)
        this.elementiInCarrello = true
    }
  }

  ngOnInit(): void {

  }

  logout() {
    this.autenticazioneService.logout()
    this.router.navigate(['']);
  }

  openModalLogin() {
    this.modalLoginRef = this.modalService.open(LoginComponent, this.config)
  }

  // questo metodo reindirizza ciascun utente alla sua pagina profilo in base al ruolo
  profilo() {
    const storedUtente = sessionStorage.getItem('utente');
    if (storedUtente)
      this.router.navigate(["/profiloUtente"])

    const storedResponsabileOrdini = sessionStorage.getItem('responsabileOrdini');
    if (storedResponsabileOrdini)
      this.router.navigate(["/profiloResponsabileOrdini"])

    const storedResponsabileCatalogo = sessionStorage.getItem('responsabileCatalogo');
    if (storedResponsabileCatalogo)
      this.router.navigate(["/profiloResponsabileCatalogo"])

    const storedContadino = sessionStorage.getItem('contadino');

    if (storedContadino)
      this.router.navigate(["/profiloContadino"])
  }
}
