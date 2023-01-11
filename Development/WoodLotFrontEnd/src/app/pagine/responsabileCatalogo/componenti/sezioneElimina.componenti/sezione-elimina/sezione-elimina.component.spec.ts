import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneEliminaComponent } from './sezione-elimina.component';

describe('SezioneEliminaComponent', () => {
  let component: SezioneEliminaComponent;
  let fixture: ComponentFixture<SezioneEliminaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SezioneEliminaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SezioneEliminaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
