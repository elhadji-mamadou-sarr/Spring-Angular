import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheListComponent } from './fiche-list.component';

describe('FicheListComponent', () => {
  let component: FicheListComponent;
  let fixture: ComponentFixture<FicheListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FicheListComponent]
    });
    fixture = TestBed.createComponent(FicheListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
