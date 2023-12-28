import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fiche, Parrain } from 'src/app/models';
import { FicheService } from 'src/app/services/fiche/fiche.service';

@Component({
  selector: 'app-fiche-show',
  templateUrl: './fiche-show.component.html',
  styleUrls: ['./fiche-show.component.css']
})
export class FicheShowComponent implements OnInit{

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private ficheService : FicheService
  ) { }

  fiche !: Fiche
  parrains : Parrain[] = []


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const numero = +params['id'];

      this.ficheService.showFicheById(numero).subscribe(data => {
        this.fiche = data;
        this.parrains = data.parrains
      });

  });
  }



}
