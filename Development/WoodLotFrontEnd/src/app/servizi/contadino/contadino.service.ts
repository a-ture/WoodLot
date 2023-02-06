import {Injectable} from '@angular/core';
import {Contadino} from "../../entita/contadino/contadino";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";
import {Pagamento} from "../../entita/pagamento/pagamento";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ContadinoService {

  constructor(private http: HttpClient) {
  }

  // restituisce un contadino
  public getContadino() {
    let contadino !: Contadino
    const storedContadino = sessionStorage.getItem('contadino');
    if (storedContadino) {
      contadino = JSON.parse(storedContadino);
    }
    return contadino;
  }

  //restituisce l'elenco di tutti i contadini presenti
  public getContadini(): Observable<Contadino[]> {
    let url = 'http://localhost:8090/api/contadino'
    return this.http.get<Contadino[]>(url)
  }

  //restituisci tutti gli alberi non ancora assegnati a un contadino
  public getAlberiNonAssegnati(): Observable<ProdottoOrdine[]> {
    let url = 'http://localhost:8090/api/contadino/alberiNonAssegnati'
    return this.http.get<ProdottoOrdine[]>(url)
  }

  // restuisce tutti i pagamenti di un contadini
  public getPagamenti() {
    return [
      new Pagamento(1, 20, new Date(), "Albero 1"),
      new Pagamento(2, 30, new Date(), "Albero 2"),
      new Pagamento(3, 40, new Date(), "Albero 3"),
      new Pagamento(4, 20, new Date(), "Albero 4"),
      new Pagamento(5, 50, new Date(), "Albero 5"),
      new Pagamento(6, 10, new Date(), "Albero 6"),
      new Pagamento(7, 20, new Date(), "Albero 7"),
      new Pagamento(8, 30, new Date(), "Albero 8"),
      new Pagamento(9, 220, new Date(), "Albero 9"),
    ]
  }
}
