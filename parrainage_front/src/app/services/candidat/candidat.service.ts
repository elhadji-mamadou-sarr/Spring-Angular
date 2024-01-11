import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL_API } from 'src/app/config';
import { Candidat } from 'src/app/models';

@Injectable({
  providedIn: 'root'
})
export class CandidatService {

  constructor(private _httpClient: HttpClient) { }

  private apiUrl = `${URL_API}/candidats`;

  getCandidats():Observable<Candidat[]>{
    return this._httpClient.get<Candidat[]>(this.apiUrl);
  }

  ajouterCandidat(candidat: Candidat): Observable<Candidat> {
    return this._httpClient.post<Candidat>(this.apiUrl, candidat);
  }

  modifierCandidat(candidat: Candidat): Observable<void> {
    const url = `${this.apiUrl}`;
    return this._httpClient.put<void>(url, candidat);
  }

  getCandidatById(id: number): Observable<Candidat> {
    const url = `${this.apiUrl}/${id}`;
    return this._httpClient.get<Candidat>(url);
  }

  supprimerCandidat(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this._httpClient.delete<void>(url);
  }



}
