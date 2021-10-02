import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'countryCode' })
export class CountryCodePipe implements PipeTransform{
    transform(countryCode:string) {
        return `+${countryCode.slice(1,countryCode.length-1)}`
    }

}