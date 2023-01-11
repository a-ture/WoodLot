import { TestBed } from '@angular/core/testing';

import { ContadinoService } from './contadino.service';

describe('ContadinoService', () => {
  let service: ContadinoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContadinoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
