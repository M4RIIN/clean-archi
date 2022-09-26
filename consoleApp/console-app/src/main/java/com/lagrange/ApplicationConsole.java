package com.lagrange;


import com.lagrange.usecase.model.user.UserDto;
import com.lagrange.usecase.model.user.colocation.Colocation;

import java.util.Scanner;

public class ApplicationConsole {
    public static void main(String[] args) {
        Configuration configuration = Configuration.getConfiguration();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("CU - Create user");
            System.out.println("LU - List user ");
            System.out.println("CC - Create colocation ");
            System.out.println("LC - List Colocation ");

            String entreeUser = scanner.nextLine();
            switch (entreeUser){
                case "CU":
                    System.out.println("<pseudo>;<password>");
                    String secondEntreeUser = scanner.nextLine();
                    insertUser(secondEntreeUser.split(";")[1],secondEntreeUser.split(";")[0]);
                    break;
                case "LU":
                    displayAllUser();
                    break;
                case "CC":
                    System.out.println("<pseudo>;<password>;<tag>");
                    String secondEntreeColoc = scanner.nextLine();
                    insertColocation(secondEntreeColoc.split(";")[0],secondEntreeColoc.split(";")[1],secondEntreeColoc.split(";")[2]);
                    break;
                case "LC":
                    displayAllColocation();
                    break;
                default:
                    System.out.println("Commande inconnue.");
                    break;
            }
        }
    }

    private static void displayAllUser() {
        for(UserDto userDto : Configuration.getConfiguration().listAllUserService.listAll()){
            System.out.println(userDto.getPseudo() + " - " + userDto.getPassword());
        }
    }

    private static void displayAllColocation() {
        for(Colocation coloc : Configuration.getConfiguration().listAllColocationBoundary.listAll()){
            System.out.println(coloc.getPseudo() + " - " + coloc.getPassword() + " - #" + coloc.getTag());
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
