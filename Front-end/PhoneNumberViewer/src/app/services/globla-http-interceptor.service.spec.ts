import { TestBed } from '@angular/core/testing';

import { GloblaHttpInterceptorService } from './globla-http-interceptor.service';

describe('GloblaHttpInterceptorService', () => {
  let service: GloblaHttpInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GloblaHttpInterceptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
