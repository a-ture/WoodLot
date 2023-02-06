import {Injectable} from '@angular/core';
import {Utente} from "../../entita/utente/utente";
import {HttpClient} from "@angular/common/http";
import {UtenteRegistrato} from "../../entita/utenteRegistrato/utente-registrato";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AutenticazioneService {

  constructor(private http: HttpClient) {
  }

  //effettua il logout
  logout() {
    const storedUtente = sessionStorage.getItem('utente');
    if (storedUtente != null) {
      sessionStorage.removeItem('utente');
      //eliminiamo il suo carrello dalla sessione e lo salviamo nel db
      sessionStorage.removeItem('carrello')
    }
    const storedContadino = sessionStorage.getItem('contadino');
    if (storedContadino != null)
      sessionStorage.removeItem('contadino');

    const storedResponsabileCatalogo = sessionStorage.getItem('responsabileCatalogo');
    if (storedResponsabileCatalogo != null)
      sessionStorage.removeItem('responsabileCatalogo');

    const storedResponsabileOrdini = sessionStorage.getItem('responsabileOrdini');
    if (storedResponsabileOrdini != null)
      sessionStorage.removeItem('responsabileOrdini');

    sessionStorage.removeItem('utenteRegistrato');
  }

  //controlla se un utente è loggato, restuisce l'utente se è presente in sessione, null altrimenti
  public eAttivo(): boolean {
    const storedUtente = sessionStorage.getItem('utenteRegistrato');
    return storedUtente !== null;
  }

  //effettua il login
  public login(utente: UtenteRegistrato): Observable<any> {
    return this.http.post('http://localhost:8090/api/autenticazione/login', utente);
  }

  public reimpostaPassword(utente: UtenteRegistrato): Observable<any> {
    return this.http.post('http://localhost:8090/api/autenticazione/reimpostarePassword', utente);
  }
}
