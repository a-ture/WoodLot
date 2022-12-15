import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAlberoListComponent } from './card-albero-list.component';

describe('CardAlberoListComponent', () => {
  let component: CardAlberoListComponent;
  let fixture: ComponentFixture<CardAlberoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardAlberoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardAlberoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
