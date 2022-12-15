import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTestoConIconaComponent } from './card-testo-con-icona.component';

describe('CardTestoConIconaComponent', () => {
  let component: CardTestoConIconaComponent;
  let fixture: ComponentFixture<CardTestoConIconaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardTestoConIconaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardTestoConIconaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
