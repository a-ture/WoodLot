import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneAssegnazioneComponent } from './sezione-assegnazione.component';

describe('SezioneAssegnazioneComponent', () => {
  let component: SezioneAssegnazioneComponent;
  let fixture: ComponentFixture<SezioneAssegnazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneAssegnazioneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneAssegnazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
