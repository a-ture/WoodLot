import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardForestaComponent } from './card-foresta.component';

describe('CardForestaComponent', () => {
  let component: CardForestaComponent;
  let fixture: ComponentFixture<CardForestaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardForestaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardForestaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
