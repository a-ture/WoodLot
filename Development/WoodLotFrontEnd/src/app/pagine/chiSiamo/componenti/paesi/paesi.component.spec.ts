import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaesiComponent } from './paesi.component';

describe('PaesiComponent', () => {
  let component: PaesiComponent;
  let fixture: ComponentFixture<PaesiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaesiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaesiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
