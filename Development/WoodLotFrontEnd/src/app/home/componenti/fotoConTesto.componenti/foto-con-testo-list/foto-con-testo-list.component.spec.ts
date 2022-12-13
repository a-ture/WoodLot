import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoConTestoListComponent } from './foto-con-testo-list.component';

describe('FotoConTestoListComponent', () => {
  let component: FotoConTestoListComponent;
  let fixture: ComponentFixture<FotoConTestoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FotoConTestoListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotoConTestoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
