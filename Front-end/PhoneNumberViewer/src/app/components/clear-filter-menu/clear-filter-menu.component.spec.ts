import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClearFilterMenuComponent } from './clear-filter-menu.component';

describe('ClearFilterMenuComponent', () => {
  let component: ClearFilterMenuComponent;
  let fixture: ComponentFixture<ClearFilterMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClearFilterMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClearFilterMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
