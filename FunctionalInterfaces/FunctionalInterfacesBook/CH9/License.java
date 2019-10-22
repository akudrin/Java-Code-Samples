import java.time.LocalDate;
import java.util.ArrayList;

enum STATUS {ACTIVE, SUSPENDED}
class License
{
    LocalDate expDate;
    String insurance;
    STATUS status;
    ArrayList<Vehicle> vehicles;
    public License(LocalDate e, String i, Vehicle... v)
    {
        expDate = e;
        insurance = i;
        status = STATUS.ACTIVE;
        vehicles = new ArrayList<>();
        for (Vehicle r : v)
            vehicles.add(r);
    }
    public License(LocalDate e, String i, STATUS s,
                   ArrayList<Vehicle> vs)
    {
        expDate = e;
        insurance = i;
        status = s;
        vehicles = new ArrayList<>(vs);
    }
    public License(License l)
    {
        expDate = l.expDate;
        insurance = l.insurance;
        status = l.status;
        vehicles = new ArrayList<>(l.vehicles);
    }
    @Override
    public String toString()
    {
        return expDate + " " + insurance + " " + status
                + " " + vehicles;
    }
}