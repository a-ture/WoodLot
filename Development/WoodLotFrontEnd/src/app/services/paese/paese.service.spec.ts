import { TestBed } from '@angular/core/testing';

import { PaeseService } from './paese.service';

describe('PaeseService', () => {
  let service: PaeseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaeseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
