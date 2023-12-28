import { Component, OnInit } from '@angular/core';
import { Fiche } from 'src/app/models';

@Component({
  selector: 'app-fiche-ajout',
  templateUrl: './fiche-ajout.component.html',
  styleUrls: ['./fiche-ajout.component.css']
})
export class FicheAjoutComponent implements OnInit{

  nouvelleFiche: Fiche = {
    id: 0,
    numero: 0,
    candidat: null,
    delegueRegional: null,
    region: null,
    collecteur: null,
    parrains: null,
  };

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


}
