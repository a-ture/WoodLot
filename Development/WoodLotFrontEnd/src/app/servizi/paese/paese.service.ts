import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Paese} from "../../entita/paese/paese";

//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class PaeseService {

  constructor(private http: HttpClient) {
  }

  //restituisce tutti i paesi presenti nel DB
  public getPaesi(): Observable<Paese[]> {
    let url = 'http://localhost:8090/api/prodotto/paesi';
    return this.http.get<Paese[]>(url);
  }

}
