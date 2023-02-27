export class Pagamento {

  public id: number
  public importo: number
  public dataPagamento: Date
  public motivazioni: String


  constructor(id: number, importo: number, dataPagamento: Date, motivazioni: String) {
    this.id = id
    this.importo = importo
    this.dataPagamento = dataPagamento
    this.motivazioni = motivazioni
  }
}
