import {UsoLocale} from "../usoLocale/uso-locale";
import {Paese} from "../paese/paese";
import {Beneficio} from "../beneficio/beneficio";
import {Categoria} from "../categoria/categoria";

export class Albero {

  public prezzo : number
  public anidrideCarbonicaAssorbita: number
  public nome: String
  public paese: Paese | undefined
  public nomeScientifico: String | undefined
  public breveDescrizione: String | undefined
  public descrizione: String | undefined
  public salvaguardiaAmbientale: number | undefined
  public usiLocali: Array<UsoLocale> | undefined
  public benefici: Array<Beneficio> | undefined
  public categoria: Categoria | undefined



  constructor(prezzo: number, co2: number, nome: String, paese?: Paese,
              nomeScientifico?: String, breveDescrizione?: String, descrizione?:String, salvaguardiaAmbientale?: number,
              usiLocali?: Array<UsoLocale>, benefici?: Array<Beneficio>, categoria?:Categoria) {
    this.prezzo = prezzo;
    this.anidrideCarbonicaAssorbita = co2;
    this.nome = nome;
    this.paese = paese;
    this.nomeScientifico = nomeScientifico;
    this.breveDescrizione = breveDescrizione;
    this.descrizione = descrizione;
    this.salvaguardiaAmbientale = salvaguardiaAmbientale;
    this.usiLocali = usiLocali;
    this.benefici = benefici;
    this.categoria = categoria;

  }


}
