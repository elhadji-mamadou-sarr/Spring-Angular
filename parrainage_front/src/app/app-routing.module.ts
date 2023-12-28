import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CollecteurListComponent } from './composant/collecteur/collecteur-list/collecteur-list.component';
import { ParrainListComponent } from './composant/parrain/parrain-list/parrain-list.component';
import { ParrainAjoutComponent } from './composant/parrain/parrain-ajout/parrain-ajout.component';
import { ParrainModifierComponent } from './composant/parrain/parrain-modifier/parrain-modifier.component';
import { FicheListComponent } from './composant/fiche/fiche-list/fiche-list.component';
import { FicheShowComponent } from './composant/fiche/fiche-show/fiche-show.component';
import { MenuComponent } from './composant/menu/menu.component';

const routes: Routes = [

  { path : '', component:MenuComponent},

  { path : 'collecteurs', component:CollecteurListComponent},

  { path : 'parrains', component:ParrainListComponent},
  { path : 'ajouterParrain', component:ParrainAjoutComponent},
  { path : 'modifier/:id', component:ParrainModifierComponent},

  { path : 'fiches', component:FicheListComponent},
  { path : 'fiches/show/:id', component:FicheShowComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
