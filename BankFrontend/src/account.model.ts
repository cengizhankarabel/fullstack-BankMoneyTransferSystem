import { User } from "./user.model";


class Account {

    static nextAccountNumber:string = "";
    public accountNumber:string;
    public balance:number;
    public user_id:number;
    
    constructor(balance:number,user_id:number) {
        Account.nextAccountNumber= "RE"+ makeIdNumber(14);
        this.accountNumber=Account.nextAccountNumber;
        this.balance=balance;
        this.user_id=user_id;

        function makeIdNumber(length:any) {
            var result           = '';
            var characters       = '0123456789';
            var charactersLength = characters.length;
            for ( var i = 0; i < length; i++ ) {
              result += characters.charAt(Math.floor(Math.random() * 
         charactersLength));
           }
           return result;
        }
    
    }
}
export {Account}