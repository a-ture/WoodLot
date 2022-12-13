import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsiglioAlberiListComponent } from './consiglio-alberi-list.component';

describe('ConsiglioAlberiListComponent', () => {
  let component: ConsiglioAlberiListComponent;
  let fixture: ComponentFixture<ConsiglioAlberiListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsiglioAlberiListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsiglioAlberiListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
