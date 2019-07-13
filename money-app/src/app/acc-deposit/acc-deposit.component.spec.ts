import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccDepositComponent } from './acc-deposit.component';

describe('AccDepositComponent', () => {
  let component: AccDepositComponent;
  let fixture: ComponentFixture<AccDepositComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccDepositComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccDepositComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
