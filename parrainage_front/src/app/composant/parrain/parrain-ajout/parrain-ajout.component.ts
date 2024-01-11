import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Parrain } from 'src/app/models';
import { ParrainService } from 'src/app/services/parrain/parrain.service';

@Component({
  selector: 'app-parrain-ajout',
  templateUrl: './parrain-ajout.component.html',
  styleUrls: ['./parrain-ajout.component.css']
})
export class ParrainAjoutComponent implements OnInit {

  nouveauParrain: Parrain = {
    id: 0,
    nom: '',
    prenom: '',
    numElecteur: 102245110,
    numIdentite: 194382016006280086,
    localite: '',
    dateSignature: new Date()
  };
  
  errorMessage = '';
  successMessage = '';

  constructor(private parrainService: ParrainService, private route: Router) { }

  ngOnInit(): void {
  }

  ajouterParrain(): void {
    this.parrainService.ajouterParrain(this.nouveauParrain).subscribe(
      {
        next: (parrain) => {
          this.successMessage = 'Parrain ajouté avec succès';
          this.route.navigate(['/parrains']);
          this.nouveauParrain = {
            id: 0,
            nom: '',
            prenom: '',
            numElecteur: 0,
            numIdentite: 0,
            localite: '',
            dateSignature: new Date()
          };
        },
        error: (err) => {
          this.errorMessage = 'Erreur lors de l\'ajout du parrain';
        }
      }
    );
  }
}
