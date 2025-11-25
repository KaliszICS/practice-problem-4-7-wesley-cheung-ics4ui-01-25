[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=21820739)
# Instructions  

  ## Questions
  1. Write a method _validateAge(int age)_ that:
      
      Returns _true_ if the age is valid</br>
      Throws an _IllegalArgumentException_ if age is negative with message "Age cannot be negative"</br>
      Throws an _IllegalArgumentException_ if age is greater than 150 with message "Age must be realistic"</br>

  2. Write a method _withdraw(double amount, double balance)_ that:

      Returns the new balance after withdrawal</br>
      Throws an _IllegalArgumentException_ if the amount is negative or zero</br>
      Throws an _IllegalStateException_ if the withdrawal would result in a negative balance</br>

  3. Write a method getElement(int[] array, int index) that:

      Returns the element at the given index</br>
      Throws a _NullPointerException_ if the array is null with message "Array cannot be null"</br>
      Throws an _IndexOutOfBoundsException_ if the index is negative or >= array length with an appropriate message</br>

  4. Write a method validateEmail(String email) that:

      Returns the trimmed email if valid</br>
      Throws an IllegalArgumentException if email is null or empty with message "Email cannot be empty"</br>
      Throws an IllegalArgumentException if email doesn't contain an '@' symbol with message "Invalid email format"</br>
      Throws an IllegalArgumentException if email doesn't contain a '.' after the '@' with message "Invalid email format"</br>
