import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CicloDiVitaAlberoComponent } from './ciclo-di-vita-albero.component';

describe('CicloDiVitaAlberoComponent', () => {
  let component: CicloDiVitaAlberoComponent;
  let fixture: ComponentFixture<CicloDiVitaAlberoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CicloDiVitaAlberoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CicloDiVitaAlberoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
