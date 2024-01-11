import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { TokenService } from './token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private token: TokenService, private http :HttpClient) { }

  private loggedIn = new BehaviorSubject<boolean>(this.token.loggedIn())

  authStatus = this.loggedIn.asObservable();

  changeAuthStatus(value :boolean){
    this.loggedIn.next(value);
  }


}
