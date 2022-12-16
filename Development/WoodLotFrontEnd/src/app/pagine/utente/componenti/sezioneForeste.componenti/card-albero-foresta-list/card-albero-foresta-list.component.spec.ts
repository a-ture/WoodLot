import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardAlberoForestaListComponent } from './card-albero-foresta-list.component';

describe('CardAlberoForestaListComponent', () => {
  let component: CardAlberoForestaListComponent;
  let fixture: ComponentFixture<CardAlberoForestaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardAlberoForestaListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardAlberoForestaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
