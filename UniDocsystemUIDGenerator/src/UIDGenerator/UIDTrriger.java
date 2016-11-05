package UIDGenerator;

public class UIDTrriger {
    
    public static void main(String args[])throws Exception{
        
        UID uid = new UID();
        
        uid.generateUID((byte)1, 1000000000L, 9999999999L);
        System.out.println("Job Completed");
    }
    
}
