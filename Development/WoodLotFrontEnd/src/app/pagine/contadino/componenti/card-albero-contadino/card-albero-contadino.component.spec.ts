import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAlberoContadinoComponent } from './card-albero-contadino.component';

describe('CardAlberoContadinoComponent', () => {
  let component: CardAlberoContadinoComponent;
  let fixture: ComponentFixture<CardAlberoContadinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardAlberoContadinoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardAlberoContadinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
