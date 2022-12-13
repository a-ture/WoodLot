import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdottoCarrelloComponent } from './prodotto.carrello.component';

describe('ProdottoCarrelloComponent', () => {
  let component: ProdottoCarrelloComponent;
  let fixture: ComponentFixture<ProdottoCarrelloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProdottoCarrelloComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdottoCarrelloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
