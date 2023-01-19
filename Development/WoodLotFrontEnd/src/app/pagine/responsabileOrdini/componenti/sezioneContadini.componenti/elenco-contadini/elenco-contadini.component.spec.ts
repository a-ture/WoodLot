import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElencoContadiniComponent } from './elenco-contadini.component';

describe('ElencoContadiniComponent', () => {
  let component: ElencoContadiniComponent;
  let fixture: ComponentFixture<ElencoContadiniComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ElencoContadiniComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ElencoContadiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
