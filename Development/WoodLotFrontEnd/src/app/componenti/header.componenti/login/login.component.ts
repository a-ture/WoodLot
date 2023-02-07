import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {RegistrazioneUtenteComponent} from "../registrazione-utente/registrazione-utente.component";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {ReimpostaPasswordComponent} from "../reimposta-password/reimposta-password.component";
import {AutenticazioneService} from "../../../servizi/autenticazione/autenticazione.service";
import {UtenteRegistrato} from "../../../entita/utenteRegistrato/utente-registrato";
import {Router} from "@angular/router";
import {Carrello} from "../../../entita/carrello/carrello";
import {CarrelloService} from "../../../servizi/carrello/carrello.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup
  modalRefRegistrazioneUtente: MdbModalRef<RegistrazioneUtenteComponent> | null = null;
  modalRefReimpostaPassword: MdbModalRef<ReimpostaPasswordComponent> | null = null;

  errorMessage: string = '';

  config = {
    backdrop: false,
    ignoreBackdropClick: true
  }


  constructor(public modalRef: MdbModalRef<LoginComponent>, private serviceCarrello: CarrelloService, private router: Router, private modalService: MdbModalService, private autenticazioneService: AutenticazioneService) {
    this.formLogin = new FormGroup({
      emailUtenteLogin: new FormControl('', Validators.required),
      passwordLogin: new FormControl('', Validators.required)
    })
  }


  ngOnInit(): void {
  }

  onSubmit(): void {
    this.errorMessage = ''
    let email = this.formLogin.get('emailUtenteLogin')?.value
    let password = this.formLogin.get('passwordLogin')?.value
    let utenteRegistrato = new UtenteRegistrato(email, password)
    this.autenticazioneService.login(utenteRegistrato).subscribe(
      (data) => {
        console.log(data)
        if (data.data.utente != null) {
          // salva i dati dell'utente in sessione
          sessionStorage.setItem('utente', JSON.stringify(data.data.utente));
          sessionStorage.setItem('utenteRegistrato', JSON.stringify(data.data.utente));
          //recuperiamo i dati del suo carrello
          this.serviceCarrello.getCarrello(data.data.utente.id).subscribe(
            (data: Carrello) => {
              console.log(data)
              let carrello = data
              sessionStorage.setItem("carrello", JSON.stringify(carrello))
            });

          // reindirizza alla pagina del profilo dell'utente
          this.modalRef.close()
          this.router.navigate(['/profiloUtente']);
        } else if (data.data.contadino != null) {
          // salva i dati del contadino in sessione
          sessionStorage.setItem('contadino', JSON.stringify(data.data.contadino));
          sessionStorage.setItem('utenteRegistrato', JSON.stringify(data.data.contadino));
          // reindirizza alla pagina del profilo del contadino
          this.modalRef.close()
          this.router.navigate(['/profiloContadino']);
        } else if (data.data.responsabileOrdini != null) {
          // salva i dati del responsabile ordini in sessione
          sessionStorage.setItem('responsabileOrdini', JSON.stringify(data.data.responsabileOrdini));
          sessionStorage.setItem('utenteRegistrato', JSON.stringify(data.data.responsabileOrdini));
          // reindirizza alla pagina del profilo del responsabile ordini
          this.modalRef.close()
          this.router.navigate(['/profiloResponsabileOrdini']);
        } else {
          // salva i dati del responsabile catalogo
          sessionStorage.setItem('responsabileCatalogo', JSON.stringify(data.data.responsabileCatalogo));
          sessionStorage.setItem('utenteRegistrato', JSON.stringify(data.data.responsabileCatalogo));
          // reindirizza alla pagina del profilo del responsabile catalogo
          this.modalRef.close()
          this.router.navigate(['/profiloResponsabileCatalogo']);
        }
      },
      (error) => {
        // visualizza l'errore sotto al form di login
        this.errorMessage = JSON.stringify(error.error.data);
      }
    );
  }

  openModalRegistrazione() {
    this.modalRefRegistrazioneUtente = this.modalService.open(RegistrazioneUtenteComponent, this.config)
    this.modalRef.close()
  }

  openModalReimpostaPassword() {
    this.modalRefReimpostaPassword = this.modalService.open(ReimpostaPasswordComponent, this.config)
    this.modalRef.close()
  }

}
