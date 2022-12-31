import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RegistrazioneUtenteComponent} from "../registrazione-utente/registrazione-utente.component";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {ReimpostaPasswordComponent} from "../reimposta-password/reimposta-password.component";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup
  modalRefRegistrazioneUtente: MdbModalRef<RegistrazioneUtenteComponent> | null = null;
  modalRefReimpostaPassword: MdbModalRef<ReimpostaPasswordComponent> | null = null;

  public visibleLogin = false;

  config = {
    backdrop: false,
    ignoreBackdropClick: true
  }

  constructor(private modalService: MdbModalService) {
    this.formLogin = new FormGroup({
      emailUtenteLogin: new FormControl('', Validators.required),
      passwordLogin: new FormControl('', Validators.required)
    })
  }


  ngOnInit(): void {
  }

  onSubmit(): void {
    // TODO: Submit form value
    alert('SUCCESS!');
  }

  openModalRegistrazione() {
    this.modalRefRegistrazioneUtente = this.modalService.open(RegistrazioneUtenteComponent, this.config)
    this.toggleLogin()
  }

  toggleLogin() {
    this.visibleLogin = !this.visibleLogin;
  }

  handleLogin(event: any) {
    this.visibleLogin = event;
  }

  openModalReimpostaPassword() {
    this.modalRefReimpostaPassword = this.modalService.open(ReimpostaPasswordComponent, this.config)
    this.toggleLogin()
  }

}
