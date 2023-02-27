import {Injectable} from '@angular/core';
import {Albero} from "../../entita/albero/albero";
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders, HttpParams, HttpRequest} from "@angular/common/http";

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

  //applica i filtri al catalogo
  public applicaFiltri(filtroNome: String, filtroElemento: String): Observable<Albero[]> {
    let url = 'http://localhost:8090/api/filtri/';
    let params = new HttpParams();
    switch (filtroNome) {
      case 'Prezzo':
        url += 'filtroPrezzo/'
        if (filtroElemento === 'Prezzo crescente') {
          url += 'prezzoCrescente'
        } else if (filtroElemento === 'Prezzo decrescente') {
          url += 'prezzoDecrescente';
        }
        break;
      case 'Anidride Carbonica':
        url += 'filtroAndirideCarbonica/'
        if (filtroElemento === 'Meno anidride carbonica assorbita') {
          url += 'anidrideCrescente'
        } else if (filtroElemento === 'Più anidride carbonica assorbita') {
          url += 'anidrideDecrescente'
        }
        break;
      case 'Categorie':
        url += 'filtroCategoria/' + filtroElemento
        break
      case 'Paesi':
        url += 'filtroPaese/' + filtroElemento
        break
      case 'Usi Locali':
        url += 'filtroUsoLocale/' + filtroElemento
        break
    }
    return this.http.get<Albero[]>(url, {params});
  }

  //elimina un prodotto
  public elimina(idProdotto: String) {
    let url = 'http://localhost:8090/api/catalogo/eliminaProdotto/' + idProdotto
    return this.http.get(url)
  }

  public salvaFoto(treeName: string,foto: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', foto, foto.name);
    formData.append('treeName', treeName);
    return this.http.post<any>('http://localhost:8090/api/catalogo/upload', formData);
  }


  //salva il prodotto
  public salvaAlbero(albero: Albero): Observable<any> {
    let url = 'http://localhost:8090/api/catalogo/inserimentoProdotto/'
    return this.http.post(url, albero)
  }
}
