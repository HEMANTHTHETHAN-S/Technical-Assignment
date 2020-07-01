package com.test;


//import java.beans.Statement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("testController")
public class testController {
    @GET
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<testModel> getDataInJson() throws ClassNotFoundException, SQLException{
        ArrayList<testModel> tmn = new ArrayList<>();
        Connection con = null;
        String username = "test";
        String password = "Pulsar@100";
        String query = "select * from test";
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/firstDatabase",username,password);
        Statement st =  (Statement) con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            testModel tm = new testModel();
            tm.setId(rs.getInt("id"));
            tm.setName(rs.getString("name"));
            tm.setEmail(rs.getString("email"));
            tmn.add(tm);
        }
        return tmn;
    }
}
