//Week 6 Assignment Part 1				Author: Joe Cruz

//This class is used to set the name of the employee and return the employee name

public class Person {

	private String firstName;  //storing the first name
	private String lastName;   //storing the last name
	
	public Person() 			//Default constructor
	{
		firstName= "";
		lastName = ""; }
	
	//Constructor with parameters
	public Person(String first, String last)	
	{
		setName(first, last);
	}

	//Method to output the first and last name
	public String toString()
	{
		return (firstName + " "+ lastName);           
	}
	
	//Method to set firstName and lastName
	public void setName(String first, String last)
	{
		firstName = first;
		lastName = last;

	}
	//Method to return the firstName
	public String getFirstName() 
	{
		return firstName;
	}
	//Method to return the lastName
	public String getLastName()
	{
		
		return lastName;
	}
	
	//main function actually performs the code created. Allows for user testing. 
public static void main(String[] args) {
	
	PaidAdvisor PA = new PaidAdvisor("John", "Wayne");
	PA.calculatePay();

	
}
}



