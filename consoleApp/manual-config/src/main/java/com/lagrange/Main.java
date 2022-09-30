package com.lagrange;

public class Main {
    public static void main(String[] args) {

        ApplicationConsole app = new ApplicationConsole(
            Configuration.getConfiguration().colocationJoinService,
            Configuration.getConfiguration().listAllUserService,
            Configuration.getConfiguration().listAllColocationService,
            Configuration.getConfiguration().createColocationService,
            Configuration.getConfiguration().createUserService
        );
        app.start();
    }
}
