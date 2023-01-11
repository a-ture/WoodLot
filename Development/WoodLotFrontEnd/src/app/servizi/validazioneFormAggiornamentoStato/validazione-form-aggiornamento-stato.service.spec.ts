import { TestBed } from '@angular/core/testing';

import { ValidazioneFormAggiornamentoStatoService } from './validazione-form-aggiornamento-stato.service';

describe('ValidazioneFormAggiornamentoStatoService', () => {
  let service: ValidazioneFormAggiornamentoStatoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidazioneFormAggiornamentoStatoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
