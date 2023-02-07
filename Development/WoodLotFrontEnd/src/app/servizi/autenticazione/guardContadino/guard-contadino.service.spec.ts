import { TestBed } from '@angular/core/testing';

import { GuardContadinoService } from './guard-contadino.service';

describe('GuardContadinoService', () => {
  let service: GuardContadinoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardContadinoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
