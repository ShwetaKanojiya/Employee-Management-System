<h1 align="center">Employee Management System</h1>

<p align="center">
  <b>A Java-based desktop application for managing employee records</b>
</p>

## 📌 About the Project
<p>
  The Employee Management System is a <b>Java-based desktop application</b> that enables efficient employee record management. <br>
  It utilizes <b>Java Swing</b> and <b>AWT (Abstract Window Toolkit)</b> for creating the graphical user interface (GUI). <br>
  The system is backed by a <b>MySQL database</b> for secure and structured data storage.
</p>

## 🛠️ Technologies Used
<ul>
  <li><b>Java (Swing & AWT)</b> - Used for developing the GUI</li>
  <li><b>MySQL</b> - Used for storing employee data</li>
  <li><b>JDBC</b> - Used for database connectivity</li>
</ul>

<h2>MySQL Database Setup</h2>

<h3>1. Create Database</h3>
<pre>
CREATE DATABASE employee_management;
USE employee_management;
</pre>

<h3>2. Create Employee Table</h3>
<pre>
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    fname VARCHAR(100),
    dob DATE,
    salary DECIMAL(10,2),
    address VARCHAR(255),
    phone VARCHAR(15),
    email VARCHAR(100),
    education VARCHAR(50),
    designation VARCHAR(50),
    aadhar VARCHAR(12) UNIQUE,
    empId VARCHAR(10) UNIQUE
);
</pre>

<h3>3. Insert Sample Data</h3>
<pre>
INSERT INTO employee (name, fname, dob, salary, address, phone, email, education, designation, aadhar, empId) 
VALUES 
('John Doe', 'Robert Doe', '1990-05-15', '60000', '1234 Elm Street, NY', '9876543210', 'johndoe@example.com', 'BTech', 'Software Engineer', '123456789012', '458912'),
('Alice Smith', 'David Smith', '1985-08-25', '75000', '5678 Oak Avenue, CA', '9876543211', 'alicesmith@example.com', 'MTech', 'Project Manager', '123456789013', '458913'),
('Bob Johnson', 'Michael Johnson', '1993-12-10', '50000', '9101 Pine Road, TX', '9876543212', 'bobjohnson@example.com', 'BSc', 'HR Manager', '123456789014', '458914');
</pre>

<h2>How to Run</h2>
<ol>
    <li>Ensure MySQL is running and the database is set up.</li>
    <li>Compile and run the Java application.</li>
    <li>Use the GUI to add, update, delete, and search employees.</li>
</ol>

## ⚡ Features
<ul>
  <li>Add, update, and delete employee records</li>
  <li>View employee details in a structured format</li>
  <li>Search for employees by name or ID</li>
  <li>Secure login authentication</li>
  <li>Interactive and user-friendly UI</li>
</ul>
