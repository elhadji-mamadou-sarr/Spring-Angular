import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParrainModifierComponent } from './parrain-modifier.component';

describe('ParrainModifierComponent', () => {
  let component: ParrainModifierComponent;
  let fixture: ComponentFixture<ParrainModifierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ParrainModifierComponent]
    });
    fixture = TestBed.createComponent(ParrainModifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
