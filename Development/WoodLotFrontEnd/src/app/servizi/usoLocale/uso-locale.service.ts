import {Injectable} from '@angular/core';
import {UsoLocale} from "../../entita/usoLocale/uso-locale";

//TODO collegamento con il back-end
@Injectable({
  providedIn: 'root'
})
export class UsoLocaleService {

  constructor() {
  }

  // restituisce tutti gli usi locali presenti nel DB
  public getUsiLocali() {
    return [
      new UsoLocale("Allevamento", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Antivento", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Biodiversità", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Vendita", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Cosmesi", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Insetticida", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Medicina", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Recinzione", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
      new UsoLocale("Suolo", "Le foglie, le radici, la corteccia e/o i frutti vengono usati nella medicina tradizionale."),
    ]
  }
}
