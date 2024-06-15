import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {LoginInterceptor} from "./services/login.interceptor";
import { MenuComponent } from './components/menu/menu.component';
import { ResultPageComponent } from './components/result-page/result-page.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LastScansComponent } from './components/last-scans/last-scans.component';
import { RegisterComponent } from './components/register/register.component';
import { ReportButtonComponent } from './components/report-button/report-button.component';
import { ReportPageComponent } from './components/report-page/report-page.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { LevelAndBadgesComponent } from './components/level-and-badges/level-and-badges.component';
import { GoogleMapsModule } from '@angular/google-maps';
import {LocationService} from "./services/location.service";
import {MapComponent} from "./components/map/map.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    ResultPageComponent,
    NavbarComponent,
    LastScansComponent,
    RegisterComponent,
    ReportButtonComponent,
    ReportPageComponent,
    ConfirmationDialogComponent,
    LevelAndBadgesComponent,
    MapComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
    GoogleMapsModule
  ],
  providers: [
    LoginInterceptor,
    { provide: HTTP_INTERCEPTORS, useClass: LoginInterceptor, multi: true },
    provideClientHydration(),
    provideAnimationsAsync(),
    LocationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
