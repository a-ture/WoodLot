import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScegliIlTuoAlberoComponent } from './scegli-il-tuo-albero.component';

describe('ScegliIlTuoAlberoComponent', () => {
  let component: ScegliIlTuoAlberoComponent;
  let fixture: ComponentFixture<ScegliIlTuoAlberoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScegliIlTuoAlberoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScegliIlTuoAlberoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
