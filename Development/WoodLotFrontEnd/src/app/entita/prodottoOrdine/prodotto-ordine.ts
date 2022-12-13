export class ProdottoOrdine {
  public codice : number
  public quantita : number
  public prezzo : number
  public destinatarioRegalo : String
  public stato : String
  public data : Date

  constructor(codice:number, quantita:number, prezzo:number, destinatarioRegalo:String,
              data:Date, stato:String) {
    this.codice = codice
    this.data = new Date()
    this.destinatarioRegalo = destinatarioRegalo
    this.stato = stato
    this.prezzo = prezzo
    this.quantita = quantita
  }
}
