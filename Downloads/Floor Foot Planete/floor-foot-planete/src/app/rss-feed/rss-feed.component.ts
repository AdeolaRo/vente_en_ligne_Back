import { Component, OnInit } from '@angular/core';
import { RssService } from '../services/rss.service';

@Component({
  selector: 'app-rss-feed',
  standalone: true,
  template: `
    <div>
    <h3 style="text-align: center;">Actualités Maxifoot</h3>
    <ul>
  <li *ngFor="let item of items">
    <a [href]="item.link" target="_blank" rel="noopener noreferrer">{{ item.title }}</a>
  </li>
</ul>
    </div>
  `,
  styleUrls: ['./rss-feed.component.css'],
})
export class RssFeedComponent implements OnInit {
  items: any[] = [];

  constructor(private rssService: RssService) {}

  ngOnInit(): void {
    this.rssService.fetchRssFeed().subscribe({
      next: (data) => {
        const parser = new DOMParser();
        const xml = parser.parseFromString(data, 'application/xml');
        const entries = Array.from(xml.querySelectorAll('item'));
        this.items = entries.map((item) => ({
          title: item.querySelector('title')?.textContent || 'Sans titre',
          link: item.querySelector('link')?.textContent || '#',
        }));
      },
      error: (err) => {
        console.error('Erreur lors du chargement du flux RSS:', err);
      },
    });
  }
}
