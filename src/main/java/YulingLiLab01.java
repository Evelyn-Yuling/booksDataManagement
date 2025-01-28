/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 * This class connects to a MySQL database, generates a random year,
 * filter records from the "recipients" table matching that year,
 * and displays the results in a formatted table.
 * If no records are found, it informs the user accordingly.
 *
 * @author Yuling Li
 */
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class YulingLiLab01 {

    // launch the application
    /**
     * The main method of the program. It establishes a connection to the
     * database, generates a random year, executes a query based on that year,
     * and prints the retrieved data in a structured format.
     *
     * @param args Command-line arguments (not used in this program)
     * @throws SQLException If a database access error occurs
     */
    public static void main(String[] args) throws SQLException {

        //create instance props to store the information from database.properties    
        Properties props = new Properties();
        // try-with-resources
        //read the database.properties file
        try (InputStream in = Files.newInputStream(Paths.get("src/main/java/database.properties"));) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }// catch()

        // connect to the database, use the data stored in the instance props
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        // generate the random year from 1987 to 2021
        SecureRandom random = new SecureRandom();
        int randomYear = 1987 + random.nextInt(2021 - 1987 + 1);
        System.out.println("Random year generated: " + randomYear);

        // Define the SQL query with a placeholder (?) for the year parameter
        String query = "SELECT AwardID, Name, Year, City, Category FROM recipients WHERE Year = ?";
        // establish connection to database
        try (
                Connection connection = DriverManager.getConnection(url, username, password);// create Statement for querying database
                 PreparedStatement preparedStatement = connection.prepareStatement(query)// query database 
                ) {
            // Set the parameter (randomYear) in the SQL query
            preparedStatement.setInt(1, randomYear);
            // process query results
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Get column details about the query result
                ResultSetMetaData metaData = resultSet.getMetaData();
                int numberOfColumns = metaData.getColumnCount();

                // Print table header (column names, types, and Java class types)
                System.out.println("Recipients Table - Column Attributes:");
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-15s%-15s%-20s%n",
                            metaData.getColumnName(i),// Column name
                            metaData.getColumnTypeName(i),// SQL data type
                            metaData.getColumnClassName(i));// Corresponding Java type
                }
                System.out.println();//blank line

                // Process the query results
                boolean hasResults = false;
                while (resultSet.next()) {
                    hasResults = true;
                    for (int i = 1; i <= numberOfColumns; i++) {
                        System.out.printf("%-20s", resultSet.getObject(i));
                    }
                    System.out.println();
                }
                // If no results were found, print a message
                if (!hasResults) {
                    System.out.println("No results found for year: " + randomYear);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
