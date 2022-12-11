import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRettangolareConBottoneComponent } from './card-rettangolare-con-bottone.component';

describe('CardRettangolareConBottoneComponent', () => {
  let component: CardRettangolareConBottoneComponent;
  let fixture: ComponentFixture<CardRettangolareConBottoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRettangolareConBottoneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRettangolareConBottoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
