import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimpostaPasswordComponent } from './reimposta-password.component';

describe('RecuperaPasswordComponent', () => {
  let component: ReimpostaPasswordComponent;
  let fixture: ComponentFixture<ReimpostaPasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimpostaPasswordComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReimpostaPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
