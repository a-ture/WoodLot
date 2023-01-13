import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoveVienePiantatoComponent } from './dove-viene-piantato.component';

describe('DoveVienePiantatoComponent', () => {
  let component: DoveVienePiantatoComponent;
  let fixture: ComponentFixture<DoveVienePiantatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoveVienePiantatoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoveVienePiantatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
