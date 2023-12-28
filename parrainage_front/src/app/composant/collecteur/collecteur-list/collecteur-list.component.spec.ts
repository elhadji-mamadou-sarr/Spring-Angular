import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CollecteurListComponent } from './collecteur-list.component';

describe('CollecteurListComponent', () => {
  let component: CollecteurListComponent;
  let fixture: ComponentFixture<CollecteurListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CollecteurListComponent]
    });
    fixture = TestBed.createComponent(CollecteurListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
