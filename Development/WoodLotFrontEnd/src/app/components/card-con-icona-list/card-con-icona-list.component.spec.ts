import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardConIconaListComponent } from './card-con-icona-list.component';

describe('CardConIconaListComponent', () => {
  let component: CardConIconaListComponent;
  let fixture: ComponentFixture<CardConIconaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardConIconaListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardConIconaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
