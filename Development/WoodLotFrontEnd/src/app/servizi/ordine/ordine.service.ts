import {Injectable} from '@angular/core';
import {Ordine} from "../../entita/ordine/ordine";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class OrdineService {

  constructor(private http: HttpClient) {
  }

  // questo metodo restituisce tutti gli ordini presenti nel database
  public getOrdini(): Observable<Ordine[]> {
    let url = 'http://localhost:8090/api/ordine/getOrdini'
    return this.http.get<Ordine[]>(url)
  }

  //questo metodo salva un ordine nel database
  public effettuaOrdine(id: number): Observable<any> {
    let url = 'http://localhost:8090/checkout'
    return this.http.post(url, id);
  }
}
