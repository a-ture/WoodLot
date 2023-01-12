import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InclusoNelPrezzoComponent } from './incluso-nel-prezzo.component';

describe('InclusoNelPrezzoComponent', () => {
  let component: InclusoNelPrezzoComponent;
  let fixture: ComponentFixture<InclusoNelPrezzoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InclusoNelPrezzoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InclusoNelPrezzoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
