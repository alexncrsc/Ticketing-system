public class SystemServiceImpl implements SystemService {
    @Override
    public void performAction1() {
        // Implementare pentru operația 1
        System.out.println("Action 1");
        
    }

    @Override
    public String performAction2(int parameter) {
        // Implementare pentru operația 2
        System.out.println("Action was done, the id number for the action is " + parameter);
        return "Result of Action 2"; 
    }
}
