import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from "@angular/router";
import {AutenticazioneService} from "../autenticazione.service";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";
import {Observable} from "rxjs";
import {LoginComponent} from "../../../componenti/header.componenti/login/login.component";

@Injectable({
  providedIn: 'root'
})
export class GuardContadinoService {

  constructor(private router: Router,
              private serviceAutenticazione: AutenticazioneService,
              private modalService: MdbModalService) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (!this.serviceAutenticazione.eAttivo()) {
      this.router.navigate(['']);
      this.openModalLogin()
      return false;
    } else {
      const storedContadino = sessionStorage.getItem('contadino');
      //l'utente in sessione è un contadino e vuole accedere a una pagina a cui può accedere
      if (storedContadino) {
        return true;
      }
      this.router.navigate(['/accessoNegato']);
      return false;
    }
  }

  openModalLogin() {
    this.modalLoginRef = this.modalService.open(LoginComponent, this.config)
  }

  modalLoginRef: MdbModalRef<LoginComponent> | null = null

  config = {
    backdrop: false,
    ignoreBackdropClick: true
  }
}
