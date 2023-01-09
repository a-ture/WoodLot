import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ValidationErrors, Validators} from "@angular/forms";
import {
  ValidazioneFormUtenteService
} from "../../../servizi/validazioneFormUtente/validazione-form-utente.service";
import {MdbModalRef} from "mdb-angular-ui-kit/modal";


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


  constructor(private sericeValidazione: ValidazioneFormUtenteService, public modalRef: MdbModalRef<RegistrazioneUtenteComponent>) {
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
      ripetiPassword: new FormControl('', [Validators.required])
    })
    this.formErrori = this.sericeValidazione.errori;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    if (this.onValidate()) {
      // TODO: Submit form value
      console.warn(this.formRegistrazioneUtente.value);
      alert('SUCCESS!');
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
