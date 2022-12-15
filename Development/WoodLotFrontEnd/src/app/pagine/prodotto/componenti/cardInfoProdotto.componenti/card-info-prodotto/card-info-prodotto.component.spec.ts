import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardInfoProdottoComponent } from './card-info-prodotto.component';

describe('CardInfoProdottoComponent', () => {
  let component: CardInfoProdottoComponent;
  let fixture: ComponentFixture<CardInfoProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardInfoProdottoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardInfoProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
