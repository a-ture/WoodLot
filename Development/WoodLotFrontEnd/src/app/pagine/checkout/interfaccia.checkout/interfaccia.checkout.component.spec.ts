import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaCheckoutComponent } from './interfaccia.checkout.component';

describe('InterfacciaCheckoutComponent', () => {
  let component: InterfacciaCheckoutComponent;
  let fixture: ComponentFixture<InterfacciaCheckoutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaCheckoutComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaCheckoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
