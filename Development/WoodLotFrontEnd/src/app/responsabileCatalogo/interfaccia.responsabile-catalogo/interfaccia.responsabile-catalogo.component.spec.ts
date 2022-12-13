import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaResponsabileCatalogoComponent } from './interfaccia.responsabile-catalogo.component';

describe('InterfacciaResponsabileCatalogoComponent', () => {
  let component: InterfacciaResponsabileCatalogoComponent;
  let fixture: ComponentFixture<InterfacciaResponsabileCatalogoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaResponsabileCatalogoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaResponsabileCatalogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
