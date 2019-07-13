import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccTransferComponent } from './acc-transfer.component';

describe('AccTransferComponent', () => {
  let component: AccTransferComponent;
  let fixture: ComponentFixture<AccTransferComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccTransferComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccTransferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
