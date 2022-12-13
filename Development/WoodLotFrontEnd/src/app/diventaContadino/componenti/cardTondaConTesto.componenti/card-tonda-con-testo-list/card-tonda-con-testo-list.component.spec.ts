import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTondaConTestoListComponent } from './card-tonda-con-testo-list.component';

describe('CardTondaConTestoListComponent', () => {
  let component: CardTondaConTestoListComponent;
  let fixture: ComponentFixture<CardTondaConTestoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardTondaConTestoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardTondaConTestoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
