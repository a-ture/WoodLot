import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {ToggleButtonModule} from 'primeng/togglebutton';
import {PaginatorModule} from "primeng/paginator";
import { OrsoViewComponent } from './component/orsoview/orso-view/orso-view.component';
import {PanelModule} from "primeng/panel";
import {OrsoService} from "./service/orso.service";
import { OrsoViewListComponent } from './component/orsoview/orso-view-list/orso-view-list.component';

@NgModule({
  declarations: [
    AppComponent,
    OrsoViewComponent,
    OrsoViewListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ToggleButtonModule,
    PaginatorModule,
    PanelModule
  ],
  providers: [OrsoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
