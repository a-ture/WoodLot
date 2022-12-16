import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAlberoRegaloListComponent } from './card-albero-regalo-list.component';

describe('CardAlberoRegaloListComponent', () => {
  let component: CardAlberoRegaloListComponent;
  let fixture: ComponentFixture<CardAlberoRegaloListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardAlberoRegaloListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardAlberoRegaloListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
