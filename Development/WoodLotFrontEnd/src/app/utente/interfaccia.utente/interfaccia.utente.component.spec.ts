import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaUtenteComponent } from './interfaccia.utente.component';

describe('InterfacciaUtenteComponent', () => {
  let component: InterfacciaUtenteComponent;
  let fixture: ComponentFixture<InterfacciaUtenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaUtenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaUtenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
