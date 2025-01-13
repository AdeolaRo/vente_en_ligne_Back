import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { Offre } from '../../models/models';

@Component({
  selector: 'app-offres',
  standalone: true,
  imports: [CommonModule], // Ajout de CommonModule pour utiliser les directives Angular
  templateUrl: './offres.component.html',
  styleUrls: ['./offres.component.css']
})
export class OffresComponent implements OnInit {
  offres: Offre[] = [
    { title: 'Offre 1', description: 'Description de l\'offre 1' },
    { title: 'Offre 2', description: 'Description de l\'offre 2' },
    { title: 'Offre 3', description: 'Description de l\'offre 3' }
  ];

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.loadOffres();
  }

  // Méthode pour charger les offres
  loadOffres(): void {
    this.apiService.getOffres().pipe().subscribe({
      next: (data: Offre[]) => {
        if (data && data.length > 0) {
          this.offres = data;
        }
      },
      error: (error) => {
        console.error('Erreur lors du chargement des offres :', error);
      }
    });
  }
}
