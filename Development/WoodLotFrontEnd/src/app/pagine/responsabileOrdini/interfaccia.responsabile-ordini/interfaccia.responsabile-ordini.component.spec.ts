import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaResponsabileOrdiniComponent } from './interfaccia.responsabile-ordini.component';

describe('InterfacciaResponsabileOrdiniComponent', () => {
  let component: InterfacciaResponsabileOrdiniComponent;
  let fixture: ComponentFixture<InterfacciaResponsabileOrdiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaResponsabileOrdiniComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaResponsabileOrdiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
