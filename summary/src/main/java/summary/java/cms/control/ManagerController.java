package summary.java.cms.control;
import java.util.Scanner;

import summary.java.cms.domain.Manager;
import summary.java.cms.util.ArrayList;

public class ManagerController {
    public Scanner keyIn;
    private ArrayList<Manager> managers = new ArrayList<>();
    
    public ManagerController(Scanner keyIn) {
        this.keyIn = keyIn;
    }
    
    public void serviceManagerMenu() {
        while(true) {
            System.out.print("\nManager Management> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManagers();
            }   else if(command.equals("add")) {
                inputManagers();
            }   else if(command.equals("delete")) {
                deleteManager();
            }   else if(command.equals("detail")) {
                detailManager();
            }      else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("Invalid Command..");
            }
        }
    }
    
    private void inputManagers() {
        while (true) {
            Manager m = new Manager();
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("E-Mail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("Tel : ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("Position : ");
            m.setPosition(keyIn.nextLine());
            
            managers.add(m);
            
            System.out.print("\nContinue? [Y/n] ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    private void printManagers() {
        System.out.print("No.\tName\tEmail\t\tPassword\tTel\t\tPosition");
        for(int i = 0; i < managers.size(); i++) {
            Manager m = (Manager) managers.get(i);
            System.out.printf("\n %s : \t%s \t%s \t%s \t%s \t%s",
                    i,
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition()
                    );
        }
        System.out.println();
    }
    
    private void deleteManager() {
        System.out.print("No. for delete : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= managers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        managers.remove(no);
        
        System.out.println("delete No...");
    }
    
    private void detailManager() {
        System.out.print("No. for ask : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if (no < 0 || no >= managers.size()) {
            System.out.println("Invalid No.");
            return;
        }
        Manager manager = (Manager) managers.get(no);
        
        System.out.printf("\nName : %s\n", manager.getName());
        System.out.printf("E-Mail : %s\n", manager.getEmail());
        System.out.printf("Password : %s\n", manager.getPassword());
        System.out.printf("Tel : %s\n", manager.getTel());
        System.out.printf("Position : %s\n", manager.getPosition());
    }
    
    {
        Manager m = new Manager();
        m.setName("a");
        m.setEmail("a@asdf.com");
        m.setPassword("asdf1020");
        m.setTel("01010203404");
        m.setPosition("Ace");
        managers.add(m);
    }
}
