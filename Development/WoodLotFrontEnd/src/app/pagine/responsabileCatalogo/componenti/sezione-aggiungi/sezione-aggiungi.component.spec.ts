import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneAggiungiComponent } from './sezione-aggiungi.component';

describe('SezioneAggiungiComponent', () => {
  let component: SezioneAggiungiComponent;
  let fixture: ComponentFixture<SezioneAggiungiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneAggiungiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneAggiungiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
