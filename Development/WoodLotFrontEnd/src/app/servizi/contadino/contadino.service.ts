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
    console.log(contadino)
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
  public getPagamenti(idContadino: number): Observable<any> {
    let url = 'http://localhost:8090/api/pagamento/elencoPagamenti/' + idContadino
    return this.http.get(url)
  }
}
