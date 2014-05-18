package com.yicheng.fft.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class DataService {
    
    protected Connection connection = null;
    
    public DataService() {
        
        Properties props = getConnectionProps();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/soybeandb","root", "waterlover1984");
            connection = DriverManager.getConnection(props.getProperty("dburl"), props.getProperty("dbuser"), props.getProperty("dbpassword"));
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
    
    private Properties getConnectionProps() {
        Properties props = new Properties();
        InputStream input = null;
        try {
            input = getClass().getClassLoader().getResourceAsStream("dbconnection.properties");
            props.load(input);
     
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }
    
    public String getFamilySpendingItems() {
        SimpleDateFormat dateFmt = new SimpleDateFormat("MM/dd/yyyy");
        String query = "select * from `family_spending_view` order by `id`";
        Statement stmt = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                JsonObjectBuilder job = Json.createObjectBuilder()
                        .add("id", rs.getInt("id"))
                        .add("date", dateFmt.format(rs.getTimestamp("date")))
                        .add("amount", rs.getDouble("amount"))
                        .add("description", rs.getString("description"))
                        .add("category", rs.getString("category"))
                        .add("paymentMethod", rs.getString("payment_method"))
                        .add("name", rs.getString("last_name")+", "+rs.getString("first_name"));
                jab.add(job);
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return jab.build().toString();
    }
    
    public int addFamilySpendingItem(String date, double amount, String desc, int catId, int payId, int peopleId) {
        String query = "insert into `family_spending` (`date`, `amount`, `description`, `category_id`, `payment_type_id`, `people_id`) values (?, ?, ?, ?, ?, ?)";
        SimpleDateFormat newSpendingDateFmt = new SimpleDateFormat("MM/dd/yyyy");
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = connection.prepareStatement(query);
            try {
                stmt.setTimestamp(1, new Timestamp(newSpendingDateFmt.parse(date).getTime()));
            } catch (ParseException e) {
                System.out.println("The date format is incorrect "+ date);
                e.printStackTrace();
                return 0;
            }
            stmt.setDouble(2, amount);
            stmt.setString(3, desc);
            stmt.setInt(4, catId);
            stmt.setInt(5, payId);
            stmt.setInt(6, peopleId);
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return 0;
        }
        return n;
    }
    
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Close Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
    
    public static void main(String[] argv) {
        DataService ds = new DataService();
        System.out.println(ds.getFamilySpendingItems());
        ds.close();
        return;
    }
}
