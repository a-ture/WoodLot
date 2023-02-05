import {Component, OnInit} from '@angular/core';
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormUtenteService
} from "../../../servizi/validazioneFormUtente/validazione-form-utente.service";
import {UtenteRegistrato} from "../../../entita/utenteRegistrato/utente-registrato";
import {AutenticazioneService} from "../../../servizi/autenticazione/autenticazione.service";
import {LoginComponent} from "../login/login.component";
import {RegistrazioneUtenteComponent} from "../registrazione-utente/registrazione-utente.component";

@Component({
  selector: 'app-reimposta-password',
  templateUrl: './reimposta-password.component.html',
  styleUrls: ['./reimposta-password.component.scss']
})
export class ReimpostaPasswordComponent implements OnInit {

  reimpostaPassword: FormGroup
  submitted = false;
  formErrori: any;
  errorMessage: string = '';


  constructor(private serviceAutenticazione: AutenticazioneService, private sericeValidazione: ValidazioneFormUtenteService, public modalRef: MdbModalRef<ReimpostaPasswordComponent>) {
    this.reimpostaPassword = new FormGroup({
      emailUtente: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required,
        Validators.maxLength(sericeValidazione.regoleForm.passwordMin),
        Validators.pattern(sericeValidazione.regoleForm.passwordPattern)]),
      ripetiPassword: new FormControl('', [Validators.required])
    })
  }

  onValidate() {
    this.submitted = true;
    //fermati qui se il modulo non è valido
    return this.reimpostaPassword.status === 'VALID';
  }


  onSubmit(): void {
    if (this.onValidate()) {
      this.errorMessage = ''
      let email = this.reimpostaPassword.get('emailUtente')?.value
      let password = this.reimpostaPassword.get('password')?.value
      let utenteRegistrato = new UtenteRegistrato(email, password)
      this.serviceAutenticazione.reimpostaPassword(utenteRegistrato).subscribe(
        (data) => {
          this.modalRef.close()
        },
        (error) => {
          // visualizza l'errore sotto al form
          this.errorMessage = JSON.stringify(error.error.data);
        }
      );
    }
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.reimpostaPassword.controls;
  }

  ngOnInit(): void {
  }

}
