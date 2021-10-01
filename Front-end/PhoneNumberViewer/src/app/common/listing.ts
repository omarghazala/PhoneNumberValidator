export class Listing {
    id?:number;
    number?: string;
    numberState?: string;
    countryId?:string;
    name?:string;
    code?:string;

    public constructor(init?: Partial<Listing>) {
        Object.assign(this, init);
    }
}

