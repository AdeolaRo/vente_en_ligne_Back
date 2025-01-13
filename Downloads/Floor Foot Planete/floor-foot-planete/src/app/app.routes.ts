import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { OffresComponent } from './components/offres/offres.component';
import { ContactComponent } from './components/contact/contact.component';
import { RssFeedComponent } from './rss-feed/rss-feed.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'offres', component: OffresComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'rss-feed', component: RssFeedComponent },
  { path: '**', redirectTo: '' }
];


