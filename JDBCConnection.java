package jdbcconnection;
import java.sql.*;
public class JDBCConnection {

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/NORTHWIND";
   static final String USER = "root";
   static final String PASS = "Pulsar@100";
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      String sql;
      sql = "create table region(RegionId INT(11),RegionDescription VARCHAR(50));";
      stmt.executeUpdate(sql);
      sql = "create table territores(TerritoryID VARCHAR(20),TerritoryDescrition VARCHAR(50),RegionID INT(11));";
      stmt.executeUpdate(sql);
      sql = "create table EmployeeTerritories(EmployeeID INT(11),TerritoryID VARCHAR(20));";
      stmt.executeUpdate(sql);
      sql = "create table Employees(EmployeeID INT(11),LastName VARCHAR(20),FirstName VARCHAR(10),Title VARCHAR(30),TitleOfCourtesy VARCHAR(25),BirthDate DATETIME,HireDate DATETIME,Address VARCHAR(60),City VARCHAR(15),Region VARCHAR(15),PostalCode VARCHAR(10),Country VARCHAR(15),HomePhone VARCHAR(24),Extension VARCHAR(4),Notes MEDIUMTEXT,ReportsTo INT(11),PhotoPath VARCHAR(255),Salary FLOAT);";
      stmt.executeUpdate(sql);
      sql = "create table Shippers(Shipper INT(11),CompanyName VARCHAR(40),Phone VARCHAR(24));";
      stmt.executeUpdate(sql);
      sql = "create table Orders(OrderId INT(11),CustomerID VARCHAR(5),EmployeeID INT(11),OrderDate DATETIME,RequiredDate DATETIME,ShippedDate DATETIME,ShipVia INT(11),Freight DECIMAL(10,4),ShipName VARCHAR(40),ShipAddress VARCHAR(60),ShipCity VARCHAR(15),ShipRegion VARCHAR(15),ShipPostalCode VARCHAR(10),ShipCountry VARCHAR(15));";
      stmt.executeUpdate(sql);
      sql = "create table Customers(CustomerID VARCHAR(5),CompanyName VARCHAR(40),ContactName VARCHAR(30),ContactTitle VARCHAR(30),Address VARCHAR(60),City VARCHAR(15),Region VARCHAR(15),PostalCode VARCHAR(10),Country VARCHAR(15),Phone VARCHAR(24),Fax VARCHAR(24));";
      stmt.executeUpdate(sql);
      sql = "create table OrderDetails(OrderID INT(11),ProductID INT(11),UnitPrice DECIMAL(10,4),Quantity SMALLINT(2),Discount DOUBLE(8,0));";
      stmt.executeUpdate(sql);
      sql = "create table Products(ProductID INT(11),ProductName VARCHAR(40),SupplierID INT(11),CategoryID INT(11),QuantityPerUnit VARCHAR(20),UnitPrice DECIMAL(10,4),UnitsInStock SMALLINT(2),UnitOnOrder SMALLINT(2),ReorderLevel SMALLINT(2),Discontinued BIT(1));";
      stmt.executeUpdate(sql);
      sql = "create table CustomerDemographics(CustomerTypeID VARCHAR(10),CustomerDesc MEDIUMTEXT);";
      stmt.executeUpdate(sql);
      sql = "create table CustomerCustomerDemo(CustomerID VARCHAR(5),CustomerTypeID VARCHAR(10));";
      stmt.executeUpdate(sql);
      sql = "create table Suppliers(SupplierID INT(11),CompanyName VARCHAR(40),ContactName VARCHAR(30),ContactTitle VARCHAR(30),Address VARCHAR(60),City VARCHAR(15),Region VARCHAR(15),PostalCode VARCHAR(10),Country VARCHAR(15),Phone VARCHAR(24),Fax VARCHAR(24),HomePage MEDIUMTEXT);";
      stmt.executeUpdate(sql);
      sql = "create table Categories(CategoryID INT(11),CategoryName VARCHAR(15),Description MEDIUMTEXT);";
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){     
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
    }
}
