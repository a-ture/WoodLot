import {UsoLocale} from "../usoLocale/uso-locale";
import {Paese} from "../paese/paese";
import {Beneficio} from "../beneficio/beneficio";
import {Categoria} from "../categoria/categoria";

export class Albero {

  public prezzo: number
  public anidrideCarbonicaAssorbita: number
  public nome: String
  public specieScientifica: String | undefined
  public descrizioneBreve: String | undefined
  public descrizione: String | undefined
  public salvaguardia: number | undefined
  public usiLocali: Array<UsoLocale> | undefined
  public benefici: Array<Beneficio> | undefined
  public categoria: Categoria | undefined
  public paeseOrigine: Paese | undefined

  constructor(prezzo: number, co2: number, nome: String,
              nomeScientifico?: String, breveDescrizione?: String, descrizione?: String, salvaguardiaAmbientale?: number,
              usiLocali?: Array<UsoLocale>, benefici?: Array<Beneficio>, categoria?: Categoria, paeseOrigine?: Paese) {
    this.prezzo = prezzo;
    this.anidrideCarbonicaAssorbita = co2;
    this.nome = nome;
    this.specieScientifica = nomeScientifico;
    this.descrizioneBreve = breveDescrizione;
    this.descrizione = descrizione;
    this.salvaguardia = salvaguardiaAmbientale;
    this.usiLocali = usiLocali;
    this.benefici = benefici;
    this.categoria = categoria;
    this.paeseOrigine = paeseOrigine;
  }

}
