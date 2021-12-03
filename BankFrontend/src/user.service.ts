

import { User } from "./user.model";

class UserService {

    users: Array<User> = [];

    saveUser(firstName: string, lastName: string, email: string, password: string) {
        const newUser = new User(firstName, lastName, email, password);
        this.users = this.users.concat(newUser);
    }

    findUserByEmail(email: string) {

        this.users = this.users.map(user => {
            if (user.email === email) {
                return { ...user }
            } else {
                return user
            }
        })
    }


    userLogin(email: string, password: string) {
        this.users = this.users.map(user => {
            if (user.email === email && user.password === password) {
                return { ...user }
            } else {
                return user
            }
        })
    }


}


export{UserService}
