import {ProdottoOrdine} from "../prodottoOrdine/prodotto-ordine";

export class Contadino {

  public nome: String
  public cognome: String
  public listaAlberi: ProdottoOrdine[]
  public id: number
  public coordinateGeografiche: String
  public titolareConto: String
  public swift: String

  constructor(nome: String, cognome: String, listaAlberi: ProdottoOrdine[], id: number, coordinateGeografiche: String,
              titolareConto: String, swift: String) {
    this.nome = nome
    this.cognome = cognome
    this.listaAlberi = listaAlberi
    this.id = id
    this.coordinateGeografiche = coordinateGeografiche
    this.titolareConto = titolareConto
    this.swift = swift
  }
}
