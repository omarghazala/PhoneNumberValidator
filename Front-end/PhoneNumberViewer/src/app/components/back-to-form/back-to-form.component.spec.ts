import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BackToFormComponent } from './back-to-form.component';

describe('BackToFormComponent', () => {
  let component: BackToFormComponent;
  let fixture: ComponentFixture<BackToFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BackToFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BackToFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
