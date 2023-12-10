import java.io.Serializable;

import java.util.ArrayList;

import java.util.List;

 
public class ReserveBlockList implements Serializable
{
  
 
private List < ReserveBlock > reservations;
  
 
public ReserveBlockList ()
  {
    
reservations = new ArrayList <> ();
  
}
  
 
public List < ReserveBlock > getReservations ()
  {
    
return reservations;
  
}
  
 
public void setReservations (List < ReserveBlock > reservations)
  {
    
this.reservations = reservations;
  
} 
 
public boolean reserveBlock (ReserveBlock rb)
  {
    
if (checkExist (rb, reservations))
      {
	
System.out.println ("Sorry, booked in " + rb.getDate () + " at " +
			     rb.getClock () + "!");
	
return false;
      
}
    else
      {
	
reservations.add (rb);
	
System.out.println ("Done, Room " + rb.getRoom ().getName () +
			     " booked in " + rb.getDate () + " at " +
			     rb.getClock () + ".");
	
return true;
      
}
  
}
  
 
public boolean removeBlock (ReserveBlock rb)
  {
    
int index = findIndex (rb);
    
if (index != -1)
      {
	
System.out.println ("Removed " + reservations.get (index));
	
reservations.remove (index);
	
return true;
      
}
    
System.out.println ("Sorry, could not find the block to remove!");
    
return false;
  
}
  
 
public void printReservedBlocks ()
  {
    
if (reservations.isEmpty ())
      
System.out.println ("No reservations have been made!");
    
    else
    
for (ReserveBlock block:reservations)
	{
	  
System.out.println (block);
	
}
  
}
  
 
private boolean checkExist (ReserveBlock rb, List < ReserveBlock > rooms)
  {
  
for (ReserveBlock room:rooms)
      {
	
if (room.equals (rb))
	  
return true;
      
}
    
return false;
  
}
  
 
private int findIndex (ReserveBlock rb)
  {
    
for (int i = 0; i < reservations.size (); i++)
      {
	
if (rb.getDate ().equals (reservations.get (i).getDate ()) 
	     &&rb.getClock () == reservations.get (i).getClock () 
	     &&rb.getRoom ().getName ().equalsIgnoreCase (reservations.
							  get (i).getRoom ().
							  getName ()))
	  {
	    
return i;
	  
}
      
}
    
return -1;
  
}

}


