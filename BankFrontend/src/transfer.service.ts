import { Account } from "./account.model";
import { AccountService } from "./account.service";
import { Transfer } from "./transfer.model";
import { User } from "./user.model";

const url="http://localhost:8080/transactions";

class TransferService{

    transfers:Array<Transfer>=[];
    
    makeTransfer(amount:number, id:number , senderAccountNumber:string,receiverAccountNumber:string, dao:Date){
        // const newTransfer=new Transfer(senderAccountNumber,receiverAccountNumber,amount)
        // this.transfers = this.transfers.concat(newTransfer);   
        // console.log(this.transfers);

        // const  accountService = new AccountService



        return fetch(url, { 
            method: 'POST',
            body:JSON.stringify({amount, id:Transfer.nextId, senderAccountNumber, receiverAccountNumber,  dao }),
            
            headers:{
                'Content-Type':'application/json'
            }
        })    
         
    }

    getTransfers() {
        // return this.transfers
        return fetch(url, { method: 'GET' })
            .then(response => response.json());

        // return fetch(url)
        //     .then(response => response.json);
    }
}

export {TransferService}