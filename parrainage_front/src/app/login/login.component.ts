import { Component, OnInit } from '@angular/core';
import { User } from '../models';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth/auth.service';
import { LoginService } from '../services/auth/login.service';
import { TokenService } from '../services/auth/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{


   user : User={
    username : '',
    password :''
  }

  errorMessage = ""
  public loggedIn!: boolean;

  constructor(
    private loginService : LoginService, private tokenService : TokenService,
    private router : Router, private  authService: AuthService,
    ){}


  ngOnInit(): void {

    this.authService.authStatus.subscribe(
      value => this.loggedIn = value
    )
  }


  seConnecter(){
    console.log(this.user);
    this.loginService.login(this.user).subscribe(
      (data)=> {
        //this.handleResponse(data)
        console.log(data);
        console.log("Connexion Réussi");
      },
      (err)=>{
        console.log("Erreur de connexion", err);
        this.errorMessage = err.error.error
        console.log("Erreur de precision ", this.errorMessage);

      }
    )
  }

  handleResponse(data :any){
    this.tokenService.handle(data.access_token);
    this.authService.changeAuthStatus(true);
    console.log(data.access_token);

  }





}
