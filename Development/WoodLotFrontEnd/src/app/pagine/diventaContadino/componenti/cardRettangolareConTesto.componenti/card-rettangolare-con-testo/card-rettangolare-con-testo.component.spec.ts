import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRettangolareConTestoComponent } from './card-rettangolare-con-testo.component';

describe('CardRettangolareConTestoComponent', () => {
  let component: CardRettangolareConTestoComponent;
  let fixture: ComponentFixture<CardRettangolareConTestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRettangolareConTestoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRettangolareConTestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
