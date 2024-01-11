import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Page, Parrain } from 'src/app/models';
import { ParrainService } from 'src/app/services/parrain/parrain.service';

@Component({
  selector: 'app-parrain-list',
  templateUrl: './parrain-list.component.html',
  styleUrls: ['./parrain-list.component.css']
})
export class ParrainListComponent implements OnInit{

  constructor(private parrainService:ParrainService, private router: Router){

  }

  currentPage = 0;
  pageSize = 3;
  totalItems = 0;

  parrains:Parrain[]=[];

  page!:Page<Parrain>

  searchTerm: string = ""

  errorMessage = "";
  successMessage = "";

  ngOnInit(): void {
    this.loadParrains();
  }

  range(n: number): number[] {
    return Array.from({ length: n }, (_, i) => i);
  }

  loadParrains() {
    this.parrainService.getParrains(this.currentPage, this.pageSize).subscribe(
      (data) => {
        this.page = data
        this.totalItems = data.totalElements;
        this.parrains = data.content;
      },
      (error) => {
        console.error(error);
      }
    );
  }

  goToPage(pageNumber: number) {
    if (pageNumber >= 0 && pageNumber < this.page.totalPages) {
      this.currentPage = pageNumber;
      this.loadParrains();
    }
  }

  goToPreviousPage() {
    this.goToPage(this.currentPage - 1);
  }

  goToNextPage() {
    this.goToPage(this.currentPage + 1);
  }


  modifierParrain(parrain: Parrain): void {
    this.router.navigate(['/modifier', parrain.id]);
  }


  searchParrains() {

    this.loadParrains();

    this.parrainService.searchParrain(this.searchTerm, this.currentPage, this.pageSize).subscribe(
      (data) => {
        this.page = data;
        this.totalItems = data.totalElements;
        this.parrains = data.content;
      },
      (err) => {
        console.log(err);
      }
    );
  }




  supprimerParrain(id: number) {
    this.parrainService.supprimerParrain(id).subscribe(
      () => {
        console.log('Parrain supprimé avec succès.');
        this.loadParrains();
      },
      (error) => {
        console.error('Erreur lors de la suppression du parrain : ', error);
      }
    );
  }


}
