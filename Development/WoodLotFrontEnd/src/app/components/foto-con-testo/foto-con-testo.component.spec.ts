import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoConTestoComponent } from './foto-con-testo.component';

describe('FotoConTestoComponent', () => {
  let component: FotoConTestoComponent;
  let fixture: ComponentFixture<FotoConTestoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FotoConTestoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotoConTestoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
