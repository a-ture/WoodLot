import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RaccoltaFotoComponent } from './raccolta-foto.component';

describe('RaccoltaFotoComponent', () => {
  let component: RaccoltaFotoComponent;
  let fixture: ComponentFixture<RaccoltaFotoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RaccoltaFotoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RaccoltaFotoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
