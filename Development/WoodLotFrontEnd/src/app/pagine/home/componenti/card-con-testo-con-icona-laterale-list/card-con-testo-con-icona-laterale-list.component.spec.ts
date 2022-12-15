import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardConTestoConIconaLateraleListComponent } from './card-con-testo-con-icona-laterale-list.component';

describe('CardConTestoConIconaLateraleListComponent', () => {
  let component: CardConTestoConIconaLateraleListComponent;
  let fixture: ComponentFixture<CardConTestoConIconaLateraleListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardConTestoConIconaLateraleListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardConTestoConIconaLateraleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
