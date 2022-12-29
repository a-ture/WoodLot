import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RegistrazioneUtenteComponent} from "../registrazione-utente/registrazione-utente.component";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup
  modalRef: MdbModalRef<RegistrazioneUtenteComponent> | null = null;
  public visible = false;

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

  openModal() {
    this.modalRef = this.modalService.open(RegistrazioneUtenteComponent, this.config)
    this.visible = !this.visible;
  }

  toggleLiveDemo() {
    this.visible = !this.visible;
  }

  handleLiveDemoChange(event: any) {
    this.visible = event;
  }
}
