import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string | undefined;
  password: string | undefined;
  loginError: boolean = false;
  cadastrando: boolean = false;

  constructor(private router: Router){

  }

  onSubmit(){
    this.router.navigate(['/home']);
  }

  preparaCadastrar(event: any){
    event.preventDefault();
    this.cadastrando = true;
  }

  cancelaCadastro(){
    this.cadastrando = false;
  }
}
