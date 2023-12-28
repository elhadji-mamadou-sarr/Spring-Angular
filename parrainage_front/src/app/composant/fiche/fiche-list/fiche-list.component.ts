import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fiche } from 'src/app/models';
import { FicheService } from 'src/app/services/fiche/fiche.service';

@Component({
  selector: 'app-fiche-list',
  templateUrl: './fiche-list.component.html',
  styleUrls: ['./fiche-list.component.css']
})
export class FicheListComponent implements OnInit{

  constructor(private ficheService:FicheService, private route:Router){}

  fiches:Fiche[]=[];

  errorMessage = ""
  succesMessage = ""

  ngOnInit(): void {
    this.ficheService.getFiches().subscribe(
      {
        next:(fiche) =>{
            this.fiches=fiche
        },
        error:(err)=> {
          this.errorMessage = "Erreur lors de la requete"
        },
        complete:() =>{
          this.succesMessage ="Requete envoyé avec succe"
        },

      }
    );
  }

  showFiche(numero: Fiche) {
    this.route.navigate(['/fiches/show', numero.id]);
    console.log(numero);

   }

}
