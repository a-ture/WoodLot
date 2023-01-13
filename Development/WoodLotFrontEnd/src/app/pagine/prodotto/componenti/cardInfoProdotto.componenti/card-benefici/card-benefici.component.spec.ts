import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardBeneficiComponent } from './card-benefici.component';

describe('CardBeneficiComponent', () => {
  let component: CardBeneficiComponent;
  let fixture: ComponentFixture<CardBeneficiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardBeneficiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardBeneficiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
