import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheModifierComponent } from './fiche-modifier.component';

describe('FicheModifierComponent', () => {
  let component: FicheModifierComponent;
  let fixture: ComponentFixture<FicheModifierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FicheModifierComponent]
    });
    fixture = TestBed.createComponent(FicheModifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
