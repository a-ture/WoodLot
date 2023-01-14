import { TestBed } from '@angular/core/testing';

import { ResponsabileOrdiniService } from './responsabile-ordini.service';

describe('ResponsabileOrdiniService', () => {
  let service: ResponsabileOrdiniService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponsabileOrdiniService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
