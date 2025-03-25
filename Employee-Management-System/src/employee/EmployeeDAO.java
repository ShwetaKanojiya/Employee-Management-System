package employee;

import java.sql.*;

public class EmployeeDAO {
    private Connection c;
    private PreparedStatement insertStmt, updateStmt, deleteStmt, selectStmt;

    // Constructor to establish the database connection
    public EmployeeDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "*******");
            
            // Prepared Statements for CRUD operations
            insertStmt = c.prepareStatement("INSERT INTO employee (name, age, department, salary) VALUES (?, ?, ?, ?)");
            updateStmt = c.prepareStatement("UPDATE employee SET salary = ? WHERE id = ?");
            deleteStmt = c.prepareStatement("DELETE FROM employee WHERE id = ?");
            selectStmt = c.prepareStatement("SELECT * FROM employee");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create (Insert Employee)
    public void addEmployee(String name, int age, String department, double salary) {
        try {
            insertStmt.setString(1, name);
            insertStmt.setInt(2, age);
            insertStmt.setString(3, department);
            insertStmt.setDouble(4, salary);
            insertStmt.executeUpdate();
            System.out.println("Employee added: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read (Fetch All Employees)
    public void getEmployees() {
        try {
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") + ", Department: " + rs.getString("department") + 
                        ", Salary: " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update (Modify Employee Salary)
    public void updateEmployeeSalary(int id, double newSalary) {
        try {
            updateStmt.setDouble(1, newSalary);
            updateStmt.setInt(2, id);
            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee salary updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete (Remove Employee)
    public void deleteEmployee(int id) {
        try {
            deleteStmt.setInt(1, id);
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing CRUD operations
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        // Add Employees
        dao.addEmployee("Alice Smith", 28, "HR", 45000);
        dao.addEmployee("Bob Johnson", 35, "IT", 60000);
        dao.addEmployee("Charlie Davis", 40, "Finance", 70000);
        dao.addEmployee("David Wilson", 32, "Marketing", 48000);
        dao.addEmployee("Emily White", 29, "Operations", 55000);
        dao.addEmployee("Frank Martin", 38, "HR", 52000);
        dao.addEmployee("Grace Hall", 26, "IT", 60000);
        dao.addEmployee("Henry Young", 45, "Finance", 80000);
        dao.addEmployee("Irene Scott", 30, "Marketing", 47000);
        dao.addEmployee("Jack Turner", 34, "Operations", 53000);
        dao.addEmployee("Kelly Parker", 27, "HR", 49000);
        dao.addEmployee("Leo Baker", 33, "IT", 62000);

        // Fetch and display all employees
        dao.getEmployees();

        // Update an employee's salary
        dao.updateEmployeeSalary(1, 50000);
        
        // Delete an employee
        dao.deleteEmployee(2);

        // Fetch and display updated employees list
        dao.getEmployees();
    }
}
