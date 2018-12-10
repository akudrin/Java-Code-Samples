Short-circuit operators can be used to check for null objects before performing an operation:
 
 if(x != null && x.getValue() < 5) { 
 // Do something
}

if x was null, then the short-circuit prevents a NullPointerException from ever being thrown, 
since the evaluation of x.getValue() < 5 is never reached.
