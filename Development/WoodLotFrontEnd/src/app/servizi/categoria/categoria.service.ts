import {Injectable} from '@angular/core';
import {Categoria} from "../../entita/categoria/categoria";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
//TODO collegamento con il back-end
export class CategoriaService {

  constructor(private http: HttpClient) {
  }

  //restituisce tutte le categorie presenti nel DB
  public getCategorie(): Observable<Categoria[]> {
    let url = 'http://localhost:8090/api/prodotto/categorie';
    return this.http.get<Categoria[]>(url);
  }
}


