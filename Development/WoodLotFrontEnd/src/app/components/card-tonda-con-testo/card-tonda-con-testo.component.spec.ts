import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardTondaConTestoComponent } from './card-tonda-con-testo.component';

describe('CardTondaConTestoComponent', () => {
  let component: CardTondaConTestoComponent;
  let fixture: ComponentFixture<CardTondaConTestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardTondaConTestoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardTondaConTestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
