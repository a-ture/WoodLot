import {Injectable} from '@angular/core';
import {Utente} from "../../entita/utente/utente";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


// TODO aggiungere collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class UtenteService {

  constructor(private http: HttpClient) {
  }

  //registra un utente
  public registrazione(utente: Utente): Observable<any> {
    let url = 'http://localhost:8090/api/registrazione/registrazioneUtente'
    return this.http.post<any>(url, utente);
  }

  //restituisce le statistiche relative a un utente
  public getStatisticheUtente() {
    return ["34", "45", "65"]
  }

  //recupera un utente dalla sessione
  public getUtente() {
    let utente!: Utente;
    const storedUtente = sessionStorage.getItem('utente');
    if (storedUtente) {
      utente = JSON.parse(storedUtente);
    }
    return utente;
  }
}
