import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MdbAccordionModule} from 'mdb-angular-ui-kit/accordion';
import {MdbCarouselModule} from 'mdb-angular-ui-kit/carousel';
import {MdbCheckboxModule} from 'mdb-angular-ui-kit/checkbox';
import {MdbCollapseModule} from 'mdb-angular-ui-kit/collapse';
import {MdbDropdownModule} from 'mdb-angular-ui-kit/dropdown';
import {MdbFormsModule} from 'mdb-angular-ui-kit/forms';
import {MdbModalModule} from 'mdb-angular-ui-kit/modal';
import {MdbPopoverModule} from 'mdb-angular-ui-kit/popover';
import {MdbRadioModule} from 'mdb-angular-ui-kit/radio';
import {MdbRangeModule} from 'mdb-angular-ui-kit/range';
import {MdbRippleModule} from 'mdb-angular-ui-kit/ripple';
import {MdbScrollspyModule} from 'mdb-angular-ui-kit/scrollspy';
import {MdbTabsModule} from 'mdb-angular-ui-kit/tabs';
import {MdbTooltipModule} from 'mdb-angular-ui-kit/tooltip';
import {MdbValidationModule} from 'mdb-angular-ui-kit/validation';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  AccordionModule,
  AlertModule,
  AvatarModule,
  ButtonModule,
  CardModule, CarouselModule,
  DropdownModule, FooterModule,
  FormModule, GridModule,
  ModalModule, NavModule, OffcanvasModule, TabsModule, ToastModule,
} from '@coreui/angular';
import {IconModule} from '@coreui/icons-angular';
import {HttpClientModule} from '@angular/common/http';
import {HeaderComponent} from './componenti/header.componenti/header/header.component';
import {
  CardTondaConTestoComponent
} from './componenti/card.componenti/card-tonda-con-testo/card-tonda-con-testo.component';
import {
  CardTondaConTestoListComponent
} from './pagine/diventaContadino/componenti/card-tonda-con-testo-list/card-tonda-con-testo-list.component';
import {
  CardRettangolareConTestoComponent
} from './pagine/diventaContadino/componenti/cardRettangolareConTesto.componenti/card-rettangolare-con-testo/card-rettangolare-con-testo.component';
import {
  CardRettangolareConTestoListComponent
} from './pagine/diventaContadino/componenti/cardRettangolareConTesto.componenti/card-rettangolare-con-testo-list/card-rettangolare-con-testo-list.component';
import {
  CardProdottoComponent
} from './componenti/card.componenti/consiglioAlberi/card-prodotto/card-prodotto.component';
import {CardProdottoListComponent} from './pagine/catalogo/componenti/card-prodotto-list/card-prodotto-list.component';
import {ProdottoService} from "./servizi/prodotto/prodotto.service";
import {FiltroComponent} from './pagine/catalogo/componenti/filtro.componenti/filtro/filtro.component';
import {FiltroListComponent} from './pagine/catalogo/componenti/filtro.componenti/filtro-list/filtro-list.component';
import {CategoriaService} from "./servizi/categoria/categoria.service";
import {PaeseService} from "./servizi/paese/paese.service";
import {UsoLocaleService} from "./servizi/usoLocale/uso-locale.service";
import {
  CardRegaloComponent
} from './pagine/catalogo/componenti/cardRegalo.componenti/card-regalo/card-regalo.component';
import {
  CardRegaloListComponent
} from './pagine/catalogo/componenti/cardRegalo.componenti/card-regalo-list/card-regalo-list.component';
import {
  FotoConBottoneComponent
} from "./pagine/diventaContadino/componenti/foto-con-bottone/foto-con-bottone.component";
import {FotoObiettiviComponent} from './pagine/diventaContadino/componenti/foto-obiettivi/foto-obiettivi.component';
import {InterfacciaCarrelloComponent} from './pagine/carrello/interfaccia.carrello/interfaccia.carrello.component';
import {ProdottoCarrelloComponent} from './pagine/carrello/componenti/prodottoCarrello/prodotto-carrello.component';
import {InterfacciaCatalogoComponent} from './pagine/catalogo/interfaccia.catalogo/interfaccia.catalogo.component';
import {InterfacciaCheckoutComponent} from './pagine/checkout/interfaccia.checkout/interfaccia.checkout.component';
import {InterfacciaChiSiamoComponent} from './pagine/chiSiamo/interfaccia.chi-siamo/interfaccia.chi-siamo.component';
import {InterfacciaContadinoComponent} from './pagine/contadino/interfaccia.contadino/interfaccia.contadino.component';
import {InterfacciaProdottoComponent} from './pagine/prodotto/interfaccia.prodotto/interfaccia.prodotto.component';
import {
  InterfacciaResponsabileCatalogoComponent
} from './pagine/responsabileCatalogo/interfaccia.responsabile-catalogo/interfaccia.responsabile-catalogo.component';
import {InterfacciaUtenteComponent} from './pagine/utente/interfaccia.utente/interfaccia.utente.component';
import {InterfacciaHomeComponent} from './pagine/home/interfaccia.home/interfaccia.home.component';
import {
  InterfacciaDiventaContadinoComponent
} from './pagine/diventaContadino/interfaccia.diventa-contadino/interfaccia.diventa-contadino.component';
import {NumeroConTestoComponent} from './componenti/benvenuto.componenti/numero-con-testo/numero-con-testo.component';
import {
  ConsiglioAlberiListComponent
} from './componenti/card.componenti/consiglioAlberi/consiglio-alberi-list/consiglio-alberi-list.component';
import {BenvenutoComponent} from './componenti/benvenuto.componenti/benvenuto/benvenuto.component';
import {StoricoOrdiniComponent} from './pagine/utente/componenti/storico-ordini/storico-ordini.component';
import {
  CarouselImmaginiComponent
} from './pagine/prodotto/componenti/cardInfoProdotto.componenti/carousel-immagini/carousel-immagini.component';
import {
  CardInfoProdottoComponent
} from './pagine/prodotto/componenti/cardInfoProdotto.componenti/card-info-prodotto/card-info-prodotto.component';
import {MenuLateraleComponent} from './pagine/utente/componenti/menu-laterale/menu-laterale.component';
import {FotoConTestoListComponent} from "./pagine/home/componenti/foto-con-testo-list/foto-con-testo-list.component";
import {FotoConTestoComponent} from "./componenti/foto.componenti/foto-con-testo/foto-con-testo.component";
import {FaqComponent} from './pagine/catalogo/componenti/faq/faq.component';
import {
  CardConTestoConIconaLateraleComponent
} from './componenti/card.componenti/card-con-testo-con-icona-laterale/card-con-testo-con-icona-laterale.component';
import {
  CardConTestoConIconaLateraleListComponent
} from './pagine/home/componenti/card-con-testo-con-icona-laterale-list/card-con-testo-con-icona-laterale-list.component';
import {
  CardConTestoConIconaCentraleComponent
} from './componenti/card.componenti/card-con-testo-con-icona-centrale/card-con-testo-con-icona-centrale.component';
import {
  CardConTestoConIconaCentraleListComponent
} from './pagine/prodotto/componenti/card-con-testo-con-icona-centrale-list/card-con-testo-con-icona-centrale-list.component';
import {CardAlberoComponent} from './componenti/card.componenti/card-albero/card-albero.component';
import {
  CardAlberoListComponent
} from './pagine/utente/componenti/sezioneAlberi.componenti/card-albero-list/card-albero-list.component';
import {BadgeComponent} from './pagine/utente/componenti/sezioneBadge.componenti/badge/badge.component';
import {
  SezioneBadgeComponent
} from './pagine/utente/componenti/sezioneBadge.componenti/sezione-badge/sezione-badge.component';
import {
  SezioneAlberoComponent
} from './pagine/utente/componenti/sezioneAlberi.componenti/sezione-albero/sezione-albero.component';
import {ImmagineComponent} from './componenti/foto.componenti/immagine/immagine.component';
import {
  CardDescrizioneProdottoComponent
} from './pagine/prodotto/componenti/cardInfoProdotto.componenti/card-descrizione-prodotto/card-descrizione-prodotto.component';
import {FooterComponent} from "./componenti/footer/footer.component";
import {
  FotoConTestoSovrappostoComponent
} from "./pagine/home/componenti/foto-con-testo-sovrapposto/foto-con-testo-sovrapposto.component";
import {
  RegistrazioneUtenteComponent
} from './componenti/header.componenti/registrazione-utente/registrazione-utente.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from './componenti/header.componenti/login/login.component';
import {
  CardRettangolareConBottoneComponent
} from "./pagine/home/componenti/cardRettancoglareConBottone.componenti/card-rettangolare-con-bottone/card-rettangolare-con-bottone.component";
import {
  CardRettangolareConBottoneListComponent
} from "./pagine/home/componenti/cardRettancoglareConBottone.componenti/card-rettangolare-con-bottone-list/card-rettangolare-con-bottone-list.component";
import {ComeFunzionaComponent} from './pagine/home/componenti/come-funziona/come-funziona.component';
import {WoodlotInUnMinutoComponent} from './pagine/home/componenti/woodlot-in-un-minuto/woodlot-in-un-minuto.component';
import {RaccoltaFotoComponent} from './pagine/home/componenti/raccolta-foto/raccolta-foto.component';
import {PercheWoodlotComponent} from './pagine/home/componenti/perche-woodlot/perche-woodlot.component';
import {
  CicloDiVitaAlberoComponent
} from './pagine/catalogo/componenti/ciclo-di-vita-albero/ciclo-di-vita-albero.component';
import {HeaderCheckoutComponent} from './componenti/header.componenti/header-checkout/header-checkout.component';
import {
  ReimpostaPasswordComponent
} from './componenti/header.componenti/reimposta-password/reimposta-password.component';
import {FormPagamentoComponent} from "./pagine/checkout/componenti/form-pagamento/form-pagamento.component";
import {
  SezioneAggiungiComponent
} from './pagine/responsabileCatalogo/componenti/sezione-aggiungi/sezione-aggiungi.component';
import {
  SezioneEliminaComponent
} from './pagine/responsabileCatalogo/componenti/sezioneElimina.componenti/sezione-elimina/sezione-elimina.component';
import {
  CardEliminaComponent
} from './pagine/responsabileCatalogo/componenti/sezioneElimina.componenti/card-elimina/card-elimina.component';
import {
  CardAlberoContadinoComponent
} from './pagine/contadino/componenti/card-albero-contadino/card-albero-contadino.component';
import { OrdineEffettuatoComponent } from './pagine/checkout/componenti/ordine-effettuato/ordine-effettuato.component';
import { IntestazioneComponent } from './pagine/chiSiamo/componenti/intestazione/intestazione.component';
import { ValoriWoodlotComponent } from './pagine/chiSiamo/componenti/valori-woodlot/valori-woodlot.component';
import { MoltoPiuDiUnAlberoComponent } from './pagine/chiSiamo/componenti/molto-piu-di-un-albero/molto-piu-di-un-albero.component';
import { PaesiComponent } from './pagine/chiSiamo/componenti/paesi/paesi.component';
import { CondividiWoodlotComponent } from './pagine/chiSiamo/componenti/condividi-woodlot/condividi-woodlot.component';
import { InclusoNelPrezzoComponent } from './pagine/prodotto/componenti/cardInfoProdotto.componenti/incluso-nel-prezzo/incluso-nel-prezzo.component';
import { CardSuperpoteriComponent } from './pagine/prodotto/componenti/cardInfoProdotto.componenti/card-superpoteri/card-superpoteri.component';
import { CardUsiLocaliComponent } from './pagine/prodotto/componenti/cardInfoProdotto.componenti/card-usi-locali/card-usi-locali.component';

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
    ConsiglioAlberiListComponent,
    BenvenutoComponent,
    StoricoOrdiniComponent,
    CarouselImmaginiComponent,
    CardInfoProdottoComponent,
    MenuLateraleComponent,
    FotoConTestoComponent,
    FotoConTestoListComponent,
    FaqComponent,
    CardConTestoConIconaLateraleComponent,
    CardConTestoConIconaLateraleListComponent,
    CardConTestoConIconaCentraleComponent,
    CardConTestoConIconaCentraleListComponent,
    CardAlberoComponent,
    CardAlberoListComponent,
    BadgeComponent,
    SezioneBadgeComponent,
    SezioneAlberoComponent,
    ImmagineComponent,
    CardDescrizioneProdottoComponent,
    FotoConTestoSovrappostoComponent,
    RegistrazioneUtenteComponent,
    LoginComponent,
    CardRettangolareConBottoneComponent,
    CardRettangolareConBottoneListComponent,
    ComeFunzionaComponent,
    WoodlotInUnMinutoComponent,
    RaccoltaFotoComponent,
    PercheWoodlotComponent,
    CicloDiVitaAlberoComponent,
    HeaderCheckoutComponent,
    ReimpostaPasswordComponent,
    FormPagamentoComponent,
    SezioneAggiungiComponent,
    SezioneEliminaComponent,
    CardEliminaComponent,
    CardAlberoContadinoComponent,
    OrdineEffettuatoComponent,
    IntestazioneComponent,
    ValoriWoodlotComponent,
    MoltoPiuDiUnAlberoComponent,
    PaesiComponent,
    CondividiWoodlotComponent,
    InclusoNelPrezzoComponent,
    CardSuperpoteriComponent,
    CardUsiLocaliComponent,


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
    FormModule,
    CarouselModule,
    GridModule,
    AccordionModule,
    MdbTabsModule,
    NavModule,
    TabsModule,
    OffcanvasModule,
    ReactiveFormsModule,
    FormsModule,
    FooterModule,
    ToastModule,

  ],
  providers: [ProdottoService, CategoriaService, PaeseService, UsoLocaleService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
