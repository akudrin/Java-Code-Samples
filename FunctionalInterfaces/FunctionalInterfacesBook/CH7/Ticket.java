import java.time.LocalDate;

abstract class Ticket implements Comparable<Ticket>
{
    String customerName;
    int id;
    String description;
    LocalDate dueDate;
    LocalDate servicedDate;
    public Ticket(String cn, int i, String d, int due)
    {
        customerName = cn;
        id = i;
        description = d;
        dueDate = LocalDate.now().plusDays(due);
        servicedDate = LocalDate.now().minusDays(1);
    }
     @Override
     public String toString()
     {
         return "NAME: " + customerName
                 + "\nID: " + id
                 + "\nDESCRIPTION: " + description
                 + "\nDUE DATE: " + dueDate
                 + "\nSERVICED DATE: " + servicedDate;
     }
    @Override
    public int compareTo(Ticket t)
    {
        return dueDate.compareTo(t.dueDate);
    }
}