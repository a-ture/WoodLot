import { TestBed } from '@angular/core/testing';

import { UniscitiService } from './unisciti.service';

describe('UniscitiAWoodLotService', () => {
  let service: UniscitiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UniscitiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
