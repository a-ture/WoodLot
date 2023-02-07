import { TestBed } from '@angular/core/testing';

import { GuardResponsabileOrdiniService } from './guard-responsabile-ordini.service';

describe('GuardResponsabileOrdiniService', () => {
  let service: GuardResponsabileOrdiniService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardResponsabileOrdiniService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
