import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrdineEffettuatoComponent } from './ordine-effettuato.component';

describe('OrdineEffettuatoComponent', () => {
  let component: OrdineEffettuatoComponent;
  let fixture: ComponentFixture<OrdineEffettuatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrdineEffettuatoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OrdineEffettuatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
