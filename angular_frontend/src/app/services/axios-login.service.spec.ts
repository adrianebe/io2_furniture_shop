import { TestBed } from '@angular/core/testing';

import { AxiosLoginService } from './axios-login.service';

describe('AxiosLoginService', () => {
  let service: AxiosLoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AxiosLoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
