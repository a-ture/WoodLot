import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaProdottoComponent } from './interfaccia.prodotto.component';

describe('InterfacciaProdottoComponent', () => {
  let component: InterfacciaProdottoComponent;
  let fixture: ComponentFixture<InterfacciaProdottoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaProdottoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaProdottoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
