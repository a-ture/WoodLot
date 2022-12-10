import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContadinoComponent } from './contadino.component';

describe('ContadinoComponent', () => {
  let component: ContadinoComponent;
  let fixture: ComponentFixture<ContadinoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContadinoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContadinoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
