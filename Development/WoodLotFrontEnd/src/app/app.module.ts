import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MdbAccordionModule } from 'mdb-angular-ui-kit/accordion';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MdbCheckboxModule } from 'mdb-angular-ui-kit/checkbox';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';
import { MdbFormsModule } from 'mdb-angular-ui-kit/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';
import { MdbPopoverModule } from 'mdb-angular-ui-kit/popover';
import { MdbRadioModule } from 'mdb-angular-ui-kit/radio';
import { MdbRangeModule } from 'mdb-angular-ui-kit/range';
import { MdbRippleModule } from 'mdb-angular-ui-kit/ripple';
import { MdbScrollspyModule } from 'mdb-angular-ui-kit/scrollspy';
import { MdbTabsModule } from 'mdb-angular-ui-kit/tabs';
import { MdbTooltipModule } from 'mdb-angular-ui-kit/tooltip';
import { MdbValidationModule } from 'mdb-angular-ui-kit/validation';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  AlertModule,
  AvatarModule,
  ButtonModule,
  CardModule,
  DropdownModule,
  FormModule,
  ModalModule
} from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { CardTondaConTestoComponent } from './diventaContadino/componenti/cardTondaConTesto.componenti/card-tonda-con-testo/card-tonda-con-testo.component';
import { CardTondaConTestoListComponent } from './diventaContadino/componenti/cardTondaConTesto.componenti/card-tonda-con-testo-list/card-tonda-con-testo-list.component';
import { CardRettangolareConTestoComponent } from './diventaContadino/componenti/cardRettangolareConTesto.componenti/card-rettangolare-con-testo/card-rettangolare-con-testo.component';
import { CardRettangolareConTestoListComponent } from './diventaContadino/componenti/cardRettangolareConTesto.componenti/card-rettangolare-con-testo-list/card-rettangolare-con-testo-list.component';
import { CardProdottoComponent } from './catalogo/componenti/cardProdotto.componenti/card-prodotto/card-prodotto.component';
import { CardProdottoListComponent } from './catalogo/componenti/cardProdotto.componenti/card-prodotto-list/card-prodotto-list.component';
import {ProdottoService} from "./servizi/prodotto/prodotto.service";
import { FiltroComponent } from './catalogo/componenti/filtro.componenti/filtro/filtro.component';
import { FiltroListComponent } from './catalogo/componenti/filtro.componenti/filtro-list/filtro-list.component';
import {CategoriaService} from "./servizi/categoria/categoria.service";
import {PaeseService} from "./servizi/paese/paese.service";
import {UsoLocaleService} from "./servizi/usoLocale/uso-locale.service";
import { CardRegaloComponent } from './catalogo/componenti/cardRegalo.componenti/card-regalo/card-regalo.component';
import { CardRegaloListComponent } from './catalogo/componenti/cardRegalo.componenti/card-regalo-list/card-regalo-list.component';
import {FotoConBottoneComponent} from "./diventaContadino/componenti/foto-con-bottone/foto-con-bottone.component";
import { FotoObiettiviComponent } from './diventaContadino/componenti/foto-obiettivi/foto-obiettivi.component';
import { InterfacciaCarrelloComponent } from './carrello/interfaccia.carrello/interfaccia.carrello.component';
import { ProdottoCarrelloComponent } from './carrello/componenti/prodotto.carrello/prodotto.carrello.component';
import { InterfacciaCatalogoComponent } from './catalogo/interfaccia.catalogo/interfaccia.catalogo.component';
import { InterfacciaCheckoutComponent } from './checkout/interfaccia.checkout/interfaccia.checkout.component';
import { InterfacciaChiSiamoComponent } from './chiSiamo/interfaccia.chi-siamo/interfaccia.chi-siamo.component';
import { InterfacciaContadinoComponent } from './contadino/interfaccia.contadino/interfaccia.contadino.component';
import { InterfacciaProdottoComponent } from './prodotto/interfaccia.prodotto/interfaccia.prodotto.component';
import { InterfacciaResponsabileCatalogoComponent } from './responsabileCatalogo/interfaccia.responsabile-catalogo/interfaccia.responsabile-catalogo.component';
import { InterfacciaUtenteComponent } from './utente/interfaccia.utente/interfaccia.utente.component';
import { InterfacciaHomeComponent } from './home/interfaccia.home/interfaccia.home.component';
import { InterfacciaDiventaContadinoComponent } from './diventaContadino/interfaccia.diventa-contadino/interfaccia.diventa-contadino.component';
import { NumeroConTestoComponent } from './responsabileCatalogo/componenti/numeroConTesto.componenti/numero-con-testo/numero-con-testo.component';
import { NumeroConTestoListComponent } from './responsabileCatalogo/componenti/numeroConTesto.componenti/numero-con-testo-list/numero-con-testo-list.component';
import { ConsiglioAlberiListComponent } from './prodotto/componenti/consiglio-alberi-list/consiglio-alberi-list.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CardTondaConTestoComponent,
    CardTondaConTestoListComponent,
    CardRettangolareConTestoComponent,
    CardRettangolareConTestoListComponent,
    CardProdottoComponent,
    CardProdottoListComponent,
    FiltroComponent,
    FiltroListComponent,
    CardRegaloComponent,
    CardRegaloListComponent,
    FotoConBottoneComponent,
    FotoObiettiviComponent,
    InterfacciaCarrelloComponent,
    ProdottoCarrelloComponent,
    InterfacciaCatalogoComponent,
    InterfacciaCheckoutComponent,
    InterfacciaChiSiamoComponent,
    InterfacciaContadinoComponent,
    InterfacciaProdottoComponent,
    InterfacciaResponsabileCatalogoComponent,
    InterfacciaUtenteComponent,
    InterfacciaHomeComponent,
    InterfacciaDiventaContadinoComponent,
    NumeroConTestoComponent,
    NumeroConTestoListComponent,
    ConsiglioAlberiListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MdbAccordionModule,
    MdbCarouselModule,
    MdbCheckboxModule,
    MdbCollapseModule,
    MdbDropdownModule,
    MdbFormsModule,
    MdbModalModule,
    MdbPopoverModule,
    MdbRadioModule,
    MdbRangeModule,
    MdbRippleModule,
    MdbScrollspyModule,
    MdbTabsModule,
    MdbTooltipModule,
    MdbValidationModule,
    BrowserAnimationsModule,
    AlertModule,
    IconModule,
    HttpClientModule,
    AvatarModule,
    CardModule,
    DropdownModule,
    ButtonModule,
    ModalModule,
    FormModule
  ],
  providers: [ProdottoService, CategoriaService,PaeseService, UsoLocaleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
