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


const routes: Routes = [
  {path: '', component: InterfacciaHomeComponent},
  {path: 'catalogo', component: InterfacciaCatalogoComponent},
  {path: 'carrello', component: InterfacciaCarrelloComponent},
  {path: 'chiSiamo', component: InterfacciaChiSiamoComponent},
  {path: 'diventaUnContadino', component: InterfacciaDiventaContadinoComponent},
  {path: 'checkout', component: InterfacciaCheckoutComponent},
  {path: 'paginaProdotto', component: InterfacciaProdottoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
