import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaCatalogoComponent } from './interfaccia.catalogo.component';

describe('InterfacciaCatalogoComponent', () => {
  let component: InterfacciaCatalogoComponent;
  let fixture: ComponentFixture<InterfacciaCatalogoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaCatalogoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaCatalogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
