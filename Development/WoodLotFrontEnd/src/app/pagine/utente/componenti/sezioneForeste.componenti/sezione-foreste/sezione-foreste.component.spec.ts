import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneForesteComponent } from './sezione-foreste.component';

describe('SezioneForesteComponent', () => {
  let component: SezioneForesteComponent;
  let fixture: ComponentFixture<SezioneForesteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneForesteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneForesteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
