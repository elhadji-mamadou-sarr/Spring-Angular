import { Component, OnInit } from '@angular/core';
import { Collecteur } from 'src/app/models';
import { CollecteurService } from 'src/app/services/collecteur/collecteur.service';

@Component({
  selector: 'app-collecteur-list',
  templateUrl: './collecteur-list.component.html',
  styleUrls: ['./collecteur-list.component.css']
})
export class CollecteurListComponent implements OnInit{

  constructor(private collecteurService: CollecteurService){
  }

  collecteurs:Collecteur[]=[];
  errorMessage = "";
  successMessage = "";

  ngOnInit(): void {
    this.collecteurService.getCollecteurs().subscribe(
      {
        next:(collect) => {
            this.collecteurs=collect;
            console.log("Passe avec succe");

        },
        error:(err)=> {
          this.errorMessage="Requete invalide";
        },
        complete:() =>{
            this.successMessage="Requete valider";
        },
      }
    );
  }



}
