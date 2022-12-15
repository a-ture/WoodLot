import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardProdottoComponent } from './card-prodotto.component';

describe('CardProdottoComponent', () => {
  let component: CardProdottoComponent;
  let fixture: ComponentFixture<CardProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardProdottoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
