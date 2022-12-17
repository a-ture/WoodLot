import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreaForestaComponent } from './crea-foresta.component';

describe('CreaForestaComponent', () => {
  let component: CreaForestaComponent;
  let fixture: ComponentFixture<CreaForestaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreaForestaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreaForestaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
