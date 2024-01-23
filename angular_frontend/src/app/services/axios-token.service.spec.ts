import { TestBed } from '@angular/core/testing';

import { AxiosTokenService } from './axios-token.service';

describe('AxiosTokenService', () => {
  let service: AxiosTokenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AxiosTokenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
