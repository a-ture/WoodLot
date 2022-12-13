import { TestBed } from '@angular/core/testing';

import { StatisticheService } from './statistiche.service';

describe('StatisticheService', () => {
  let service: StatisticheService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatisticheService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
