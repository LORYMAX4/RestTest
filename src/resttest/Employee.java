package resttest;

public class Employee 
{
    public int emloyeeId;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;

    public Employee (int emloyeeId, String firstName, String lastName, String email, String phone) 
    {
        this.emloyeeId = emloyeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}