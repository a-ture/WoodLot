import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardRegaloListComponent } from './card-regalo-list.component';

describe('CardRegaloListComponent', () => {
  let component: CardRegaloListComponent;
  let fixture: ComponentFixture<CardRegaloListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardRegaloListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardRegaloListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
