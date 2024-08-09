public class EmployeeDriver {
    public static void main(String[] args) {
        // Creating instances using different constructors
        // 1. Using no-argument constructor
        Employee emp1 = new Employee();

        // 2. Using overloaded constructor with composition
        Date hireDate = new Date(2024, 5, 20);
        Employee emp2 = new Employee(new Person("John", "Doe"), hireDate, 1001, "Engineering");

        // 3. Using overloaded constructor with inheritance
        Employee emp3 = new Employee("Jane", "Smith");

        // 4. Using copy constructor
        Employee emp4 = new Employee(emp2);

        // Printing information using toString method
        System.out.println("Employee 1:\n" + emp1.toString());
        System.out.println("\nEmployee 2:\n" + emp2.toString());
        System.out.println("\nEmployee 3:\n" + emp3.toString());
        System.out.println("\nEmployee 4 (Copy of Employee 2):\n" + emp4.toString());

        //  NullPointerException in the lien below
        // System.out.println(emp1.getHireDate());
    }
}
