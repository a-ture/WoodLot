import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRegaloComponent } from './card-regalo.component';

describe('CardRegaloComponent', () => {
  let component: CardRegaloComponent;
  let fixture: ComponentFixture<CardRegaloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRegaloComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRegaloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
