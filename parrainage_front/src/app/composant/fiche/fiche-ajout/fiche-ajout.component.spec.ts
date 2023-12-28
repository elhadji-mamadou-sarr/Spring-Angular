import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheAjoutComponent } from './fiche-ajout.component';

describe('FicheAjoutComponent', () => {
  let component: FicheAjoutComponent;
  let fixture: ComponentFixture<FicheAjoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FicheAjoutComponent]
    });
    fixture = TestBed.createComponent(FicheAjoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
