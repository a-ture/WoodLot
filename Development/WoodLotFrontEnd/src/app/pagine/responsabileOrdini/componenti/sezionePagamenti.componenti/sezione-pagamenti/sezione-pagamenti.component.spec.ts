import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezionePagamentiComponent } from './sezione-pagamenti.component';

describe('SezionePagamentiComponent', () => {
  let component: SezionePagamentiComponent;
  let fixture: ComponentFixture<SezionePagamentiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezionePagamentiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezionePagamentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
