import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InterfacciaContadinoComponent } from './interfaccia.contadino.component';

describe('InterfacciaContadinoComponent', () => {
  let component: InterfacciaContadinoComponent;
  let fixture: ComponentFixture<InterfacciaContadinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InterfacciaContadinoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InterfacciaContadinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
