export class Pagamento {

  public id: number
  public importo: number
  public dataPagamento: Date
  public motivazione: String


  constructor(id: number, importo: number, dataPagamento: Date, motivazione: String) {
    this.id = id
    this.importo = importo
    this.dataPagamento = dataPagamento
    this.motivazione = motivazione
  }
}
