import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollecteurModifierComponent } from './collecteur-modifier.component';

describe('CollecteurModifierComponent', () => {
  let component: CollecteurModifierComponent;
  let fixture: ComponentFixture<CollecteurModifierComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CollecteurModifierComponent]
    });
    fixture = TestBed.createComponent(CollecteurModifierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
