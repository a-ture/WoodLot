import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {
  ValidazioneFormUtenteService
} from "../../../servizi/validazioneFormUtente/validazione-form-utente.service";
import {MdbModalRef} from "mdb-angular-ui-kit/modal";
import {UtenteService} from "../../../servizi/utente/utente.service";
import {Utente} from "../../../entita/utente/utente";
import {Ordine} from "../../../entita/ordine/ordine";
import {Router} from "@angular/router";

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
        Validators.maxLength(25),
        Validators.pattern(sericeValidazione.regoleForm.nonVuota)]),
      cognomeUtente: new FormControl('', [Validators.required,
        Validators.maxLength(25),
        Validators.pattern(sericeValidazione.regoleForm.nonVuota)]),
      emailUtente: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required,
        Validators.minLength(sericeValidazione.regoleForm.passwordMin),
        Validators.pattern(sericeValidazione.regoleForm.passwordPattern)]),
      ripetiPassword: new FormControl('', [Validators.required])
    })
    // @ts-ignore
    this.formRegistrazioneUtente.get('ripetiPassword').setValidators([
      Validators.required,
      this.matchingPasswordValidator.bind(this)
    ]);
    this.formErrori = this.sericeValidazione.errori;
  }

  // Funzione validatrice personalizzata per controllare se le password corrispondono
  matchingPasswordValidator(control: AbstractControl): { [key: string]: boolean } | null {
    // @ts-ignore
    const password = this.formRegistrazioneUtente.get('password').value;

    return password && control.value !== password ? {'passwordMismatch': true} : null;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    let utente;
    console.log("eerad")
    if (this.onValidate()) {
      this.errorMessage = ''
      console.log("valido")
      let nome = this.formRegistrazioneUtente.get('nomeUtente')?.value
      let cognome = this.formRegistrazioneUtente.get('cognomeUtente')?.value
      let email = this.formRegistrazioneUtente.get('emailUtente')?.value
      let password = this.formRegistrazioneUtente.get('password')?.value
      let ordini = new Array<Ordine>()
      utente = new Utente(nome, cognome, ordini, email, password)
      console.log(utente)
      this.serviceUtente.registrazione(utente).subscribe(
        (data) => {
          console.log(data)
          // salva i dati dell'utente in sessione
          sessionStorage.setItem('utente', JSON.stringify(data));
          // reindirizza alla pagina del profilo dell'utente
          this.router.navigate(['/profiloUtente']);
          // chiudi la modal
          this.modalRef.close();
        },
        (error) => {
          // visualizza l'errore sotto al form di registrazione
          console.log(error.error)
          this.errorMessage = JSON.stringify(error.error.data);
        }
      );
    }
  }

  onValidate() {
    this.submitted = true;
    //fermati qui se il modulo non è valido
    return this.formRegistrazioneUtente.status === 'VALID';
  }


  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.formRegistrazioneUtente.controls;
  }

}
