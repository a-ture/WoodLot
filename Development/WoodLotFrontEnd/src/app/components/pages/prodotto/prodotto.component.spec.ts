import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdottoComponent } from './prodotto.component';

describe('ProdottoComponent', () => {
  let component: ProdottoComponent;
  let fixture: ComponentFixture<ProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProdottoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
