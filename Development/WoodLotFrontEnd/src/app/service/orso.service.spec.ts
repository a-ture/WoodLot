import { TestBed } from '@angular/core/testing';

import { OrsoService } from './orso.service';

describe('OrsoService', () => {
  let service: OrsoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrsoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
