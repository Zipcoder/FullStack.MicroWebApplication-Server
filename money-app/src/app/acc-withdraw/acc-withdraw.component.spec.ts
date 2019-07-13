import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccWithdrawComponent } from './acc-withdraw.component';

describe('AccWithdrawComponent', () => {
  let component: AccWithdrawComponent;
  let fixture: ComponentFixture<AccWithdrawComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccWithdrawComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccWithdrawComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
