public class Notes {
    
    public static void main(String args[]) {
        checkAge(19);
    }

    //Exception class - has all exception subclasses
    //https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html

    public static void checkAge(int age) throws ArithmeticException{ //add the exception to the functio definition
        if (age < 18) {
            throw new ArithmeticException("Access Denied - You must be at least 18 years old.");
        }
        System.out.println("Access Granted - You are old enough.");
    }

}
