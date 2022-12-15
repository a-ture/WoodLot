import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardConTestoConIconaLateraleComponent } from './card-con-testo-con-icona-laterale.component';

describe('CardConTestoConIconaLateraleComponent', () => {
  let component: CardConTestoConIconaLateraleComponent;
  let fixture: ComponentFixture<CardConTestoConIconaLateraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardConTestoConIconaLateraleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardConTestoConIconaLateraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
