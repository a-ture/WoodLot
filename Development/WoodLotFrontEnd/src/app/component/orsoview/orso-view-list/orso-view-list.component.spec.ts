import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrsoViewListComponent } from './orso-view-list.component';

describe('OrsoViewListComponent', () => {
  let component: OrsoViewListComponent;
  let fixture: ComponentFixture<OrsoViewListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrsoViewListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrsoViewListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
