import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PercheCategoriaComponent } from './perche-categoria.component';

describe('PercheCategoriaComponent', () => {
  let component: PercheCategoriaComponent;
  let fixture: ComponentFixture<PercheCategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PercheCategoriaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PercheCategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
