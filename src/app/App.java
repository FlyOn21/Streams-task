package app;

import app.controllers.UserController;

public class App {
    private static final UserController userController = new UserController();

    private void run() {
        userController.usersControllerProcessing();
    }
    public static void main(String[] args) {
        new App().run();
    }

}
