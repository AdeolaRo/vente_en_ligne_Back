import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Contact } from '../../models/models';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contact: Contact = {
    fullName: '',
    email: '',
    phone: '',
    message: ''
  };

  constructor(private apiService: ApiService) { }

  onSubmit(): void {
    this.apiService.submitContact(this.contact).subscribe(
      (response: Contact) => {
        alert('Votre message a été envoyé avec succès!');
        this.contact = { fullName: '', email: '', phone: '', message: '' };
      },
      (error: Error) => {
        console.error('Erreur lors de l\'envoi du message:', error);
        alert('Une erreur est survenue. Veuillez réessayer.');
      }
    );
  }
}
