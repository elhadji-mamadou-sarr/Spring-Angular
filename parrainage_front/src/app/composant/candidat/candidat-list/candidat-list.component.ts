import { Component, OnInit } from '@angular/core';
import { Candidat } from 'src/app/models';
import { CandidatService } from 'src/app/services/candidat/candidat.service';

@Component({
  selector: 'app-candidat-list',
  templateUrl: './candidat-list.component.html',
  styleUrls: ['./candidat-list.component.css']
})
export class CandidatListComponent implements OnInit{

  constructor(private candidatService: CandidatService){
  }

  candidats:Candidat[]=[];
  errorMessage = "";
  successMessage = "";

  ngOnInit(): void {
    this.candidatService.getCandidats().subscribe(
      {
        next:(value) => {
          this.candidats=value;
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
