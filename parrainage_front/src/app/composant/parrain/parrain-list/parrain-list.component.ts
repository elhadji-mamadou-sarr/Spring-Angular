import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Parrain } from 'src/app/models';
import { ParrainService } from 'src/app/services/parrain/parrain.service';

@Component({
  selector: 'app-parrain-list',
  templateUrl: './parrain-list.component.html',
  styleUrls: ['./parrain-list.component.css']
})
export class ParrainListComponent implements OnInit{

  constructor(private parrainService:ParrainService, private router: Router){

  }

  parrains:Parrain[]=[];

  errorMessage = "";
  successMessage = "";

  ngOnInit(): void {
    this.parrainService.getParrains().subscribe(
      {
        next:(apps)=>{
          this.parrains=apps;
        },
        error:(err)=>{
          this.errorMessage="Erreur de requete";
        },
        complete:()=>{
          this.successMessage ="Requete valide";
        }
      }
    );
  }

  modifierParrain(parrain: Parrain): void {
    this.router.navigate(['/modifier', parrain.id]);
  }

  loadParrains() {
    this.parrainService.getParrains().subscribe(
      (data) => {
        this.parrains = data;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  supprimerParrain(id: number) {
    this.parrainService.supprimerParrain(id).subscribe(
      () => {
        console.log('Parrain supprimé avec succès.');
        // Actualisez la liste des parrains après la suppression
        this.loadParrains();
      },
      (error) => {
        console.error('Erreur lors de la suppression du parrain : ', error);
      }
    );
  }


}
