import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRettangolareConTestoListComponent } from './card-rettangolare-con-testo-list.component';

describe('CardRettangolareConTestoListComponent', () => {
  let component: CardRettangolareConTestoListComponent;
  let fixture: ComponentFixture<CardRettangolareConTestoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRettangolareConTestoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRettangolareConTestoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
