import { Account } from "./account.model";
import { User } from "./user.model";

class AccountService{

    accounts:Array<Account>=[];

    saveAccount(balance:number, user_id:number){
        const newAccount=new Account(balance,user_id)
        this.accounts.concat(newAccount);
    }

    updateAccount(accNumber:string, newBalance:number){
        this.accounts = this.accounts.map(account => {
            if (account.accountNumber === accNumber){
                return{...account,balance:newBalance}
            }else{
                return account
            }
        })
    }

    deleteAccount(accNumber:string){
        this.accounts = this.accounts.filter(account => account.accountNumber !== accNumber)
    }

}

export {AccountService}