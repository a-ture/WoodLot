import { TestBed } from '@angular/core/testing';

import { ValidazioneFormProdottoService } from './validazione-form-prodotto.service';

describe('ValidazioneFormProdottoService', () => {
  let service: ValidazioneFormProdottoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidazioneFormProdottoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
