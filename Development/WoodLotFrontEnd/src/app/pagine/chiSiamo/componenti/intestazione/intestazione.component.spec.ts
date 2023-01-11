import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IntestazioneComponent } from './intestazione.component';

describe('IntestazioneComponent', () => {
  let component: IntestazioneComponent;
  let fixture: ComponentFixture<IntestazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IntestazioneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IntestazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
