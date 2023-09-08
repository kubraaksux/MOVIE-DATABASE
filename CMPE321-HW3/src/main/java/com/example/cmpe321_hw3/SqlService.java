package com.example.cmpe321_hw3;

import com.example.cmpe321_hw3.data.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.sql.*;
@Service
public class SqlService implements UserDetailsService {
    Connection con;



    public SqlService() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/proj1", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDatabaseManagers() throws SQLException {
        String result = "";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from database_managers");
        while (rs.next())
            result += rs.getString(1) + " " + rs.getString(2) + "\n";
        return result;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("" +
                    "select username, password, 'dbm' as role from database_managers where username = ? " +
                    "union " +
                    "select username, password, 'director' as role from directors where username = ? " +
                    "union " +
                    "select username, password, 'audience' as role from audience where username = ? ");
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.setString(3, username);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Not found");
                throw new UsernameNotFoundException("Username not found");
            }
            System.out.println("Found: " + rs.getString(2));
            return new MyUserDetails(
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("role"));

        } catch (SQLException e) {
            System.out.println(e);
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
