import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollecteurAjoutComponent } from './collecteur-ajout.component';

describe('CollecteurAjoutComponent', () => {
  let component: CollecteurAjoutComponent;
  let fixture: ComponentFixture<CollecteurAjoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CollecteurAjoutComponent]
    });
    fixture = TestBed.createComponent(CollecteurAjoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
