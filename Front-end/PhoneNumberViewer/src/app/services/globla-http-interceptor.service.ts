import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class GloblaHttpInterceptorService implements HttpInterceptor{

  constructor(private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((error)=>{
        console.log('error in intercept')
        console.error(error);
        switch(error.status){
          case 500: {
            this.router.navigate(["/addFail"])
            break;
          }
          case 200 :{
            this.router.navigate(["/phoneNumbers"])
            break;
          }
         
          default : {
            this.router.navigate(["/serverDown"])
            break;
          }
        }
        
        return throwError(error.message);
      })
    )
    
  }

  intercept2(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
    const token: string = 'invald token';
    req = req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + token) });
 
    return next.handle(req).pipe(
      catchError((error) => {
        console.log('error in intercept 2')
        console.error(error);

        return throwError(error.message);
      })
    )
  }

  intercept3(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token: string = 'invald token';
    req = req.clone({ headers: req.headers.set('Authorization', 'Bearer ' + token) });
 
    return next.handle(req).pipe(
      catchError((error)=>{
        let handled: boolean = false;
        console.error(error);
        if (error instanceof HttpErrorResponse) {
          if (error.error instanceof ErrorEvent) {
            console.error("Error Event");
          } else {
            console.log(`error status 3 : ${error.status} ${error.statusText}`);
            switch (error.status) {
              case 401:      //login
              this.router.navigate(['/error'])
                console.log(`redirect to error`);
                handled = true;
                break;
              case 403:     //forbidden
              this.router.navigate(['/error'])
                console.log(`redirect to error`);
                handled = true;
                break;
            }
          }
        }
        else {
          console.error("Other Errors");
        }
 
        if (handled) {
          console.log('return back ');
          return of(error);
        } else {
          console.log('throw error back to to the subscriber');
          return throwError(error);
        }
      })
    )
  }
  


}
