import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrelloItemComponent } from './carrello-item.component';

describe('CarrelloItemComponent', () => {
  let component: CarrelloItemComponent;
  let fixture: ComponentFixture<CarrelloItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarrelloItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrelloItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
