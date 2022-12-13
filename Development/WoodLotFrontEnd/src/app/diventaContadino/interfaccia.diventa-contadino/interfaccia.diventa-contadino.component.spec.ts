import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaDiventaContadinoComponent } from './interfaccia.diventa-contadino.component';

describe('InterfacciaDiventaContadinoComponent', () => {
  let component: InterfacciaDiventaContadinoComponent;
  let fixture: ComponentFixture<InterfacciaDiventaContadinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaDiventaContadinoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaDiventaContadinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
