import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RssService {
  private rssUrl = '/rss-proxy/rss/677f850abc1ed47620035cc3677f849e2e3b834d1d012593.xml';

  constructor(private http: HttpClient) {}

  fetchRssFeed(): Observable<string> {
    return this.http.get(this.rssUrl, { responseType: 'text' });
  }
}
