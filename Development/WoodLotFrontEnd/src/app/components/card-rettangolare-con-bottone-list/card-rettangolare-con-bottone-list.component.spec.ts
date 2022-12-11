import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRettangolareConBottoneListComponent } from './card-rettangolare-con-bottone-list.component';

describe('CardRettangolareConBottoneListComponent', () => {
  let component: CardRettangolareConBottoneListComponent;
  let fixture: ComponentFixture<CardRettangolareConBottoneListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRettangolareConBottoneListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRettangolareConBottoneListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
