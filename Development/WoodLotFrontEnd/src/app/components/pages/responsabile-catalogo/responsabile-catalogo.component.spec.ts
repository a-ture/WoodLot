import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsabileCatalogoComponent } from './responsabile-catalogo.component';

describe('ResponsabileCatalogoComponent', () => {
  let component: ResponsabileCatalogoComponent;
  let fixture: ComponentFixture<ResponsabileCatalogoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResponsabileCatalogoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResponsabileCatalogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
