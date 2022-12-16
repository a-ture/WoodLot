import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardDescrizioneProdottoComponent } from './card-descrizione-prodotto.component';

describe('CardDescrizioneProdottoComponent', () => {
  let component: CardDescrizioneProdottoComponent;
  let fixture: ComponentFixture<CardDescrizioneProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardDescrizioneProdottoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardDescrizioneProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
