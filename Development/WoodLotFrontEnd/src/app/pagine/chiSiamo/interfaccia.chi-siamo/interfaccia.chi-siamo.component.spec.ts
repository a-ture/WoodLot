import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaChiSiamoComponent } from './interfaccia.chi-siamo.component';

describe('InterfacciaChiSiamoComponent', () => {
  let component: InterfacciaChiSiamoComponent;
  let fixture: ComponentFixture<InterfacciaChiSiamoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaChiSiamoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaChiSiamoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
