import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StateMenuComponent } from './state-menu.component';

describe('StateMenuComponent', () => {
  let component: StateMenuComponent;
  let fixture: ComponentFixture<StateMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StateMenuComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StateMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
