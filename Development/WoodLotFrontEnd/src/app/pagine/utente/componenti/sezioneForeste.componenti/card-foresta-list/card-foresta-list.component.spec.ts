import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardForestaListComponent } from './card-foresta-list.component';

describe('CardForestaListComponent', () => {
  let component: CardForestaListComponent;
  let fixture: ComponentFixture<CardForestaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardForestaListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardForestaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
