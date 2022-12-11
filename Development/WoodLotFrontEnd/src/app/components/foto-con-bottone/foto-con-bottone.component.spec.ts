import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FotoConBottoneComponent } from './foto-con-bottone.component';

describe('FotoConBottoneComponent', () => {
  let component: FotoConBottoneComponent;
  let fixture: ComponentFixture<FotoConBottoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FotoConBottoneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FotoConBottoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
