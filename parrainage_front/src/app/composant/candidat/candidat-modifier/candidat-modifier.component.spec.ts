import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatModifierComponent } from './candidat-modifier.component';

describe('CandidatModifierComponent', () => {
  let component: CandidatModifierComponent;
  let fixture: ComponentFixture<CandidatModifierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CandidatModifierComponent]
    });
    fixture = TestBed.createComponent(CandidatModifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
