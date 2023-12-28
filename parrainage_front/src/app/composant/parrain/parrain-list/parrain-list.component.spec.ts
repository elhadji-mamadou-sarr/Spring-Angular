import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParrainListComponent } from './parrain-list.component';

describe('ParrainListComponent', () => {
  let component: ParrainListComponent;
  let fixture: ComponentFixture<ParrainListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ParrainListComponent]
    });
    fixture = TestBed.createComponent(ParrainListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
