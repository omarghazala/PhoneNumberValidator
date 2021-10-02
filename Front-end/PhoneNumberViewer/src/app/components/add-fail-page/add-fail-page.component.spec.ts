import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFailPageComponent } from './add-fail-page.component';

describe('AddFailPageComponent', () => {
  let component: AddFailPageComponent;
  let fixture: ComponentFixture<AddFailPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFailPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFailPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
