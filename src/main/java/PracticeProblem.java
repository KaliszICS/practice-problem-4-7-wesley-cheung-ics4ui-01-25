public class PracticeProblem {

	public static void main(String args[]) {
		System.out.println(validateAge(-1));
	}
	public static boolean validateAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be negative");
		} else if (age > 150) {
			throw new IllegalArgumentException("Age must be realistic");
		}
		return true;
	}
	public static double withdraw(double amount, double balance) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative");
		} else if (balance-amount < 0) {
			throw new IllegalStateException("Balance is too low to withdraw funds");
		}
		return balance-amount;
	}
	public static int getElement(int[] array, int index) {
		if (array == null) {
			throw new NullPointerException("Array cannot be null");
		} else if (index < 0 || index>(array.length-1)) {
			throw new IndexOutOfBoundsException("Index is out of the array bounds");
		}
		return array[index];
	}
	public static String validateEmail(String email) {
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Email cannot be empty");
		} else if (!(email.contains("@"))) {
			throw new IllegalArgumentException("Invalid email format");
		}
		boolean check = false;
		for (int i = 0;i<email.length();i++) {
			if (email.charAt(i)=='@') {
				check = true;
			}
			if (check == true && email.charAt(i)=='.') {
				return email.trim();
			}
		}
		throw new IllegalArgumentException("Invalid email format");
	}

	

}
