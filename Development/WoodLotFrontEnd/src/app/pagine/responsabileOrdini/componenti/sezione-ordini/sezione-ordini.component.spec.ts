import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneOrdiniComponent } from './sezione-ordini.component';

describe('SezioneOrdiniComponent', () => {
  let component: SezioneOrdiniComponent;
  let fixture: ComponentFixture<SezioneOrdiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneOrdiniComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneOrdiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
