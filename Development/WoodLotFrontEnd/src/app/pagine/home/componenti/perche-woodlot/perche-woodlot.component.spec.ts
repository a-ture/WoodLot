import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PercheWoodlotComponent } from './perche-woodlot.component';

describe('PercheWoodlotComponent', () => {
  let component: PercheWoodlotComponent;
  let fixture: ComponentFixture<PercheWoodlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PercheWoodlotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PercheWoodlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
