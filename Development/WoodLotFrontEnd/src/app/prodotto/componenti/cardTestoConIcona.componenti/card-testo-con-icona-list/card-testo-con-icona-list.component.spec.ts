import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTestoConIconaListComponent } from './card-testo-con-icona-list.component';

describe('CardTestoConIconaListComponent', () => {
  let component: CardTestoConIconaListComponent;
  let fixture: ComponentFixture<CardTestoConIconaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardTestoConIconaListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardTestoConIconaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
