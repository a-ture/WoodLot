import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup

  constructor() {
    this.formLogin = new FormGroup({
      emailUtenteLogin: new FormControl('', Validators.required),
      passwordLogin: new FormControl('', Validators.required)
    })
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    // TODO: Submit form value
    alert('SUCCESS!');
  }

}
