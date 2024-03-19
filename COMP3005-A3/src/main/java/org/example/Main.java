package org.example;

import java.sql.*;

public class Main {
    //These variables are used for the connection
    String url = "jdbc:postgresql://localhost:5432/A3-COMP3005";
    String user = "postgres";
    String password = "postgres";

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Printing all Students");
//        m.getStudents();
        //Adding a student
//        m.addStudent("Bob", "Miles", "Bob.miles@gmail.com", "2024-03-15");
//        m.getStudents();
        //Updating email
//        m.updateStudent(4, "joe@gmail.com");
//        m.getStudents();
        //Deleting Student
//        m.deleteStudent(4);
//        m.getStudents();

    }

    //Prints out all of the students in the database
    public void getStudents() {
        try {
            Class.forName("org.postgresql.Driver");
            //Connects to the database
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeQuery("SELECT * FROM students");
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt("student_id") + " "
                            + rs.getString("first_name") + " "
                            + rs.getString("last_name") + " "
                            + rs.getString("email") + " "
                            + rs.getDate("enrollment_date"));
                }
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
        }
    }
    //Adds a student to the database by receiving the first name, last name, email and enrollment date from the user
    public void addStudent(String f_name, String l_name, String email, String date) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)");
                pstmt.setString(1, f_name);
                pstmt.setString(2, l_name);
                pstmt.setString(3, email);
                pstmt.setDate(4, java.sql.Date.valueOf(date));
                pstmt.executeUpdate();
                System.out.println("Student added successfully.");

            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
        }
    }
    //Updates the student by finding the student in the db by the id given and replace the email with the new email given
    public void updateStudent(int ID, String email) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                PreparedStatement pstmt = connection.prepareStatement("UPDATE students SET email = ? WHERE student_id = ?");
                pstmt.setString(1, email);
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();

            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
        }
    }
    //Deletes a student from the database by finding the user id given
    public void deleteStudent(int ID) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                PreparedStatement pstmt = connection.prepareStatement("DELETE FROM students WHERE student_id = ?");
                pstmt.setInt(1, ID);
                pstmt.executeUpdate();
                pstmt.executeUpdate();

            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
        }
    }
}