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
import {AlertModule, AvatarModule, ButtonModule, CardModule, DropdownModule, ModalModule} from '@coreui/angular';
import { IconModule } from '@coreui/icons-angular';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/pages/home/home.component';
import { ProdottoComponent } from './components/pages/prodotto/prodotto.component';
import { CatalogoComponent } from './components/pages/catalogo/catalogo.component';
import { ChiSiamoComponent } from './components/pages/chi-siamo/chi-siamo.component';
import { DiventaContadinoComponent } from './components/pages/diventa-contadino/diventa-contadino.component';
import { CarrelloComponent } from './components/pages/carrello/carrello.component';
import { CheckoutComponent } from './components/pages/checkout/checkout.component';
import { UtenteComponent } from './components/pages/utente/utente.component';
import { ContadinoComponent } from './components/pages/contadino/contadino.component';
import { ResponsabileCatalogoComponent } from './components/pages/responsabile-catalogo/responsabile-catalogo.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { CardTondaConTestoComponent } from './components/card-tonda-con-testo/card-tonda-con-testo.component';
import { CardTondaConTestoListComponent } from './components/card-tonda-con-testo-list/card-tonda-con-testo-list.component';
import {UniscitiService} from "./services/statistiche/unisciti.service";
import { CardRettangolareConTestoComponent } from './components/card-rettangolare-con-testo/card-rettangolare-con-testo.component';
import { CardRettangolareConTestoListComponent } from './components/card-rettangolare-con-testo-list/card-rettangolare-con-testo-list.component';
import { CardProdottoComponent } from './components/card-prodotto/card-prodotto.component';
import { CardProdottoListComponent } from './components/card-prodotto-list/card-prodotto-list.component';
import {ProdottoService} from "./services/prodotto/prodotto.service";
import { FiltroComponent } from './components/filtro/filtro.component';
import { FiltroListComponent } from './components/filtro-list/filtro-list.component';
import {CategoriaService} from "./services/categoria/categoria.service";
import {PaeseService} from "./services/paese/paese.service";
import {UsoLocaleService} from "./services/usoLocale/uso-locale.service";
import { CardRegaloComponent } from './components/card-regalo/card-regalo.component';
import { CardRegaloListComponent } from './components/card-regalo-list/card-regalo-list.component';
import {FotoConBottoneComponent} from "./components/foto-con-bottone/foto-con-bottone.component";
import { FotoObiettiviComponent } from './components/foto-obiettivi/foto-obiettivi.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProdottoComponent,
    CatalogoComponent,
    ChiSiamoComponent,
    DiventaContadinoComponent,
    CarrelloComponent,
    CheckoutComponent,
    UtenteComponent,
    ContadinoComponent,
    ResponsabileCatalogoComponent,
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
    FotoObiettiviComponent
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
    ModalModule
  ],
  providers: [UniscitiService, ProdottoService, CategoriaService,PaeseService, UsoLocaleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
