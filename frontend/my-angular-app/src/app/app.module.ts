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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    ResultPageComponent,
    NavbarComponent,
    LastScansComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    LoginInterceptor,
    { provide: HTTP_INTERCEPTORS, useClass: LoginInterceptor, multi: true },
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
