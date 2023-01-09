import { TestBed } from '@angular/core/testing';

import { ValidazioneFormUtenteService } from './validazione-form-utente.service';

describe('ValidazioneFormRegistrazioneUtenteService', () => {
  let service: ValidazioneFormUtenteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidazioneFormUtenteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
