import {Contadino} from "../contadino/contadino";

export class Pagamento {

  public id: number
  public importo: number
  public dataPagamento: Date
  public motivazioni: String
  public contadino: Contadino

  constructor(id: number, importo: number, dataPagamento: Date, motivazioni: String, contadino: Contadino) {
    this.id = id
    this.importo = importo
    this.dataPagamento = dataPagamento
    this.motivazioni = motivazioni
    this.contadino = contadino
  }
}
