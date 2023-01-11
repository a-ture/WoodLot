import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValoriWoodlotComponent } from './valori-woodlot.component';

describe('ValoriWoodlotComponent', () => {
  let component: ValoriWoodlotComponent;
  let fixture: ComponentFixture<ValoriWoodlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValoriWoodlotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValoriWoodlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
