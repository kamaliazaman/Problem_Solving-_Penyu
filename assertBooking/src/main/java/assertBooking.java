import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author PENYU
 */
public class assertBooking {
    public void display_menu() 
    {
	System.out.println("1)Sport Hall 1\n2)Seminar Room 2\n3)Volleyball Court");
	System.out.print("Selection: ");
    }
    
    public assertBooking() 
    {
	Scanner in = new Scanner(System.in);
        display_menu();
  
	switch (in.nextInt()) 
	{
	    case 1:
	    System.out.println ( "You picked option 1" );
	    break;
	    case 2:
	    System.out.println ( "You picked option 2" );
	    break;
	    case 3:
	    System.out.println ( "You picked option 3" );
	    break;
	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
    }
    public static void main(String[] args) throws ParseException{
           
         System.out.println("ASSERT EXAMPLE");
        System.out.println("\n\nHello Welcome to UTM Booking Facilities System");
        System.out.println("Please Choose which facilities to book");
        
        
        new assertBooking();
        
        Scanner q = new Scanner(System.in);
        String format = "MM/dd/yyyy";                                         
        SimpleDateFormat sdf = new SimpleDateFormat(format);


        System.out.println("\nPlease Provide the details below");
        System.out.println("Example: MM/dd/yyyy");
        System.out.print("Enter date of Event: ");
        String date = q.nextLine();
        System.out.print("Name: ");
        String name = q.nextLine();
        System.out.print("No Phone: ");
        String noPhone = q.nextLine();
      
	System.out.println("\nTo proceed enter 9.");
	System.out.println("If you wish to quit enter 0.");
       
	switch (q.nextInt()) 
	{
	    case 0:
	    System.out.println ("Thank you and godbye.");
	    break;
  
	    case 9:
	    System.out.println ("Please proceed.");
	  //  new assertBooking();
	    break;
	    default:
	    System.err.println ( "Unrecognized option" );
	    break;
	}
            String bookingDate, eventDate;
            //to make assert take action, the difference between bookingDate
            //and eventDate should less than 3
            bookingDate = "03/17/2020";
            eventDate = date;

            //wrong date fromat
            //true date format MM/dd/yyyy
            //post condition


            Date bookingObj = sdf.parse(bookingDate);
            Date eventObj2 = sdf.parse(eventDate);
            System.out.println("\nYour Booking Details: " +"\nName: " +name + "\nNoPhone:" +noPhone);
            System.out.println("Your Booking Date: " + bookingObj);
            System.out.println("Your Event Date: " +eventObj2 + "\n");


            long diff = eventObj2.getTime() - bookingObj.getTime();

            int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
            System.out.println("**Difference between days: " + diffDays);

            checkDate(diffDays);
        
        	

        }
        public static void checkDate(int diffDays) {
            //pre-condition before submit booking application
            assert isThreeDayBefore(diffDays) : "Booking date must make 3 days before the event";
        }
        
         private static boolean isThreeDayBefore(int diffDays) {
            return diffDays > 3;
        }
         
       
}