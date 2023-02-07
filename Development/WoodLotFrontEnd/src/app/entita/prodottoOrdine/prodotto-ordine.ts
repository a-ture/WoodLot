import {Albero} from "../albero/albero";
import {Contadino} from "../contadino/contadino";

export class ProdottoOrdine {
  public id: number
  public prezzoUnitario: number
  public stato: String
  // possiamo fare che la data assegnazione dopo che è stato effettivamente piantato allora è la data dell'ultima modifica
  public dataAssegnazione: Date
  public albero: Albero
  public contadino: Contadino | undefined
  public descrizione: String | undefined
  public frutta: number | undefined

  constructor(id: number, prezzo: number,
              data: Date, stato: String, albero: Albero, contadino?: Contadino, descrizione?: String, frutta?: number) {
    this.id = id
    this.dataAssegnazione = new Date()
    this.stato = stato
    this.prezzoUnitario = prezzo
    this.albero = albero
    this.contadino = contadino
    this.descrizione = descrizione
    this.frutta = frutta
  }
}
