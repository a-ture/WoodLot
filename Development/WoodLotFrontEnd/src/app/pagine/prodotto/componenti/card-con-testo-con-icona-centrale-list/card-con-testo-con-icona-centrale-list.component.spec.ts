import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardConTestoConIconaCentraleListComponent } from './card-con-testo-con-icona-centrale-list.component';

describe('CardConTestoConIconaCentraleListComponent', () => {
  let component: CardConTestoConIconaCentraleListComponent;
  let fixture: ComponentFixture<CardConTestoConIconaCentraleListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardConTestoConIconaCentraleListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardConTestoConIconaCentraleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
