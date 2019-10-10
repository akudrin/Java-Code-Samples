class HardwareTicket extends Ticket
{
    String device;
    String model;
    String serialNumber;
    public HardwareTicket(String cn, int i, String d, int due,
                          String dev, String mod, String sn)
    {
        super(cn, i, d, due);
        device = dev;
        model = mod;
        serialNumber = sn;
    }
    @Override
    public String toString()
    {
        return super.toString()
                + "\nDEVICE: " + device
                + "\nMODEL: " + model
                + "\nSERIAL NUMBER: " + serialNumber;
    }
}