import {HttpEvent, 
    HttpInterceptor, 
    HttpHandler, 
    HttpRequest, 
    HttpResponse, 
    HttpErrorResponse
} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {retry, catchError} from 'rxjs/operators';

export class HttpErrorInterceptor implements HttpInterceptor{

intercept(request:HttpRequest<any>, next:HttpHandler):Observable<HttpEvent<any>>{
    return next.handle(request)
    .pipe(
        retry(1),
        catchError((error: HttpErrorResponse)=>{
            let errorFlag=true;
            let errorMessage='';
            if(error.error instanceof ErrorEvent){
                errorMessage=`Error: ${error.error.message}`;
            }else{
                errorMessage=`${error.error}`;
                console.log(errorMessage);
            }
            if(errorFlag){
                window.alert(errorMessage);
            }
            return throwError(errorMessage);
        })
    )
}
}