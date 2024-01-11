import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URL_LOGIN } from '../../config';
import { User } from '../../models';
import { Observable, catchError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private __httpClient:HttpClient) { }



  login(user : User) : Observable<any>{
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'});
    return this.__httpClient.post<any>(URL_LOGIN, user)
  }
  


}
