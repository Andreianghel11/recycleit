import { Component } from '@angular/core';
import {LoginService} from "../../services/login.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginDto} from "../../dtos/login.dto";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  errorMessage: string;

  constructor(private fb: FormBuilder, private loginService : LoginService, private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
    this.errorMessage = '';
  }

  get email() {
    return this.loginForm.get('email')?.value;
  }

  get password() : string {
        return this.loginForm.get('password')?.value;
  }

  onSubmit() {
    console.log(this.loginForm.value);
    if (this.loginForm.valid) {
      const loginDto : LoginDto = this.loginForm.value;
      this.loginService.login(loginDto).subscribe(
        response => {
          // Handle successful response
          console.log('Login successful:', response);
          this.errorMessage = '';
          this.router.navigate(['/menu']);
        },
        error => {
          // Handle error response
          this.errorMessage = error;
        }, () => {
          // Always executed
        }
      );
    } else {
      this.errorMessage = 'Please fill out the form correctly.';
    }
  }

  onRegisterClick() {
    this.router.navigate(['/register']);
  }
}
