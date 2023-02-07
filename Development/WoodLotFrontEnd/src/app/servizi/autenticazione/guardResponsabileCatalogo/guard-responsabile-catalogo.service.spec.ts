import { TestBed } from '@angular/core/testing';

import { GuardResponsabileCatalogoService } from './guard-responsabile-catalogo.service';

describe('GuardResponsabileCatalogoService', () => {
  let service: GuardResponsabileCatalogoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GuardResponsabileCatalogoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
