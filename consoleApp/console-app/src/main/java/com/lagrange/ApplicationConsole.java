package com.lagrange;

import com.lagrange.entity.Colocation;
import com.lagrange.entity.User;
import com.lagrange.usecase.colocation.createColocation.CreateColocationBoundary;
import com.lagrange.usecase.colocation.joinColocation.ColocationCredentials;
import com.lagrange.usecase.colocation.joinColocation.ColocationJoinBoundary;
import com.lagrange.usecase.colocation.listAllColocation.ListAllColocationBoundary;
import com.lagrange.usecase.user.createUser.CreateUserService;
import com.lagrange.usecase.user.createUser.UserCredential;
import com.lagrange.usecase.user.listAllUser.ListAllUserService;

import java.util.Scanner;

public class ApplicationConsole {

    private final ColocationJoinBoundary colocationJoinBoundary;
    private final ListAllUserService listAllUserService;
    private final ListAllColocationBoundary listAllColocationBoundary;
    private final CreateColocationBoundary createColocationBoundary;
    private final CreateUserService createUserService;

    public ApplicationConsole(ColocationJoinBoundary colocationJoinBoundary, ListAllUserService listAllUserService, ListAllColocationBoundary listAllColocationBoundary, CreateColocationBoundary createColocationBoundary, CreateUserService createUserService) {
        this.colocationJoinBoundary = colocationJoinBoundary;
        this.listAllUserService = listAllUserService;
        this.listAllColocationBoundary = listAllColocationBoundary;
        this.createColocationBoundary = createColocationBoundary;
        this.createUserService = createUserService;
    }

    public void start(){
        //Configuration configuration = Configuration.getConfiguration();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("CU - Create user");
            System.out.println("LU - List user ");
            System.out.println("CC - Create colocation ");
            System.out.println("LC - List Colocation ");
            System.out.println("JC - Join Colocation");

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
                case "JC":
                    System.out.println("<pseudo>;<userPassword>;<colocationTag>;<colocationPassword>");
                    String troisiemeEntreeColoc = scanner.nextLine();
                    makeUserJoinColoc(troisiemeEntreeColoc);
                    break;
                default:
                    System.out.println("Commande inconnue.");
                    break;
            }
        }
    }

    private void makeUserJoinColoc(String troisiemeEntreeColoc)  {
        String[] entries = troisiemeEntreeColoc.split(";");
        try {
           colocationJoinBoundary.addUserToColocation(
                    new UserCredential(entries[0],entries[1]),
                    new ColocationCredentials(entries[2],entries[3])
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  void displayAllUser() {
        for(User userDto : listAllUserService.listAll()){
            System.out.println(userDto.getPseudo() + " - " + userDto.getPassword());
        }
    }

    private  void displayAllColocation() {
        for(Colocation coloc : listAllColocationBoundary.listAll()){
            System.out.println(coloc.getPseudo() + " - " + coloc.getPassword() + " - #" + coloc.getTag());
        }
    }

    private  void insertColocation(String name, String pwd, String tag) {
        Colocation colocation = new Colocation(name, pwd, tag);
        try {
            createColocationBoundary.create(colocation.getPseudo(), colocation.getPassword(), colocation.getTag());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private  void insertUser(String password, String pseudo) {
        try {
            createUserService.create(pseudo, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
