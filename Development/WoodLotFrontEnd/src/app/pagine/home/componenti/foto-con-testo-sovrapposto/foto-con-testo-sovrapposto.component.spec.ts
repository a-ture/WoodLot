import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoConTestoSovrappostoComponent } from './foto-con-testo-sovrapposto.component';

describe('FotoConTestoSovrappostoComponent', () => {
  let component: FotoConTestoSovrappostoComponent;
  let fixture: ComponentFixture<FotoConTestoSovrappostoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FotoConTestoSovrappostoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotoConTestoSovrappostoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
