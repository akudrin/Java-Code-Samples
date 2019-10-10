enum Domain {WEB_HOSTED, PHONE_HOSTED}
class SoftwareTicket extends Ticket
{
    String application;
    String version;
    Domain domain;
    public SoftwareTicket(String cn, int i, String d, int due,
                          String app, String ver, Domain dom)
    {
        super(cn, i, d, due);
        application = app;
        version = ver;
        domain = dom;
    }
    @Override
    public String toString()
    {
        return super.toString()
                + "\nAPPLICATION: " + application
                + "\nVERSION: " + version
                + "\nDOMAIN: " + domain;
    }
}