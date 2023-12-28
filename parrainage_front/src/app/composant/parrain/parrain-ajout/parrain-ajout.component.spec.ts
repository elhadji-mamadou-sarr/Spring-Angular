import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParrainAjoutComponent } from './parrain-ajout.component';

describe('ParrainAjoutComponent', () => {
  let component: ParrainAjoutComponent;
  let fixture: ComponentFixture<ParrainAjoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ParrainAjoutComponent]
    });
    fixture = TestBed.createComponent(ParrainAjoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
