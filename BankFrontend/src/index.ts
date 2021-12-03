import './index.scss'

import {TransferService} from './transfer.service'
import {UserService} from './user.service'
import { AccountService } from './account.service'


import { Transfer } from './transfer.model'
import { User} from './user.model'
import { Account} from './account.model'

import { prototype } from 'html-webpack-plugin'


const accountService = new AccountService
const transferService = new TransferService
const userService = new UserService

//----------------------------------------------------------------------
//  DOM Field
//----------------------------------------------------------------------

const newSenderAccountField = document.getElementById("receiverAccount");
const newReceiverAccountField = document.getElementById("senderAccount");
const newTransferAmountField = document.getElementById("transferAmount");
const newTransferMoneyButton = document.getElementById("transferMoney");


const transferListElement = document.getElementById("transfer-list");




newTransferMoneyButton.addEventListener('click', (e:MouseEvent)=> {

    e.preventDefault();
    
    let fromACC = (newSenderAccountField as HTMLInputElement).value;
    let toACC = (newReceiverAccountField as HTMLInputElement).value;
    let amount= (newTransferAmountField as HTMLInputElement).value;
    

    console.log(fromACC);
    console.log(toACC);
    console.log(parseFloat(amount));
   
    

    

    transferService.makeTransfer(parseFloat(amount),Transfer.nextId,fromACC,toACC,new Date())
        .then(response => {
            (newSenderAccountField as HTMLInputElement).value = "";
            (newReceiverAccountField as HTMLInputElement).value = "";
            (newTransferAmountField as HTMLInputElement).value = "";
        renderTransfers()
    })

    
    
})



// <li class="list-group-item">
// <span> ${transfer.id} </span>
// <span> ${transfer.senderAccountNumber} </span>
// <span> ${transfer.receiverAccountNumber} </span>
// <span> ${transfer.amount} </span>
// <span> ${transfer.dob} </span>
// </li> 



// <thead>
// <tr>
// <th scope="col">#id</th>
// <th scope="col">From</th>
// <th scope="col">To</th>
// <th scope="col">Amount</th>
// <th scope="col">Date</th>
// </tr>
// </thead>


//----------------------------------------------------------------------
//  Render Todos
//--------------------------------------------------------------- -------

async function renderTransfers(){
    const transfers = await transferService.getTransfers()
    const transferListElements = transfers.map((transfer:any)=>{
        return `
            <table class="table">
  
            <tbody>
                <tr>
                <th scope="row">${transfer.id}</th>
                <td>${transfer.account.accountNumber}</td>
                <td>${transfer.receiverAccountNumber}</td>
                <td>${transfer.amount}</td>
                <td>${new Date(transfer.dob).getMonth()}/${new Date(transfer.dob).getDay()}/${new Date(transfer.dob).getFullYear()}</td>
                </tr>
            </tbody>
            </table>  
          `



          
    });
    transferListElement.innerHTML = transferListElements.join("")
}

renderTransfers();