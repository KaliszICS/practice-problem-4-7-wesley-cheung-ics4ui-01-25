import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.lang.reflect.InvocationTargetException;

public class PracticeProblemTest {
    
    // ==================== PROBLEM 1: Bank Account Withdrawal ====================
    
    @Test
    public void testWithdrawValidAmount() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("withdraw", double.class, double.class);
            double result = (double) method.invoke(null, 50.0, 100.0);
            assertEquals(50.0, result, 0.01);
        } catch (NoSuchMethodException e) {
            fail("withdraw method not implemented");
        } catch (Exception e) {
            fail("withdraw method threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testWithdrawNegativeAmount() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("withdraw", double.class, double.class);
            method.invoke(null, -10.0, 100.0);
            fail("Should have thrown IllegalArgumentException for negative amount");
        } catch (NoSuchMethodException e) {
            fail("withdraw method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("positive") || 
                          cause.getMessage().toLowerCase().contains("negative"),
                "Exception message should mention positive or negative");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testWithdrawZeroAmount() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("withdraw", double.class, double.class);
            method.invoke(null, 0.0, 100.0);
            fail("Should have thrown IllegalArgumentException for zero amount");
        } catch (NoSuchMethodException e) {
            fail("withdraw method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof IllegalArgumentException)) {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testWithdrawInsufficientFunds() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("withdraw", double.class, double.class);
            method.invoke(null, 150.0, 100.0);
            fail("Should have thrown IllegalStateException for insufficient funds");
        } catch (NoSuchMethodException e) {
            fail("withdraw method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalStateException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("fund") || 
                          cause.getMessage().toLowerCase().contains("balance"),
                "Exception message should mention funds or balance");
            } else {
                fail("Wrong exception type thrown. Expected IllegalStateException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    // ==================== PROBLEM 2: Age Validator ====================
    
    @Test
    public void testValidateAgeValid() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateAge", int.class);
            boolean result = (boolean) method.invoke(null, 25);
            assertTrue(result, "Valid age should return true");
        } catch (NoSuchMethodException e) {
            fail("validateAge method not implemented");
        } catch (Exception e) {
            fail("validateAge method threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateAgeNegative() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateAge", int.class);
            method.invoke(null, -5);
            fail("Should have thrown IllegalArgumentException for negative age");
        } catch (NoSuchMethodException e) {
            fail("validateAge method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue(
                          cause.getMessage().toLowerCase().contains("negative"), "Exception message should mention negative");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateAgeTooHigh() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateAge", int.class);
            method.invoke(null, 200);
            fail("Should have thrown IllegalArgumentException for unrealistic age");
        } catch (NoSuchMethodException e) {
            fail("validateAge method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("realistic") || 
                          cause.getMessage().toLowerCase().contains("150"), "Exception message should mention realistic or maximum");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateAgeBoundary() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateAge", int.class);
            boolean result = (boolean) method.invoke(null, 150);
            assertTrue(result, "Age of 150 should be valid");
        } catch (NoSuchMethodException e) {
            fail("validateAge method not implemented");
        } catch (Exception e) {
            fail("validateAge method threw unexpected exception: " + e.getMessage());
        }
    }
    
    // ==================== PROBLEM 3: Array Index Checker ====================
    
    @Test
    public void testGetElementValid() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("getElement", int[].class, int.class);
            int[] nums = {10, 20, 30};
            int result = (int) method.invoke(null, nums, 1);
            assertEquals(20, result);
        } catch (NoSuchMethodException e) {
            fail("getElement method not implemented");
        } catch (Exception e) {
            fail("getElement method threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetElementNullArray() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("getElement", int[].class, int.class);
            method.invoke(null, (Object) null, 0);
            fail("Should have thrown NullPointerException for null array");
        } catch (NoSuchMethodException e) {
            fail("getElement method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof NullPointerException) {
                assertTrue( 
                          cause.getMessage() != null && 
                          (cause.getMessage().toLowerCase().contains("null") || 
                           cause.getMessage().toLowerCase().contains("array")), "Exception message should mention null or array");
            } else {
                fail("Wrong exception type thrown. Expected NullPointerException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetElementIndexTooHigh() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("getElement", int[].class, int.class);
            int[] nums = {10, 20, 30};
            method.invoke(null, nums, 5);
            fail("Should have thrown IndexOutOfBoundsException for index >= length");
        } catch (NoSuchMethodException e) {
            fail("getElement method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof IndexOutOfBoundsException)) {
                fail("Wrong exception type thrown. Expected IndexOutOfBoundsException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testGetElementNegativeIndex() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("getElement", int[].class, int.class);
            int[] nums = {10, 20, 30};
            method.invoke(null, nums, -1);
            fail("Should have thrown IndexOutOfBoundsException for negative index");
        } catch (NoSuchMethodException e) {
            fail("getElement method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof IndexOutOfBoundsException)) {
                fail("Wrong exception type thrown. Expected IndexOutOfBoundsException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    // ==================== PROBLEM 4: Email Validator ====================
    
    @Test
    public void testValidateEmailValid() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateEmail", String.class);
            String result = (String) method.invoke(null, "user@example.com");
            assertEquals("user@example.com", result);
        } catch (NoSuchMethodException e) {
            fail("validateEmail method not implemented");
        } catch (Exception e) {
            fail("validateEmail method threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailWithSpaces() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateEmail", String.class);
            String result = (String) method.invoke(null, "  user@example.com  ");
            assertEquals("user@example.com", result.trim());
        } catch (NoSuchMethodException e) {
            fail("validateEmail method not implemented");
        } catch (Exception e) {
            fail("validateEmail method threw unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailNull() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateEmail", String.class);
            method.invoke(null, (Object) null);
            fail("Should have thrown IllegalArgumentException for null email");
        } catch (NoSuchMethodException e) {
            fail("validateEmail method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("empty") || 
                          cause.getMessage().toLowerCase().contains("null"), "Exception message should mention empty or null");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailEmpty() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateEmail", String.class);
            method.invoke(null, "");
            fail("Should have thrown IllegalArgumentException for empty email");
        } catch (NoSuchMethodException e) {
            fail("validateEmail method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("empty"), "Exception message should mention empty");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailNoAtSymbol() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateEmail", String.class);
            method.invoke(null, "notanemail");
            fail("Should have thrown IllegalArgumentException for missing @ symbol");
        } catch (NoSuchMethodException e) {
            fail("validateEmail method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("invalid") || 
                          cause.getMessage().toLowerCase().contains("format"), "Exception message should mention invalid or format");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
    
    @Test
    public void testValidateEmailNoDotAfterAt() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Method method = testClass.getDeclaredMethod("validateEmail", String.class);
            method.invoke(null, "missing@domain");
            fail("Should have thrown IllegalArgumentException for missing dot after @");
        } catch (NoSuchMethodException e) {
            fail("validateEmail method not implemented");
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                assertTrue( 
                          cause.getMessage().toLowerCase().contains("invalid") || 
                          cause.getMessage().toLowerCase().contains("format"), "Exception message should mention invalid or format");
            } else {
                fail("Wrong exception type thrown. Expected IllegalArgumentException, got: " + 
                     (cause != null ? cause.getClass().getName() : "null"));
            }
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
