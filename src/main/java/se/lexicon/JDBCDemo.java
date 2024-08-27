package se.lexicon;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "1234negar");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                System.out.println("Student id = " + studentId);
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(studentId + ", " + firstName + ", " + lastName);
            }

            //executeQuery method is used for executing SELECT (read) queries
            //executeUpdate method is used for executing INSERT, DELETE, UPDATE queries

        } catch (SQLException e) {
            System.out.println("SQL Exception: ");
            e.printStackTrace();
        }

    }
}
