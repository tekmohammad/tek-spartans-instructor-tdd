package playground;

public class Activity2 {

    //Write a method that takes firstName and Last Name as parameters
    //and Return full name in format LASTNAME, Firstname
    // mohammad -> Mohammad

    //Step 2) Write A test in TestNG to test above method functionality
    public String getFullName(String firstName, String lastName) {
        if (firstName == null || lastName == null)
            throw new RuntimeException("FirstName or Last Name can NOT be null");

        if (firstName.isEmpty() || lastName.isEmpty())
            throw new RuntimeException("First Name or Last Name can NOT be Empty");

        lastName = lastName.trim();
        firstName = firstName.trim();

        return lastName.toUpperCase() + ", " +
                firstName.substring(0, 1).toUpperCase() +
                firstName.substring(1).toLowerCase();
    }






}
