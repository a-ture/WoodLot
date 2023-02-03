import {Injectable} from '@angular/core';
import {Albero} from "../../entita/albero/albero";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class ProdottoService {

  constructor(private http: HttpClient) {
  }

  //restituisce tutti i prodotti presenti nel DB
  public getProdotti(): Observable<Albero[]> {
    let url = 'http://localhost:8090/api/filtri/prodotti';
    return this.http.get<Albero[]>(url);
  }

  //restituisce un singolo prodotto
  public getProdottoInformazioni(nome: string): Observable<Albero> {
    let url = 'http://localhost:8090/api/prodotto/' + nome;
    return this.http.get<Albero>(url);
  }

}
