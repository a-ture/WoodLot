import {Injectable} from '@angular/core';

//TODO aggiustare le regex
@Injectable({
  providedIn: 'root'
})
export class ValidazioneFormPagamentoService {

  public errori: any;

  //qui vanno messe le regole
  regoleForm = {
    nomeTitolareCarta: '^[a-zA-Z ]+$',
    nomeTitolareCartaMax: 50,
    numeroCartaDiCredito: '^[0-9]$',
    numeroCartaDiCreditoMax: 16,
    cvv: '^[0-9]{3,4}$'
  };

  constructor() {
    this.errori = {
      nomeTitolareCarta: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.nomeTitolareCartaMax}  caratteri`,
        pattern: 'Deve contenere solo lettere dell’alfabeto'
      },
      numeroCartaDiCredito: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.numeroCartaDiCreditoMax} `,
        pattern: 'Il numero della carta di credito inserito non è valido'
      },
      cvv: {
        required: 'Compila questo campo',
        pattern: 'Il cvv inserito non risulta essere valido'
      }

    }
  }
}
