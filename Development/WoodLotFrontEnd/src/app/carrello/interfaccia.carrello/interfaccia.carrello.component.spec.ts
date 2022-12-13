import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaCarrelloComponent } from './interfaccia.carrello.component';

describe('InterfacciaCarrelloComponent', () => {
  let component: InterfacciaCarrelloComponent;
  let fixture: ComponentFixture<InterfacciaCarrelloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaCarrelloComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaCarrelloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
