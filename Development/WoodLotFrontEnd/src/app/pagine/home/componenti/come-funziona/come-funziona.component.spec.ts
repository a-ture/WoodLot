import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComeFunzionaComponent } from './come-funziona.component';

describe('ComeFunzionaComponent', () => {
  let component: ComeFunzionaComponent;
  let fixture: ComponentFixture<ComeFunzionaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComeFunzionaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComeFunzionaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
