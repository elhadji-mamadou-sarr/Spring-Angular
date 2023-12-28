import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheShowComponent } from './fiche-show.component';

describe('FicheShowComponent', () => {
  let component: FicheShowComponent;
  let fixture: ComponentFixture<FicheShowComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FicheShowComponent]
    });
    fixture = TestBed.createComponent(FicheShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
