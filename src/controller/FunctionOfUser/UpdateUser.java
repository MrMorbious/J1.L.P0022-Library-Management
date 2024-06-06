package controller.FunctionOfUser;

import controller.FunctionOfUser.validators.UserUpdateValidator;
import model.user.Users;
import model.user.UsersData;
import view.ListMenu;

import java.time.LocalDate;

public class UpdateUser extends UserUpdateValidator {
    private final Users UserModel;

    public UpdateUser(Users userModel) {
        UserModel = userModel;
    }
    public void UserUpdateUser() {
        int idUser = validateID();
        if (UserModel.getIndexUserById(idUser) == -1) {
            System.out.println(" User's ID is not exist!");
            UserUpdateUser();
        }
        System.out.println("\n---> Leave blank to keep current <---");
        UsersData userData = UserModel.getUserById(idUser);

        String name = validateName(userData.getName());
        userData.setName(name);

        LocalDate dob = validateDateOfBirth(userData.getDob());
        userData.setDob(dob);

        String phone = validatePhoneNumber(userData.getPhoneNumber());
        userData.setPhoneNumber(phone);

        String email = validateEmail(userData.getEmail());
        userData.setEmail(email);

        boolean active = validateChangeActive(userData.isActive_user());
        userData.setActive_user(active);

        UserModel.update(idUser,userData);

        System.out.println("\nUpdate success !");
        System.out.println("Continue updating another user ?");
        if (ListMenu.continueFeature() == 1){
            UserUpdateUser();
        }
    }
}
