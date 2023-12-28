import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL_API } from 'src/app/config';
import { Fiche } from 'src/app/models';

@Injectable({
  providedIn: 'root'
})
export class FicheService {

  constructor(private __httpClient: HttpClient) { }

  private apiUrl = `${URL_API}/fiches`;

  getFiches():Observable<Fiche[]>{
    return this.__httpClient.get<Fiche[]>(this.apiUrl)
  }

  showFicheByNum(numero : number): Observable<any>{
    return this.__httpClient.get<any>(`${this.apiUrl}/${numero}`)
  }

  showFicheById(id : number): Observable<any>{
    return this.__httpClient.get<any>(`${this.apiUrl}/id/${id}`)
  }

}
