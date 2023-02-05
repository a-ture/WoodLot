import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {
  ValidazioneFormUtenteService
} from "../../../servizi/validazioneFormUtente/validazione-form-utente.service";
import {MdbModalRef} from "mdb-angular-ui-kit/modal";
import {UtenteService} from "../../../servizi/utente/utente.service";
import {Utente} from "../../../entita/utente/utente";
import {Ordine} from "../../../entita/ordine/ordine";
import {Router} from "@angular/router";


export function confirmPasswordValidator(control: FormGroup): ValidationErrors | null {
  const password = control.get('password');
  const ripetiPassword = control.get('ripetiPassword');
  return password?.value && password?.value === ripetiPassword?.value
    ? null
    : {passwordMismatch: true};
};

@Component({
  selector: 'app-registrazione-utente',
  templateUrl: './registrazione-utente.component.html',
  styleUrls: ['./registrazione-utente.component.scss']
})
export class RegistrazioneUtenteComponent implements OnInit {

  formRegistrazioneUtente: FormGroup
  submitted = false;
  formErrori: any;
  errorMessage: string = '';

  constructor(private router: Router, private serviceUtente: UtenteService, private sericeValidazione: ValidazioneFormUtenteService, public modalRef: MdbModalRef<RegistrazioneUtenteComponent>) {
    this.formRegistrazioneUtente = new FormGroup({
      nomeUtente: new FormControl('', [Validators.required,
        Validators.maxLength(sericeValidazione.regoleForm.nomeUtenteMax),
        Validators.pattern(sericeValidazione.regoleForm.nonVuota)]),
      cognomeUtente: new FormControl('', [Validators.required,
        Validators.maxLength(sericeValidazione.regoleForm.cognomeUtenteMax),
        Validators.pattern(sericeValidazione.regoleForm.nonVuota)]),
      dataDiNascitaUtente: new FormControl('', Validators.required),
      emailUtente: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required,
        Validators.maxLength(sericeValidazione.regoleForm.passwordMin),
        Validators.pattern(sericeValidazione.regoleForm.passwordPattern)]),
      ripetiPassword: new FormControl('', [Validators.required]),
      dataNascita: new FormControl('')
    })
    this.formErrori = this.sericeValidazione.errori;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    let utente;
    if (this.onValidate()) {
      let nome = this.formRegistrazioneUtente.get('nomeUtente')?.value
      let cognome = this.formRegistrazioneUtente.get('cognomeUtente')?.value
      let email = this.formRegistrazioneUtente.get('emailUtente')?.value
      let password = this.formRegistrazioneUtente.get('password')?.value
      let ordini = new Array<Ordine>()
      let data = this.formRegistrazioneUtente.get('dataDiNascitaUtente')?.value
      utente = new Utente(nome, cognome, ordini, email, password, data)
      this.serviceUtente.registrazione(utente).subscribe(
        (data) => {
          // salva i dati dell'utente in sessione
          sessionStorage.setItem('utente', JSON.stringify(data));
          // reindirizza alla pagina del profilo dell'utente
          this.router.navigate(['/profiloUtente']);
          // chiudi la modal
          this.modalRef.close();
        },
        (error) => {
          // visualizza l'errore sotto al form di registrazione
          this.errorMessage = JSON.stringify(error.error.data);
        }
      );
    }
  }

  onValidate() {
    this.submitted = true;
    return this.formRegistrazioneUtente.status === 'VALID';
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formRegistrazioneUtente.controls;
  }

}
