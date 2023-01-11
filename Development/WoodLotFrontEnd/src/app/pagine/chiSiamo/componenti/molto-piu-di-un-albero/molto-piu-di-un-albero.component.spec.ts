import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MoltoPiuDiUnAlberoComponent } from './molto-piu-di-un-albero.component';

describe('MoltoPiuDiUnAlberoComponent', () => {
  let component: MoltoPiuDiUnAlberoComponent;
  let fixture: ComponentFixture<MoltoPiuDiUnAlberoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MoltoPiuDiUnAlberoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MoltoPiuDiUnAlberoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
