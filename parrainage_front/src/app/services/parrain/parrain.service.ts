import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL_API } from 'src/app/config';
import { Page, Parrain } from 'src/app/models';

@Injectable({
  providedIn: 'root'
})
export class ParrainService {

  constructor(private _httpClient: HttpClient) { }

  private apiUrl = `${URL_API}/parrainages`;

  getParrains(page: number, size: number): Observable<Page<Parrain>> {
    const params = new HttpParams().set('page', page.toString()).set('size', size.toString());
    return this._httpClient.get<Page<Parrain>>(`${this.apiUrl}/paged`, { params });
  }

  searchParrain(searchTerm: string, page: number, size: number): Observable<any> {
    const params = new HttpParams()
      .set('searchTerm', searchTerm)
      .set('page', page.toString())
      .set('size', size.toString());

    return this._httpClient.get<any>(`${this.apiUrl}/search`, { params });
  }


  ajouterParrain(parrain: Parrain): Observable<Parrain> {
    return this._httpClient.post<Parrain>(this.apiUrl, parrain);
  }

  modifierParrain(parrain: Parrain): Observable<void> {
    const url = `${this.apiUrl}`;
    return this._httpClient.put<void>(url, parrain);
  }

  getParrainById(id: number): Observable<Parrain> {
    const url = `${this.apiUrl}/${id}`;
    return this._httpClient.get<Parrain>(url);
  }

  supprimerParrain(id: number): Observable<void> {
    const url = `${this.apiUrl}/${id}`;
    return this._httpClient.delete<void>(url);
  }


}
