import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouselImmaginiComponent } from './carousel-immagini.component';

describe('CarouselImmaginiComponent', () => {
  let component: CarouselImmaginiComponent;
  let fixture: ComponentFixture<CarouselImmaginiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarouselImmaginiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarouselImmaginiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
