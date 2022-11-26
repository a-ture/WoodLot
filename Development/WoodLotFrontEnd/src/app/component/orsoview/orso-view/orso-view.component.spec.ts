import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrsoViewComponent } from './orso-view.component';

describe('OrsoViewComponent', () => {
  let component: OrsoViewComponent;
  let fixture: ComponentFixture<OrsoViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrsoViewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrsoViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
