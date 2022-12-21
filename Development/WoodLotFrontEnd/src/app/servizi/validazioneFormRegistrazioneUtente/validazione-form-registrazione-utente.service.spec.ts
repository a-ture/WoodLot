import { TestBed } from '@angular/core/testing';

import { ValidazioneFormRegistrazioneUtenteService } from './validazione-form-registrazione-utente.service';

describe('ValidazioneFormRegistrazioneUtenteService', () => {
  let service: ValidazioneFormRegistrazioneUtenteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidazioneFormRegistrazioneUtenteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
