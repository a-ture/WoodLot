import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrazioneUtenteComponent } from './registrazione-utente.component';

describe('RegistrazioneUtenteComponent', () => {
  let component: RegistrazioneUtenteComponent;
  let fixture: ComponentFixture<RegistrazioneUtenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrazioneUtenteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrazioneUtenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
