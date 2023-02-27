import {Injectable} from '@angular/core';
import {Contadino} from "../../entita/contadino/contadino";
import {ProdottoOrdine} from "../../entita/prodottoOrdine/prodotto-ordine";
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
    this.getAlberiContadini(contadino.id).subscribe((data: ProdottoOrdine[]) => {
        contadino.listaAlberi = data;
      }
    )
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

  // restituisce tutti i pagamenti di un contadini
  public getPagamenti(idContadino: number): Observable<any> {
    let url = 'http://localhost:8090/api/pagamento/elencoPagamenti/' + idContadino
    return this.http.get(url)
  }

  //restituisce gli alberi di un contadino
  public getAlberiContadini(idContadino: number): Observable<any> {
    let url = 'http://localhost:8090/api/contadino/alberiContadino/' + idContadino
    return this.http.get(url)
  }

  //salva la foto dell'albero
  public salvaFoto(idContadino: string, foto: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', foto, foto.name);
    formData.append('contadinoId', idContadino);
    return this.http.post<any>('http://localhost:8090/api/contadino/upload', formData);
  }

  //aggiornare lo stato dell'albero
  public aggiornaStato(albero: ProdottoOrdine): Observable<any> {
    let url = 'http://localhost:8090/api/contadino/aggiornaStato/'
    return this.http.post(url, albero)
  }
}
