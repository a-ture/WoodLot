import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardProdottoListComponent } from './card-prodotto-list.component';

describe('CardProdottoListComponent', () => {
  let component: CardProdottoListComponent;
  let fixture: ComponentFixture<CardProdottoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardProdottoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardProdottoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
