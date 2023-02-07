import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {InterfacciaHomeComponent} from "./pagine/home/interfaccia.home/interfaccia.home.component";
import {InterfacciaCatalogoComponent} from "./pagine/catalogo/interfaccia.catalogo/interfaccia.catalogo.component";
import {InterfacciaCarrelloComponent} from "./pagine/carrello/interfaccia.carrello/interfaccia.carrello.component";
import {InterfacciaChiSiamoComponent} from "./pagine/chiSiamo/interfaccia.chi-siamo/interfaccia.chi-siamo.component";
import {
  InterfacciaDiventaContadinoComponent
} from "./pagine/diventaContadino/interfaccia.diventa-contadino/interfaccia.diventa-contadino.component";
import {InterfacciaCheckoutComponent} from "./pagine/checkout/interfaccia.checkout/interfaccia.checkout.component";
import {InterfacciaProdottoComponent} from "./pagine/prodotto/interfaccia.prodotto/interfaccia.prodotto.component";
import {InterfacciaUtenteComponent} from "./pagine/utente/interfaccia.utente/interfaccia.utente.component";
import {
  InterfacciaResponsabileOrdiniComponent
} from "./pagine/responsabileOrdini/interfaccia.responsabile-ordini/interfaccia.responsabile-ordini.component";
import {
  InterfacciaResponsabileCatalogoComponent
} from "./pagine/responsabileCatalogo/interfaccia.responsabile-catalogo/interfaccia.responsabile-catalogo.component";
import {InterfacciaContadinoComponent} from "./pagine/contadino/interfaccia.contadino/interfaccia.contadino.component";

import {AccessoNegatoComponent} from "./pagine/errori/accesso-negato/accesso-negato.component";
import {AuthGuardUtente} from "./servizi/autenticazione/guardUtente/guardUtente.service";
import {
  GuardResponsabileOrdiniService
} from "./servizi/autenticazione/guardResponsabileOrdini/guard-responsabile-ordini.service";
import {
  GuardResponsabileCatalogoService
} from "./servizi/autenticazione/guardResponsabileCatalogo/guard-responsabile-catalogo.service";
import {GuardContadinoService} from "./servizi/autenticazione/guardContadino/guard-contadino.service";


const routes: Routes = [
  {path: '', component: InterfacciaHomeComponent},
  {path: 'catalogo', component: InterfacciaCatalogoComponent},
  {path: 'carrello', component: InterfacciaCarrelloComponent, canActivate: [AuthGuardUtente]},
  {path: 'chiSiamo', component: InterfacciaChiSiamoComponent},
  {path: 'diventaUnContadino', component: InterfacciaDiventaContadinoComponent},
  {path: 'checkout', component: InterfacciaCheckoutComponent, canActivate: [AuthGuardUtente]},
  {path: 'paginaProdotto/:nomeProdotto', component: InterfacciaProdottoComponent},
  {path: 'profiloUtente', component: InterfacciaUtenteComponent, canActivate: [AuthGuardUtente]},
  {path: 'profiloResponsabileOrdini', component: InterfacciaResponsabileOrdiniComponent, canActivate: [GuardResponsabileOrdiniService]},
  {path: 'profiloResponsabileCatalogo', component: InterfacciaResponsabileCatalogoComponent, canActivate: [GuardResponsabileCatalogoService]},
  {path: 'profiloContadino', component: InterfacciaContadinoComponent, canActivate: [GuardContadinoService]},
  {path: 'accessoNegato', component: AccessoNegatoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
