import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneAlberoComponent } from './sezione-albero.component';

describe('SezioneAlberoComponent', () => {
  let component: SezioneAlberoComponent;
  let fixture: ComponentFixture<SezioneAlberoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneAlberoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneAlberoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
