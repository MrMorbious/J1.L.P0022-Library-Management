package controller.FunctionOfUser;

import controller.FunctionOfBook.validators.BookUpdateValidator;
import model.user.Users;
import model.user.UsersData;
import view.ListMenu;

public class DeleteUser extends BookUpdateValidator {
    public static Users usersModel = new Users();

    private final Users UserModel;
    public static DisplayUser displayUser = new DisplayUser(usersModel);

    public DeleteUser(Users userModel) {
        UserModel = userModel;
    }
    public void UserDeleteUser() {
        int idUser = validateID();
        if (UserModel.getIndexUserById(idUser) == -1) {
            System.out.println("Book's ID is not exist !");
            System.out.println("Continue deleting another book ?");
            if (ListMenu.continueFeature() == 1){
                UserDeleteUser();
            }
            return;
        }
        UsersData userData = UserModel.getUserById(idUser);
        System.out.println("Are you sure delete this book id ?");
        if (ListMenu.continueFeature() == 1) {
            UserModel.delete(idUser ,userData);
            userData.setActive_user(false);
            System.out.println("\nDelete success !");
            displayUser.UserDisplayUser();
        }
        System.out.println("Continue deleting another book ?");
        if (ListMenu.continueFeature() == 1) {
            UserDeleteUser();
        }
    }
}
