package com.lagrange;


import com.lagrange.usecase.model.user.UserDto;
import com.lagrange.usecase.model.user.colocation.Colocation;

public class ApplicationConsole {
    public static void main(String[] args) {
        Configuration configuration = Configuration.getConfiguration();
        insertUser( "marin1235", "Marin1");
        insertUser( "Marty", "McflyMarty12");

        insertColocation("colocation", "password", "1234");
        insertColocation("Coloc de Fou", "password", "8521");
        displayAllUser();
        displayAllColocation();
    }

    private static void displayAllColocation() {
        for(UserDto userDto : Configuration.getConfiguration().listAllUserService.listAll()){
            System.out.println(userDto.getPseudo() + " - " + userDto.getPassword());
        }
    }

    private static void displayAllUser() {
        for(Colocation coloc : Configuration.getConfiguration().listAllColocationBoundary.listAll()){
            System.out.println(coloc.getPseudo() + "-" + coloc.getPassword() + " -  #" + coloc.getTag());
        }
    }

    private static void insertColocation(String name, String pwd, String tag) {
        Colocation colocation = new Colocation(name, pwd, tag);
        try {
            Configuration.getConfiguration().createColocationBoundary.create(colocation.getPseudo(), colocation.getPassword(), colocation.getTag());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void insertUser(String password, String pseudo) {
        try {
            Configuration.getConfiguration().createUserService.create(pseudo, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
