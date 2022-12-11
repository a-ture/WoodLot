import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoObiettiviComponent } from './foto-obiettivi.component';

describe('FotoObiettiviComponent', () => {
  let component: FotoObiettiviComponent;
  let fixture: ComponentFixture<FotoObiettiviComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FotoObiettiviComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotoObiettiviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
