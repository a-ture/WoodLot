import {Injectable} from '@angular/core';
import {Albero} from "../../entita/albero/albero";
import {Paese} from "../../entita/paese/paese";
import {UsoLocale} from "../../entita/usoLocale/uso-locale";
import {Beneficio} from "../../entita/beneficio/beneficio";
import {Categoria} from "../../entita/categoria/categoria";
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
  public getProdottoInformazioni(nome: String) {
    return new Albero(13.00, 340, "castagno", new Paese("Italia", "Lorem ipsum dolor " +
        "sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
        "Faucibus purus in massa tempor nec feugiat nisl pretium fusce. Eu lobortis elementum nibh tellus molestie. " +
        "Quisque id diam vel quam elementum. In massa tempor nec feugiat. Porta lorem mollis aliquam ut. Quis ipsum " +
        "suspendisse ultrices gravida dictum fusce ut placerat orci. A diam maecenas sed enim ut sem viverra aliquet eget. " +
        "Sit amet volutpat consequat mauris nunc congue nisi vitae suscipit. Nibh ipsum consequat nisl vel pretium."),
      "castagnoru", "Faucibus purus in massa tempor nec feugiat nisl pretium fusce. Eu " +
      "lobortis elementum nibh tellus molestie.Quisque id diam vel quam elementum. In massa tempor nec feugiat. " +
      "Porta lorem mollis aliquam ut. Quis ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
      "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Faucibus purus in massa tempor nec feugiat " +
      "nisl pretium fusce. Eu lobortis elementum nibh tellus molestie. Quisque id diam vel quam elementum. In massa " +
      "tempor nec feugiat. Porta lorem mollis aliquam ut. Quis ipsum suspendisse ultrices gravida dictum fusce ut " +
      "placerat orci. A diam maecenas sed enim ut sem viverra aliquet eget. Sit amet volutpat consequat mauris nunc " +
      "congue nisi vitae suscipit. Nibh ipsum consequat nisl vel pretium.", 5, new Array<UsoLocale>(
        new UsoLocale("Allevamento", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"),
        new UsoLocale("Antivento", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut"),
        new UsoLocale("Vendita", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut")
      ), new Array<Beneficio>(
        new Beneficio("Sicurezza alimentare", "descrizione"),
        new Beneficio("Assorbimento di anidride carbonica", "descrizione"),
      ), new Categoria("categoria", "orem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
        "eiusmod tempor incididunt ut labore et dolore magna aliqua. Faucibus purus in massa tempor nec feugiat nisl " +
        "pretium fusce. Eu lobortis elementum nibh tellus molestie."))
  }
}
