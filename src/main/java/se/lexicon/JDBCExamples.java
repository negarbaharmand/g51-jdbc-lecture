package se.lexicon;

import se.lexicon.db.MySQLConnection;
import se.lexicon.model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCExamples {

    public static void main(String[] args) {

        ex2();
    }

    //get all students data (finAll)
    public static void ex1() {

        try {
            //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root", "1234negar");
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from student");
            List<Student> studentList = new ArrayList<>();

            while (resultSet.next()) {
                int studentId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);
                String email = resultSet.getString(5);
                LocalDate createDate = resultSet.getDate(6).toLocalDate();

                Student student = new Student(studentId, firstName, lastName, age, email, createDate);
                studentList.add(student);
            }

            studentList.forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println("SQL Exception: ");
            e.printStackTrace();
        }
    }


    //get student by id (findById)
    public static void ex2() {
        // step 1: Create a database connection
        try (
                Connection connection = MySQLConnection.getConnection();
                // step 2: Create a prepared statement
                PreparedStatement preparedStatement = connection.prepareStatement("select * from student where student_id = ?");
        ) {

            int inputId = 1;
            preparedStatement.setInt(1, inputId);

            try (
                    // step 3: Execute query
                    ResultSet resultSet = preparedStatement.executeQuery();

            ) {
                // step 4: Get data from result set and store it in Java object
                Student student = null;
                if (resultSet.next()) {
                    int studentId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    int age = resultSet.getInt(4);
                    String email = resultSet.getString(5);
                    LocalDate createDate = resultSet.getDate(6).toLocalDate();
                    student = new Student(studentId, firstName, lastName, age, email, createDate);
                }
                System.out.println(student);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        // step 5: Close all the resources

    }


}
