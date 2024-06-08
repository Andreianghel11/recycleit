import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './services/login.guard';
import {MenuComponent} from "./components/menu/menu.component";
import {ResultPageComponent} from "./components/result-page/result-page.component";
import {LastScansComponent} from "./components/last-scans/last-scans.component";
import {RegisterComponent} from "./components/register/register.component";
import {ReportPageComponent} from "./components/report-page/report-page.component";
import {LevelAndBadgesComponent} from "./components/level-and-badges/level-and-badges.component";


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Default route
  { path: 'menu', component: MenuComponent, canActivate: [LoginGuard] },
  { path: 'result-page', component: ResultPageComponent, canActivate: [LoginGuard]},
  { path: 'last-scans', component: LastScansComponent, canActivate: [LoginGuard] },
  { path: 'register', component: RegisterComponent },
  { path: 'report-page/:image', component: ReportPageComponent, canActivate: [LoginGuard] },
  {path: 'level-and-badges', component: LevelAndBadgesComponent, canActivate: [LoginGuard]},
  // Add other routes here
  { path: '**', redirectTo: '/login' } // Wildcard route for a 404 page (optional)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
