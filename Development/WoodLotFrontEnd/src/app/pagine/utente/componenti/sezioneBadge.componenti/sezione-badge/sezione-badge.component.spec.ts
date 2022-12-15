import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneBadgeComponent } from './sezione-badge.component';

describe('SezioneBadgeComponent', () => {
  let component: SezioneBadgeComponent;
  let fixture: ComponentFixture<SezioneBadgeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneBadgeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneBadgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
