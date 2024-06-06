package controller.FunctionOfUser;

import model.user.Users;
import model.user.UsersData;
import view.ListMenu;

import java.util.Map;

public class DisplayUser {
    private final Users UserModel;

    public DisplayUser(Users userModel) {
        UserModel = userModel;
    }
    public void UserDisplayUser() {
        System.out.println(ListMenu.displayHeaderOfUser());
        for (Map.Entry<Integer, UsersData> books : UserModel.getMapUsers().entrySet()) {
            if (books.getValue().isActive_user()) {
                System.out.println(books.getValue().displayOfUser());
            }
        }
    }
    public void UserDisplayUserNotActive() {
        System.out.println(ListMenu.displayHeaderOfUser());
        for (Map.Entry<Integer, UsersData> books : UserModel.getMapUsers().entrySet()) {
            if (!books.getValue().isActive_user()) {
                System.out.println(books.getValue().displayOfUser());
            }
        }
    }
}
