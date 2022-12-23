import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-perche-woodlot',
  templateUrl: './perche-woodlot.component.html',
  styleUrls: ['./perche-woodlot.component.scss']
})
export class PercheWoodlotComponent implements OnInit {

  public listaTitoli = [
    "I nostri alberi",
    "Benefici sociali",
    "Benefici ambientali",
    "Fare la differenza"
  ]

  public listaTesto = [
    "I nostri alberi sono piantati in progetti agroforestali che favoriscono l’interazione virtuosa tra diverse specie " +
    "ed un uso sostenibile delle risorse e dei terreni.",
    "Le comunità rurali coinvolte nei nostri progetti ricevono formazione e sostegno finanziario. Sono loro a prendersi cura degli alberi e a godere dei loro frutti.",
    "Tutti gli alberi fanno bene all’ambiente: assorbono anidride carbonica, " +
    "emettono ossigeno, favoriscono la biodiversità, contrastano l’erosione del terreno e molto altro.",
    "La nostra filosofia è quella di realizzare ecosistemi sostenibili e permettere ai contadini di far fronte ai costi" +
    " iniziali della piantumazione degli alberi, garantendo sovranità alimentare ed opportunità di reddito.",
  ]

  public listaSource = [
    "fa-solid fa-leaf",
    "fa-solid fa-lemon",
    "fa-solid fa-cloud",
    "fa-solid fa-people-carry-box"
  ]

  public listaColore = [
    "success",
    "warning",
    "info",
    "reset"
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
