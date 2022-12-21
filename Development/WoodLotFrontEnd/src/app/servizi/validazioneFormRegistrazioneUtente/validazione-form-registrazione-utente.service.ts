import {Injectable} from '@angular/core';

//TODO aggiustare le regex
@Injectable({
  providedIn: 'root'
})
export class ValidazioneFormRegistrazioneUtenteService {

  public errori: any;

  //qui vanno messe le regole
  regoleForm = {
    nonVuota: '^[a-zA-Z0-9]+([_ -]?[a-zA-Z0-9])*$',
    nomeUtenteMax: 25,
    cognomeUtenteMax: 25,
    passwordMin: 8,
    passwordPattern: '(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}'
  };


  constructor() {
    this.errori = {
      nomeUtente: {
        required: 'Il nome utente è richiesto',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.nomeUtenteMax}  caratteri`,
        pattern: 'Deve contenere solo lettere dell’alfabeto'
      },

      cognomeUtente: {
        required: 'Il cognome utente è richiesto',
        maxLength: `La lunghezza massima per questo campo è ${this.regoleForm.cognomeUtenteMax}  caratteri`,
        pattern: 'Deve contenere solo lettere dell’alfabeto'
      },

      emailUtente: {
        required: 'required',
        email: 'Questo indirizzo e-mail non sembra essere valido',
      },
      password: {
        required: 'Password è richiesta',
        pattern: 'La password deve contenere almeno un carattere speciale tra: @, !, #, $.',
        minLength: `La password deve contenere almeno ${this.regoleForm.passwordMin} caratteri`
      },
      confermaPassword: {
        required: 'Conferma password è richiesta',
        passwordMismatch: 'Le password non coincidono'
      },
    };
  }
}
