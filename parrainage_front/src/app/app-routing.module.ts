import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CollecteurListComponent } from './composant/collecteur/collecteur-list/collecteur-list.component';
import { ParrainListComponent } from './composant/parrain/parrain-list/parrain-list.component';
import { ParrainAjoutComponent } from './composant/parrain/parrain-ajout/parrain-ajout.component';
import { ParrainModifierComponent } from './composant/parrain/parrain-modifier/parrain-modifier.component';
import { FicheListComponent } from './composant/fiche/fiche-list/fiche-list.component';
import { FicheShowComponent } from './composant/fiche/fiche-show/fiche-show.component';
import { MenuComponent } from './composant/menu/menu.component';
import { CandidatListComponent } from './composant/candidat/candidat-list/candidat-list.component';
import { CandidatAjoutComponent } from './composant/candidat/candidat-ajout/candidat-ajout.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [

  { path : '', component:LoginComponent},
  { path : 'login', component:LoginComponent},

  { path : 'collecteurs', component:CollecteurListComponent},

  { path : 'parrains', component:ParrainListComponent},
  { path : 'ajouterParrain', component:ParrainAjoutComponent},
  { path : 'modifier/:id', component:ParrainModifierComponent},

  { path : 'fiches', component:FicheListComponent},
  { path : 'fiches/show/:id', component:FicheShowComponent},

  { path : 'candidats', component:CandidatListComponent},
  { path : 'ajouterCandidat', component:CandidatAjoutComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
