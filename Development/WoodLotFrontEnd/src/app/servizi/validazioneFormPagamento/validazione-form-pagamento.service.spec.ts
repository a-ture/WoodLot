import { TestBed } from '@angular/core/testing';

import { ValidazioneFormPagamentoService } from './validazione-form-pagamento.service';

describe('ValidazioneFormPagamentoService', () => {
  let service: ValidazioneFormPagamentoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValidazioneFormPagamentoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
