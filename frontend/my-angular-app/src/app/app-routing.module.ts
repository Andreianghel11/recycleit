import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoginGuard } from './services/login.guard';
import {MenuComponent} from "./components/menu/menu.component";
import {CameraCaptureComponent} from "./components/camera-capture/camera-capture.component";


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Default route
  { path: 'menu', component: MenuComponent, canActivate: [LoginGuard] },
  {path: 'camera', component: CameraCaptureComponent, canActivate: [LoginGuard]},
  // Add other routes here
  { path: '**', redirectTo: '/login' } // Wildcard route for a 404 page (optional)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
