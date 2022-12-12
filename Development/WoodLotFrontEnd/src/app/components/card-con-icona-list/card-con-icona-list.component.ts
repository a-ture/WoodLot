import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-con-icona-list',
  templateUrl: './card-con-icona-list.component.html',
  styleUrls: ['./card-con-icona-list.component.scss']
})
export class CardConIconaListComponent implements OnInit {

  public listTitoli = [
    "Sì, lo paghi una volta sola", "No, non ti arriva a casa l’albero", "No, non ti arriva a casa la frutta",
    "Sì, lo piantiamo davvero", "Sì, lo vedrai crescere online", "Sì, ricevi un certificato PDF"
  ]

  public listDescrizione = [
    "Non ti chiediamo ulteriori pagamenti, ci serve solo un primo contributo per poterlo piantare!",
    "Il germoglio crescerà nel vivaio e poi verrà donato a una famiglia di contadini",
    "Saranno di sostentamento alle famiglie che si prendono cura dell’albero",
    "E puoi vederlo da subito, dai primi giorni che trascorre nel nostro vivaio",
    "Potrai monitorarlo tramite il nostro sistema esclusivo di tracciabilità!",
    "Al momento dell’acquisto riceverai un attestato che attesta la proprietà del tuo albero.",
    "Al momento dell’acquisto riceverai un attestato che attesta la proprietà del tuo albero."
  ]

  public listIcone = [
    "fa-solid fa-money-bill-wave flex-shrink-0 me-3 text-success fs-1",
    "fa-solid fa-house-chimney flex-shrink-0 me-3 text-warning fs-1",
    "fa-solid fa-apple-whole flex-shrink-0 me-3 fs-1 text-danger",
    "fa-solid fa-hand-holding-droplet flex-shrink-0 me-3 fs-1 text-info",
    "fa-solid fa-seedling flex-shrink-0 me-3 fs-1 text-success",
    "fa-solid fa-envelope-open-text flex-shrink-0 me-3 fs-1 text-primary"
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
