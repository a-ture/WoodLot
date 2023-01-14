import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardPagamentoComponent } from './card-pagamento.component';

describe('CardPagamentoComponent', () => {
  let component: CardPagamentoComponent;
  let fixture: ComponentFixture<CardPagamentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardPagamentoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardPagamentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
