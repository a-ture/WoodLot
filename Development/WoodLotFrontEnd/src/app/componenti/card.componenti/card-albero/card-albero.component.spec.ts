import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAlberoComponent } from './card-albero.component';

describe('CardAlberoComponent', () => {
  let component: CardAlberoComponent;
  let fixture: ComponentFixture<CardAlberoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardAlberoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardAlberoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
