import {Injectable} from '@angular/core';
import {UsoLocale} from "../../entita/usoLocale/uso-locale";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class UsoLocaleService {

  constructor(private http: HttpClient) {
  }

  // restituisce tutti gli usi locali presenti nel DB
  public getUsiLocali(): Observable<UsoLocale[]> {
    let url = 'http://localhost:8090/api/prodotto/usiLocali';
    return this.http.get<UsoLocale[]>(url);
  }
}
