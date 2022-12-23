import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-come-funziona',
  templateUrl: './come-funziona.component.html',
  styleUrls: ['./come-funziona.component.scss']
})
export class ComeFunzionaComponent implements OnInit {

  public listaTitoli = [
    "Scegli un albero", "Il contadino ne trae beneficio", "Tu lo vedi crescere"
  ]

  public listaDescrizioni = [
    "Scegli quale albero adottare virtualmente tra quelli che trovi nel nostro shop!",

    "L’albero viene donato a una famiglia contadina che se ne occupa, che raccogliendo " +
    "la frutta prodotta, riceverà sicurezza alimentare e una nuova fonte di guadagno.",

    "Ricevi aggiornamenti fotografici periodici dal tuo albero"
  ]

  public listaIcone = [
    "fa-solid fa-tree flex-shrink-0 me-3 text-success fs-1",
    "fa-solid fa-apple-whole flex-shrink-0 me-3 text-danger fs-1",
    "fa-solid fa-photo-film flex-shrink-0 me-3 text-info fs-1",
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}
