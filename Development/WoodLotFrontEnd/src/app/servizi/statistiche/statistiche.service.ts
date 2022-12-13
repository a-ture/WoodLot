import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
//TODO bisogna effettuare il collegamento con il back-end
export class StatisticheService {

  constructor() { }

  public getStatistiche(){
    return ["452525", "87678", "452", "4"]
  }
}
