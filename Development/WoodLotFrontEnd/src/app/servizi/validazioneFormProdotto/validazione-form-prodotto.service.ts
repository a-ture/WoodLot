import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidazioneFormProdottoService {

  public errori: any;

  //qui vanno messe le regole
  regoleForm = {
    nomeAlbero: '^[a-zA-Z ]+$',
    nomeAlberoMax: 10,
    specieScientificaMax: 30,
    specieScientifca: '^[a-zA-Z ]+$',
    descrizioneMax: 500,
    descizioneBreveMax: 50,
    prezzo: "^\\d+(\\.\\d{2})?$",
    anidrideCarbonica: '^[0-9]+$',
    salvaguardia: '^[1-5]$'
  };

  constructor() {
    this.errori = {
      nomeAlbero: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.nomeAlberoMax}  caratteri`,
        pattern: 'Deve contenere solo lettere dell’alfabeto'
      },
      specieScientifica: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.specieScientificaMax}  caratteri`,
        pattern: 'Deve contenere solo lettere dell’alfabeto'
      },
      anidrideCarbonica: {
        required: 'Compila questo campo',
        pattern: 'Inserisci un numero intero positivo'
      },
      salvaguardia: {
        required: 'Compila questo campo',
        pattern: 'Inserisci un numero intero compreso tra 1 e 5'
      },
      descrizione: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.descrizioneMax}  caratteri`,
      },
      descrzioneBreve: {
        required: 'Compila questo campo',
        maxLength: `La lunghezza massima per questo campo è  ${this.regoleForm.descizioneBreveMax}  caratteri`,
      },
      prezzo: {
        required: 'Compila questo campo',
        pattern: 'Il prezzo inserito non sembra essere valido'
      }
    }
  }
}
