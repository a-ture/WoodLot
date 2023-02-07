import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
//TODO bisogna effettuare il collegamento con il back-end
export class StatisticheService {

  constructor(private http: HttpClient) {
  }

  // restituisce le statistiche per la pagina diventa un contadino e per il profilo responsabile catalogo
  public getStatistiche(): Observable<any> {
    let url = 'http://localhost:8090/api/statistiche/responsabileCatalogo'
    return this.http.get(url)
  }

  //restituisce le statistiche per la pagina del contadino
  public getStatischeContadino(idContadino: number): Observable<any> {
    let url = 'http://localhost:8090/api/statistiche/contadino/' + idContadino
    return this.http.get(url)
  }

  //restituisce le statistiche per la pagina del responsabile ordini
  public getStatisticheResponsabileOrdini() {
    return ["97", "98", "78", "54"]
  }
}
