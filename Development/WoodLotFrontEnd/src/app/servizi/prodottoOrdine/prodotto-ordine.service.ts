import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProdottoOrdineService {

  constructor(private http: HttpClient) {
  }

  // restituisce tutti i prodotti ordine che devono essere revisionati dal responsabile ordine
  getProdottiDaRevisionare(): Observable<any> {
    let url = 'http://localhost:8090/api/contadino/alberiDaRevisionare'
    return this.http.get<ProdottoOrdine[]>(url)
  }
}
