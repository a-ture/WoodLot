import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidazioneFormAggiornamentoStatoService {
  public errori: any;

  //qui vanno messe le regole
  regoleForm = {
    descizioneBreveMax: 50,
    quantitaFrutta: "/^[0-9]+(.[0-9]+)?$/\n"
  };

  constructor() {
    this.errori = {
      descrzioneBreve: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.descizioneBreveMax}  caratteri`,
      },
      quantitaFrutta: {
        required: 'Compila questo campo',
        pattern: 'Deve contenere solo numeri'
      },
    }
  }
}
