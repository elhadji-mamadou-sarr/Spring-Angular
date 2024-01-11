import { Input, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { MenuComponent } from './composant/menu/menu.component';
import { ParrainListComponent } from './composant/parrain/parrain-list/parrain-list.component';
import { ParrainAjoutComponent } from './composant/parrain/parrain-ajout/parrain-ajout.component';
import { ParrainModifierComponent } from './composant/parrain/parrain-modifier/parrain-modifier.component';
import { FicheListComponent } from './composant/fiche/fiche-list/fiche-list.component';
import { FicheAjoutComponent } from './composant/fiche/fiche-ajout/fiche-ajout.component';
import { FicheShowComponent } from './composant/fiche/fiche-show/fiche-show.component';
import { FicheModifierComponent } from './composant/fiche/fiche-modifier/fiche-modifier.component';
import { CollecteurListComponent } from './composant/collecteur/collecteur-list/collecteur-list.component';
import { CollecteurAjoutComponent } from './composant/collecteur/collecteur-ajout/collecteur-ajout.component';
import { CollecteurModifierComponent } from './composant/collecteur/collecteur-modifier/collecteur-modifier.component';
import { CandidatListComponent } from './composant/candidat/candidat-list/candidat-list.component';
import { CandidatAjoutComponent } from './composant/candidat/candidat-ajout/candidat-ajout.component';
import { CandidatModifierComponent } from './composant/candidat/candidat-modifier/candidat-modifier.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    ParrainListComponent,
    ParrainAjoutComponent,
    ParrainModifierComponent,
    FicheListComponent,
    FicheAjoutComponent,
    FicheShowComponent,
    FicheModifierComponent,
    CollecteurListComponent,
    CollecteurAjoutComponent,
    CollecteurModifierComponent,
    CandidatListComponent,
    CandidatAjoutComponent,
    CandidatModifierComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
