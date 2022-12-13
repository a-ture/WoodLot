import { TestBed } from '@angular/core/testing';

import { ResponsabileCatalogoService } from './responsabile-catalogo.service';

describe('ResponsabileCatalogoService', () => {
  let service: ResponsabileCatalogoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponsabileCatalogoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
