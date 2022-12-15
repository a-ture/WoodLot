import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardConTestoConIconaCentraleComponent } from './card-con-testo-con-icona-centrale.component';

describe('CardConTestoConIconaCentraleComponent', () => {
  let component: CardConTestoConIconaCentraleComponent;
  let fixture: ComponentFixture<CardConTestoConIconaCentraleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardConTestoConIconaCentraleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardConTestoConIconaCentraleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
