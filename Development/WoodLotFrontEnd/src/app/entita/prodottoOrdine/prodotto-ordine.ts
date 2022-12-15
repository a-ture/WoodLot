export class ProdottoOrdine {
  public codice : number
  public quantita : number
  public prezzo : number
  public destinatarioRegalo : String
  public stato : String
  public dataAssegnazione : Date
  public nome : String
  public coordinateGeografiche : String

  constructor(codice:number, quantita:number, prezzo:number, destinatarioRegalo:String,
              data:Date, stato:String, nome:String, coordinateGeografiche:String) {
    this.codice = codice
    this.dataAssegnazione = new Date()
    this.destinatarioRegalo = destinatarioRegalo
    this.stato = stato
    this.prezzo = prezzo
    this.quantita = quantita
    this.nome = nome
    this.coordinateGeografiche = coordinateGeografiche
  }
}
