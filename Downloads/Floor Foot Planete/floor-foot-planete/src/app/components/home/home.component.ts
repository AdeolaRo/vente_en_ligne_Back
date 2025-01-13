import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RssFeedComponent } from '../../rss-feed/rss-feed.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RssFeedComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
