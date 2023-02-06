import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ProdottoCarrello} from "../../entita/prodottoCarrello/prodotto-carrello";

//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class CarrelloService {

  constructor(private http: HttpClient) {
  }

  // restituisce il carrello di un utente
  public getCarrello(idUtente: number): Observable<any> {
    let url = 'http://localhost:8090/api/carrello/' + idUtente
    return this.http.get(url);
  }


  public svuotareCarrello(idCarrello: number): Observable<any> {
    let url = 'http://localhost:8090/api/carrello/svuotareCarrello/' + idCarrello
    return this.http.get(url);
  }

  public aggiungereProdotto(prodottoCarrello: ProdottoCarrello, id: number): Observable<any> {
    let url = 'http://localhost:8090/api/carrello/aggiungiProdotto/' + prodottoCarrello.albero.nome + '/' + id
    return this.http.get(url);
  }

  public rimuovereProdotto(idCarrello: number, idProdotto: number): Observable<any> {
    let url = 'http://localhost:8090/api/carrello/rimuoviProdotto/' + idCarrello + '/' + idProdotto+'/'
    return this.http.get(url);
  }
}

