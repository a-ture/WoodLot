import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RiassegnazioneAlberiComponent } from './riassegnazione-alberi.component';

describe('RiassegnazioneAlberiComponent', () => {
  let component: RiassegnazioneAlberiComponent;
  let fixture: ComponentFixture<RiassegnazioneAlberiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RiassegnazioneAlberiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RiassegnazioneAlberiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
