import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL_API } from 'src/app/config';
import { Collecteur } from 'src/app/models';

@Injectable({
  providedIn: 'root'
})
export class CollecteurService {

  constructor(private _httpClient: HttpClient) { }

  getCollecteurs():Observable<Collecteur[]>{
    return this._httpClient.get<Collecteur[]>(`${URL_API}/collecteurs`);
  }

}
