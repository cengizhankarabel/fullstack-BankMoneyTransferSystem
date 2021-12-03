class User {
    static nextId:number = 0;
    public id:number;
    public firstName:string;
    public lastName:string;
    public email:string;
    public password:string;

    constructor(firstName:string, lastName:string, email:string, password:string) {
        User.nextId ++;
        this.id=User.nextId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password= password;
    }
}

export {User}



