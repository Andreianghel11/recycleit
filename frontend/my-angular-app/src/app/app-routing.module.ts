import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './services/login.guard';
import {MenuComponent} from "./components/menu/menu.component";
import {ResultPageComponent} from "./components/result-page/result-page.component";
import {LastScansComponent} from "./components/last-scans/last-scans.component";


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Default route
  { path: 'menu', component: MenuComponent, canActivate: [LoginGuard] },
  { path: 'result-page', component: ResultPageComponent, canActivate: [LoginGuard]},
  { path: 'last-scans', component: LastScansComponent, canActivate: [LoginGuard] },
  // Add other routes here
  { path: '**', redirectTo: '/login' } // Wildcard route for a 404 page (optional)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
