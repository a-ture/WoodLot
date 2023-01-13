import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardUsiLocaliComponent } from './card-usi-locali.component';

describe('CardUsiLocaliComponent', () => {
  let component: CardUsiLocaliComponent;
  let fixture: ComponentFixture<CardUsiLocaliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardUsiLocaliComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardUsiLocaliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
