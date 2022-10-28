public class Person
{
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String ssn;

    public Person(String fName, String lName, String dob, String social)
    {
        firstName = fName;
        lastName = lName;
        dateOfBirth = dob;
        ssn = social;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String setFirstName(String newFirst)
    {
        String oldFirst = firstName;
        firstName = newFirst;
        return oldFirst;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String setLastName(String newLast)
    {
        String oldLast = lastName;
        lastName = newLast;
        return oldLast;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public String getDOB()
    {
        return dateOfBirth;
    }

    public String setDOB(String newDOB)
    {
        String oldDOB = dateOfBirth;
        dateOfBirth = newDOB;
        return oldDOB;
    }

    public String getSSN()
    {
        return ssn;
    }

    public String setSSN(String newSSN)
    {
        String oldSSN = ssn;
        ssn = newSSN;
        return oldSSN;
    }
}
