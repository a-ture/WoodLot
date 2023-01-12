import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CondividiWoodlotComponent } from './condividi-woodlot.component';

describe('CondividiWoodlotComponent', () => {
  let component: CondividiWoodlotComponent;
  let fixture: ComponentFixture<CondividiWoodlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CondividiWoodlotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CondividiWoodlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
