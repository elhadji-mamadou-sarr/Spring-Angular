import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Parrain } from 'src/app/models';
import { ParrainService } from 'src/app/services/parrain/parrain.service';

@Component({
  selector: 'app-parrain-modifier',
  templateUrl: './parrain-modifier.component.html',
  styleUrls: ['./parrain-modifier.component.css']
})
export class ParrainModifierComponent implements OnInit {

  parrain: Parrain = {
    id: 0,
    nom: '',
    prenom: '',
    numElecteur: 0,
    numIdentite: 0,
    localite: '',
    dateSignature: new Date()
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private parrainService: ParrainService
  ) { }

  ngOnInit(): void {
    const id = +this.route.snapshot.params['id']; // Convertir l'ID en nombre
    this.getParrain(id);
  }

  getParrain(id: number): void {
    this.parrainService.getParrainById(id)
      .subscribe(
        parrain => this.parrain = parrain,
        error => console.error(error)
      );
  }

  modifierParrain(): void {
    this.parrainService.modifierParrain(this.parrain)
      .subscribe(
        () => {
          console.log('Parrain modifié avec succès.');
          this.router.navigate(['/parrains']);
        },
        error => {
          console.error('Erreur lors de la modification du parrain : ', error);
        }
      );
  }
}
