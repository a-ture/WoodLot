import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WoodlotInUnMinutoComponent } from './woodlot-in-un-minuto.component';

describe('WoodlotInUnMinutoComponent', () => {
  let component: WoodlotInUnMinutoComponent;
  let fixture: ComponentFixture<WoodlotInUnMinutoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WoodlotInUnMinutoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WoodlotInUnMinutoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
