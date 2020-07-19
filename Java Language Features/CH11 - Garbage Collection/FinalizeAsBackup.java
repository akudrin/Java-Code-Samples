public class FinalizeAsBackup {
    /* Other codes go here */
    SomeResource sr;

public void aMethod() {
sr = Obtain the resources here...;
/* Do some processing . . . */
/* Note the conditional freeing of resources */
if (some condition is true) {
/* Free resources here calling finalize() */
this.finalize();
}
}

public void finalize() {
/* Free the resources if they have not been freed yet */
if (resources not yet freed ) {
free resources now;
}
}

}
