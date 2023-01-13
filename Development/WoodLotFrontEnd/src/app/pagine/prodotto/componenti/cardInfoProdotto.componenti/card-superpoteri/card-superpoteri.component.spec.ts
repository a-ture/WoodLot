import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardSuperpoteriComponent } from './card-superpoteri.component';

describe('CardSuperpoteriComponent', () => {
  let component: CardSuperpoteriComponent;
  let fixture: ComponentFixture<CardSuperpoteriComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardSuperpoteriComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardSuperpoteriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
