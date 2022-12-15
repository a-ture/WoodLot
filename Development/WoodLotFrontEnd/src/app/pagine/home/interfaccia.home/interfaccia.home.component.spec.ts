import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaHomeComponent } from './interfaccia.home.component';

describe('InterfacciaHomeComponent', () => {
  let component: InterfacciaHomeComponent;
  let fixture: ComponentFixture<InterfacciaHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
