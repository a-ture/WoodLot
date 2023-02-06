export class ProdottoOrdine {
  public codice: number
  public prezzo: number
  public stato: String
  // possiamo fare che la data assegnazione dopo che è stato efettivamente piantato allora è la data dell'ultima modifca
  public dataAssegnazione: Date
  public nome: String
  public coordinateGeografiche: String
  public co2: number


  constructor(codice: number, prezzo: number,
              data: Date, stato: String, nome: String, coordinateGeografiche: String, co2: number) {
    this.codice = codice
    this.dataAssegnazione = new Date()
    this.stato = stato
    this.prezzo = prezzo
    this.nome = nome
    this.coordinateGeografiche = coordinateGeografiche
    this.co2 = co2

  }
}
