import { TestBed } from '@angular/core/testing';

import { UsoLocaleService } from './uso-locale.service';

describe('UsoLocaleService', () => {
  let service: UsoLocaleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UsoLocaleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
