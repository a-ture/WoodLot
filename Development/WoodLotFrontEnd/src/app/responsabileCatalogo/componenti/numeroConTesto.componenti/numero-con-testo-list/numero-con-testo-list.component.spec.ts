import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumeroConTestoListComponent } from './numero-con-testo-list.component';

describe('NumeroConTestoListComponent', () => {
  let component: NumeroConTestoListComponent;
  let fixture: ComponentFixture<NumeroConTestoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NumeroConTestoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NumeroConTestoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
