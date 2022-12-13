import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumeroConTestoComponent } from './numero-con-testo.component';

describe('NumeroConTestoComponent', () => {
  let component: NumeroConTestoComponent;
  let fixture: ComponentFixture<NumeroConTestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NumeroConTestoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NumeroConTestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
