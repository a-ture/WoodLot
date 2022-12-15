import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoricoOrdiniComponent } from './storico-ordini.component';

describe('StoricoOrdiniComponent', () => {
  let component: StoricoOrdiniComponent;
  let fixture: ComponentFixture<StoricoOrdiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoricoOrdiniComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StoricoOrdiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
