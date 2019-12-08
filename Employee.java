

public class Employee {

    public String firstName;
    public String lastName;


    public Employee(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;

    }



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getName(){
        return firstName + " " + lastName;
    }


    String toString(String firstName, String lastName){
        return "Employee [name=" + firstName +" "+lastName+ "]";
    }
}
