import {Injectable} from '@angular/core';
import {Utente} from "../../entita/utente/utente";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ordine} from "../../entita/ordine/ordine";


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
  public getStatisticheUtente(idUtente: number):Observable<any> {
    let url = 'http://localhost:8090/api/statistiche/utente/' + idUtente
    return this.http.get(url)
  }

  //recupera un utente dalla sessione
  public getUtente() {
    let utente!: Utente;
    const storedUtente = sessionStorage.getItem('utente');
    if (storedUtente) {
      utente = JSON.parse(storedUtente);
    }
    if (utente.id) {
      this.storicoOrdini(utente.id).subscribe(
        (data: Ordine[]) => {
          utente.listaOrdini = data
          console.log(utente)
        }
      )
    }
    return utente;
  }

  public storicoOrdini(id: number): Observable<any> {
    let url = 'http://localhost:8090/api/ordine/storicoUtente/' + id
    return this.http.get(url)
  }
}
