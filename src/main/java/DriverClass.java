import domain.models.Member;
import domain.models.Project;
import processor.CommandProcessorImpl;
import processor.CommandProcessor;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class DriverClass {

    public static void main(String []args){
        System.out.println("Welcome to trello");
        Member suman = new Member("suman", "suman.saurabh@gmail.com");
        Member sandeep = new Member("sandeep", "sandeep@gmail.com");
        Member utkarsh = new Member("utkarsh", "utkarsh@gmail.com");

        Project myProject = Project.getInstance();
        myProject.addMembers(Arrays.asList(suman, sandeep, utkarsh));

        Scanner scanner = new Scanner(System.in);
        CommandProcessor commandProcessor = new CommandProcessorImpl(myProject);
        boolean exit = false;
        while(!exit){
            System.out.println("Enter command");
            String command = scanner.nextLine();
            if(command.equalsIgnoreCase("exit")){
                exit = true;
            }else{
                try{
                    commandProcessor.process(command);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("exiting......");
    }
}
