import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneContadiniComponent } from './sezione-contadini.component';

describe('SezioneContadiniComponent', () => {
  let component: SezioneContadiniComponent;
  let fixture: ComponentFixture<SezioneContadiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneContadiniComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneContadiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
