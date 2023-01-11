import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardEliminaComponent } from './card-elimina.component';

describe('CardEliminaComponent', () => {
  let component: CardEliminaComponent;
  let fixture: ComponentFixture<CardEliminaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardEliminaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardEliminaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
