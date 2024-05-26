import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";
import {RegisterDto} from "../../dtos/register.dto";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerForm: FormGroup;
  errorMessage: string;

  constructor(private fb: FormBuilder, private loginService : LoginService, private router: Router) {
    this.registerForm = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(8)]],
    });
    this.errorMessage = '';
  }

  get email() {
    return this.registerForm.get('email')?.value;
  }

  get password() : string {
    return this.registerForm.get('password')?.value;
  }

  get firstname() {
    return this.registerForm.get('firstname');
  }

  get lastname() {
    return this.registerForm.get('lastname');
  }

  getErrorMessage(field: string): string {
    const control = this.registerForm.get(field);
    if (control?.hasError('required')) {
      return 'This field is required';
    } else if (control?.hasError('email')) {
      return 'Enter a valid email address';
    } else if (control?.hasError('minlength')) {
      return 'Must be at least 8 characters long';
    }
    return '';
  }

  onSubmit() {
    console.log(this.registerForm.value);
    if (this.registerForm.valid) {
      const registerDto : RegisterDto = this.registerForm.value;
      this.loginService.register(registerDto).subscribe(
        response => {
          // Handle successful response
          console.log('Register successful:', response);
          this.errorMessage = '';
          this.router.navigate(['/menu']);
        },
        error => {
          // Handle error response
          console.log('Register error:', error);
          this.errorMessage = error;
        }
      );
    } else {
      this.errorMessage = 'Please fill out the form correctly.';
    }
  }
}
