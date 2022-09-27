package com.lagrange;

public class Main {
    public static void main(String[] args) {

        ApplicationConsole app = new ApplicationConsole(
            Configuration.getConfiguration().colocationJoinBoundary,
            Configuration.getConfiguration().listAllUserService,
            Configuration.getConfiguration().listAllColocationBoundary,
            Configuration.getConfiguration().createColocationBoundary,
            Configuration.getConfiguration().createUserService
        );
        app.start();
    }
}
