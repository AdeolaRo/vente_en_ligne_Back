import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Offre, Contact } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  // Récupérer les services
  getOffres(): Observable<Offre[]> {
    return this.http.get<Offre[]>(`${this.baseUrl}/offres`);
  }

  // Soumettre un contact
  submitContact(contact: Contact): Observable<Contact> {
    return this.http.post<Contact>(`${this.baseUrl}/contacts`, contact);
  }
}
