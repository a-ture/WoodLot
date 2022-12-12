export class ProdottoCarrello {
  public quantita : number
  public  nome : String
  public regalo : boolean
  public prezzo : number

  constructor(quantita : number, nome : String, regalo : boolean, prezzo : number) {
    this.prezzo = prezzo
    this.quantita = quantita
    this.nome = nome
    this.regalo = regalo
  }
}
