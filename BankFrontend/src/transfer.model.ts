

class Transfer {
    static nextId:number = 0;
    public id:number;
    public senderAccountNumber:string;
    public receiverAccountNumber:string;
    public amount:number;
    public dob:Date;

    constructor(senderAccountNumber:string, receiverAccountNumber:string, amount:number) {
        Transfer.nextId ++;
        this.id=Transfer.nextId;
        this.senderAccountNumber=senderAccountNumber;
        this.receiverAccountNumber=receiverAccountNumber;
        this.amount=amount;
        this.dob= new Date();
    }
}

export {Transfer}