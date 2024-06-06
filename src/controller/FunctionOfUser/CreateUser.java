package controller.FunctionOfUser;

import controller.FunctionOfUser.validators.UserCreateValidator;
import model.user.Users;
import model.user.UsersData;
import view.ListMenu;

import java.time.LocalDate;

public class CreateUser extends UserCreateValidator {
    private final Users UserModel;

    public CreateUser(Users userModel) {
        UserModel = userModel;
    }
    public void UserCreateUser() {
        UsersData userData = new UsersData();

       String name = validateName();
       userData.setName(name);

       LocalDate dob = validateDateOfBirth();
       userData.setDob(dob);

       String phone = validatePhoneNumber();
       userData.setPhoneNumber(phone);

       String email = validateEmail();
       userData.setEmail(email);

       UserModel.add(userData);

        System.out.println("\nAdded success !");
        userData.setActive_user(true);
        System.out.println("Continue adding another user ?");
        if (ListMenu.continueFeature() == 1){
            UserCreateUser();
        }
    }
}
