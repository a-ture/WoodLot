import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StoricoPagamentiComponent } from './storico-pagamenti.component';

describe('StoricoPagamentiComponent', () => {
  let component: StoricoPagamentiComponent;
  let fixture: ComponentFixture<StoricoPagamentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StoricoPagamentiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StoricoPagamentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
