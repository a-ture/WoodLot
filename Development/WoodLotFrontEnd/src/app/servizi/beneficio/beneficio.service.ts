import {Injectable} from '@angular/core';
import {Beneficio} from "../../entita/beneficio/beneficio";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BeneficioService {

  constructor(private http: HttpClient) {
  }

  // restituisce tutti i benefici presenti nel DB
  public getBenefici():Observable<Beneficio[]> {
    let url = 'http://localhost:8090/api/prodotto/benefici';
    return this.http.get<Beneficio[]>(url);
  }
}
