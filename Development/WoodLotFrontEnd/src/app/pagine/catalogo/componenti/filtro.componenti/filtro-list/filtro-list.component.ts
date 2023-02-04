import {Component, OnInit} from '@angular/core';
import {CategoriaService} from "../../../../../servizi/categoria/categoria.service";
import {UsoLocaleService} from "../../../../../servizi/usoLocale/uso-locale.service";
import {PaeseService} from "../../../../../servizi/paese/paese.service";
import {Categoria} from "../../../../../entita/categoria/categoria";
import {Paese} from "../../../../../entita/paese/paese";
import {UsoLocale} from "../../../../../entita/usoLocale/uso-locale";
import {ProdottoService} from "../../../../../servizi/prodotto/prodotto.service";
import {Albero} from "../../../../../entita/albero/albero";

@Component({
  selector: 'app-filtro-list',
  templateUrl: './filtro-list.component.html',
  styleUrls: ['./filtro-list.component.scss']
})
export class FiltroListComponent implements OnInit {

  public listNomiFiltri = [
    "Prezzo", "Anidride Carbonica", "Categorie", "Paesi", "Usi Locali"
  ]

  public listPrezzo = [
    "Prezzo crescente", "Prezzo decrescente"
  ]

  public listCO2 = [
    "Meno anidride carbonica assorbita", "Più anidride carbonica assorbita"
  ]

  public listFiltri = new Array(5)
  public listaCategorie !: Categoria[]
  public listaPaesi !: Paese[]
  public listaUsiLocali !: UsoLocale[]
  public urlBase = "assets/img/alberi/"
  public endBase = "/catalogo.webp"
  public listaAlberi !: Albero[];

  constructor(private serviceCategorie: CategoriaService, private serviceUsiLocali: UsoLocaleService,
              private serviceProdotto: ProdottoService, private servicePaese: PaeseService) {
    this.servicePaese.getPaesi().subscribe(data => {
      this.listaPaesi = data;
      this.populateListFiltri();
    });
    this.serviceUsiLocali.getUsiLocali().subscribe(data => {
      this.listaUsiLocali = data;
      this.populateListFiltri();
    });
    this.serviceCategorie.getCategorie().subscribe(data => {
      this.listaCategorie = data;
      this.populateListFiltri();
    });
    this.serviceProdotto.getProdotti().subscribe(alberi => {
      this.listaAlberi = alberi;
    });
  }

  populateListFiltri() {
    if (!this.listaCategorie || !this.listaPaesi || !this.listaUsiLocali) {
      return;
    }

    let listUsiLocali = new Array<String>();
    let listCategorie = new Array<String>();
    let listPaesi = new Array<String>();

    this.listaCategorie.forEach(e => {
      listCategorie.push(e.nome);
    });

    this.listaPaesi.forEach(e => {
      listPaesi.push(e.nome);
    });

    this.listaUsiLocali.forEach(e => {
      listUsiLocali.push(e.nome);
    });

    this.listFiltri = [this.listPrezzo, this.listCO2, listCategorie, listPaesi, listUsiLocali];
  }

  ngOnInit(): void {

  }

  onFilterApplied(filterData: { filterName: any; filterValue: String; }) {
    console.log(filterData.filterName);
    console.log(filterData.filterValue);
    this.serviceProdotto.applicaFiltri(filterData.filterName, filterData.filterValue).subscribe(alberi => {
      this.listaAlberi = alberi;
    });
  }
}
