import { TestBed } from '@angular/core/testing';

import { ProdottoOrdineService } from './prodotto-ordine.service';

describe('ProdottoOrdineService', () => {
  let service: ProdottoOrdineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProdottoOrdineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
