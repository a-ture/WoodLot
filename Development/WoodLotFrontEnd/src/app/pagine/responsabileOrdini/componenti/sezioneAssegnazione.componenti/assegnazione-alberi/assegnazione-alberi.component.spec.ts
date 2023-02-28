import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssegnazioneAlberiComponent } from './assegnazione-alberi.component';

describe('AssegnazioneAlberiComponent', () => {
  let component: AssegnazioneAlberiComponent;
  let fixture: ComponentFixture<AssegnazioneAlberiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssegnazioneAlberiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AssegnazioneAlberiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
