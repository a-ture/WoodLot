import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DiventaContadinoComponent } from './diventa-contadino.component';

describe('DiventaContadinoComponent', () => {
  let component: DiventaContadinoComponent;
  let fixture: ComponentFixture<DiventaContadinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DiventaContadinoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DiventaContadinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
