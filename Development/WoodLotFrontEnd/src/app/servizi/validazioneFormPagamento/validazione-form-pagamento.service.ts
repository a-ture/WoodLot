import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidazioneFormPagamentoService {

  public errori: any;

  //qui vanno messe le regole
  regoleForm = {
    nomeTitolareCarta: '^[A-Z][a-zA-Z]*\\s[A-Z][a-zA-Z]*$',
    nomeTitolareCartaMax: 50,
    numeroCartaDiCreditoMax: 16,
    cvv: '^[0-9]{3}(?:[0-9]{1})?$'
  };

  constructor() {
    this.errori = {
      nomeTitolareCarta: {
        required: 'Compila questo campo',
        maxLength: 'La lunghezza massima per questo campo è 50 caratteri',
        pattern: 'Inserisci un nome valido, separa il nome e il cognome con uno spazio'
      },
      numeroCartaDiCredito: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.numeroCartaDiCreditoMax} `,
        pattern: 'Le carte accettate per il pagamento sono solo: Visa, MasterCard o American Express'
      },
      cvv: {
        required: 'Compila questo campo',
        pattern: 'Il cvv inserito non risulta essere valido'
      }

    }
  }
}
