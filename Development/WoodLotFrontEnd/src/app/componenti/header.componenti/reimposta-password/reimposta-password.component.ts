import {Component, OnInit} from '@angular/core';
import {MdbModalRef} from "mdb-angular-ui-kit/modal";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {
  ValidazioneFormUtenteService
} from "../../../servizi/validazioneFormRegistrazioneUtente/validazione-form-utente.service";

@Component({
  selector: 'app-reimposta-password',
  templateUrl: './reimposta-password.component.html',
  styleUrls: ['./reimposta-password.component.scss']
})
export class ReimpostaPasswordComponent implements OnInit {

  reimpostaPassword: FormGroup
  submitted = false;
  formErrori: any;

  constructor(private sericeValidazione: ValidazioneFormUtenteService, public modalRef: MdbModalRef<ReimpostaPasswordComponent>) {
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
      // TODO: Submit form value
      console.warn(this.reimpostaPassword.value);
      alert('SUCCESS!');
    }
  }

  //getter per un facile accesso ai campi del modulo
  get f() {
    return this.reimpostaPassword.controls;
  }

  ngOnInit(): void {
  }

}
