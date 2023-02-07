import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {AutenticazioneService} from "../autenticazione.service";
import {LoginComponent} from "../../../componenti/header.componenti/login/login.component";
import {MdbModalRef, MdbModalService} from "mdb-angular-ui-kit/modal";


@Injectable({
  providedIn: 'root'
})
export class AuthGuardUtente implements CanActivate {

  constructor(private router: Router,
              private serviceAutenticazione: AutenticazioneService,
              private modalService: MdbModalService) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    const requestedPage = state.url;
    if (!this.serviceAutenticazione.eAttivo()) {
      this.router.navigate(['']);
      this.openModalLogin()
      return false;
    } else {
      const storedUtente = sessionStorage.getItem('utente');
      //l'utente in sessione è un utente e vuole accedere a una pagina a cui può accedere
      if (storedUtente && (requestedPage == '/profiloUtente' || requestedPage == '/carrello' || requestedPage == '/checkout')) {
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
