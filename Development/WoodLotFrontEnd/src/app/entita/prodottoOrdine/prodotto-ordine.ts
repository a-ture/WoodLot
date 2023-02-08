import {Contadino} from "../contadino/contadino";
import {UsoLocale} from "../usoLocale/uso-locale";
import {Beneficio} from "../beneficio/beneficio";

export class ProdottoOrdine {
  public id: number
  public prezzoUnitario: number
  public stato: String
  public contadino: Contadino | undefined
  public descrizione: String | undefined
  public frutta: number | undefined
  public nomeAlbero: String
  public usiLocali: Array<UsoLocale>
  public benefici: Array<Beneficio>
  public dataAssegnazione: Date | undefined
  public dataModifica: Date | undefined

  constructor(id: number, prezzo: number,
              data: Date, stato: String, nomeAlbero: String, usiLocali: Array<UsoLocale>, benefici: Array<Beneficio>,
              contadino?: Contadino, descrizione?: String, frutta?: number, dataAssegnazione?: Date,
              dataModifica?: Date) {
    this.id = id
    this.dataAssegnazione = dataAssegnazione
    this.stato = stato
    this.prezzoUnitario = prezzo
    this.contadino = contadino
    this.descrizione = descrizione
    this.frutta = frutta
    this.benefici = benefici
    this.nomeAlbero = nomeAlbero
    this.usiLocali = usiLocali
    this.dataModifica = dataModifica
  }
}
