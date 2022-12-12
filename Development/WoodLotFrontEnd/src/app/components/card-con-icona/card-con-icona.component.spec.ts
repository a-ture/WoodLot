import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardConIconaComponent } from './card-con-icona.component';

describe('CardConIconaComponent', () => {
  let component: CardConIconaComponent;
  let fixture: ComponentFixture<CardConIconaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardConIconaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardConIconaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
