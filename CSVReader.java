package csvreader;
import java.sql.*;
import java.io.*;
import com.csvreader.CsvReader;
public class CSVReader {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/NORTHWIND";
    static final String USER = "root";
    static final String PASS = "Pulsar@100";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql;
            CsvReader products;
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\regions.csv");
            products.readHeaders();
            while (products.readRecord()){
                String RegionID = products.get("RegionID");
                String RegionDescription = products.get("RegionDescription");
                System.out.println(RegionID + ":" + RegionDescription);
                sql = "INSERT INTO region (RegionID,RegionDescription) VALUES ('"+RegionID+"','"+RegionDescription+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\categories.csv");
            products.readHeaders();
            while (products.readRecord()){
                String CategoryID = products.get("CategoryID");
                String CategoryName = products.get("CategoryName");
                String Description = products.get("Description");
                System.out.println(CategoryID + ":" + CategoryName + ":"+Description);
                sql = "INSERT INTO Categories (CategoryID,CategoryName,Description) VALUES ('"+CategoryID+"','"+CategoryName+"','"+Description+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
            
            
           products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\customers.csv");
            products.readHeaders();
            while (products.readRecord()){
                String CustomerID = products.get("CustomerID");
                String CompanyName = products.get("CompanyName");           
                String ContactName = products.get("ContactName");
                String ContactTitle = products.get("ContactTitle");
                String Address = products.get("Address");
                String City = products.get("City");
                String Region = products.get("Region");
                String PostalCode = products.get("PostalCode");
                String Country = products.get("Country");
                String Phone = products.get("Phone");
                String Fax = products.get("Fax");
                sql = "INSERT INTO Customers (CustomerID,CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax) "
                        + "VALUES ('"+CustomerID+"',\""+CompanyName+"\",'"+ContactName+"','"+ContactTitle+"',\""+Address+"\",'"+City+"','"+Region+"','"+PostalCode+"','"+Country+"','"+Phone+"','"+Fax+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
            
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\employees.csv");
            products.readHeaders();
            while (products.readRecord()){
                String EmployeeID = products.get("EmployeeID");
                String LastName = products.get("LastName");
                String FirstName = products.get("FirstName");
                String Title = products.get("Title");
                String TitleOfCourtesy = products.get("TitleOfCourtesy");
                String BirthDate = products.get("BirthDate");
                String HireDate = products.get("HireDate");
                String Address = products.get("Address");
                String City = products.get("City");
                String Region = products.get("Region");
                String PostalCode = products.get("PostalCode");
                String Country = products.get("Country");
                String HomePhone = products.get("HomePhone");
                String Extension = products.get("Extension");
                String Notes = products.get("Notes");
                String ReportsTo =products.get("ReportsTo");
                String PhotoPath = products.get("PhotoPath");
                String Salary = products.get("Salary");
                stmt = conn.createStatement();
                sql = "INSERT INTO Employees (EmployeeID,LastName,FirstName,Title,TitleOfCourtesy,BirthDate,HireDate,Address,City,Region,PostalCode,Country,HomePhone,Extension,Notes,ReportsTo,PhotoPath,Salary) "
                        + "VALUES ('"+EmployeeID+"','"+LastName+"','"+FirstName+"','"+Title+"','"+TitleOfCourtesy+"','"+BirthDate+"','"+HireDate+"','"+Address+"','"+City+"','"+Region+"','"+PostalCode+"','"+Country+"','"+HomePhone+"','"+Extension+"','"+Notes+"',"+ReportsTo+",'"+PhotoPath+"','"+Salary+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
            
           products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\employee-territories.csv");
            products.readHeaders();
            while (products.readRecord()){
                String EmployeeID = products.get("EmployeeID");
                String TerritoryID = products.get("TerritoryID");
                sql = "INSERT INTO EmployeeTerritories (EmployeeID,TerritoryID) "
                        + "VALUES ('"+EmployeeID+"','"+TerritoryID+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\order-details.csv");
            products.readHeaders();
            while (products.readRecord()){
                String OrderID = products.get("OrderID");
                String ProductID = products.get("ProductID");
                String UnitPrice = products.get("UnitPrice");
                String Quantity = products.get("Quantity");
                String Discount = products.get("Discount");              
                sql = "INSERT INTO OrderDetails (OrderID,ProductID,UnitPrice,Quantity,Discount) "
                        + "VALUES ('"+OrderID+"','"+ProductID+"','"+UnitPrice+"','"+Quantity+"','"+Discount+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
            
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\orders.csv");
            products.readHeaders();
            while (products.readRecord()){
                String OrderID = products.get("OrderID");
                String CustomerID = products.get("CustomerID");
                String EmployeeID = products.get("EmployeeID");
                String OrderDate = products.get("OrderDate");
                String RequiredDate = products.get("RequiredDate");
                String ShippedDate = products.get("ShippedDate");
                String ShipVia = products.get("ShipVia");
                String Freight = products.get("Freight");
                String ShipName = products.get("ShipName");
                String ShipAddress = products.get("ShipAddress");
                String ShipCity = products.get("ShipCity");
                String ShipRegion = products.get("ShipRegion");
                String ShipPostalCode = products.get("ShipPostalCode");
                String ShipCountry = products.get("ShipCountry");
                stmt = conn.createStatement();
                if(ShippedDate.equals("NULL")){
                    sql = "INSERT INTO Orders (OrderID,CustomerID,EmployeeID,OrderDate,RequiredDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry) "
                        + "VALUES ('"+OrderID+"','"+CustomerID+"','"+EmployeeID+"','"+OrderDate+"','"+RequiredDate+"',"+ShippedDate+",'"+ShipVia+"','"+Freight+"',\""+ShipName+"\",\""+ShipAddress+"\",'"+ShipCity+"','"+ShipRegion+"','"+ShipPostalCode+"','"+ShipCountry+"');";
                }
                else{
                    sql = "INSERT INTO Orders (OrderID,CustomerID,EmployeeID,OrderDate,RequiredDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress,ShipCity,ShipRegion,ShipPostalCode,ShipCountry) "
                        + "VALUES ('"+OrderID+"','"+CustomerID+"','"+EmployeeID+"','"+OrderDate+"','"+RequiredDate+"','"+ShippedDate+"','"+ShipVia+"','"+Freight+"',\""+ShipName+"\",\""+ShipAddress+"\",'"+ShipCity+"','"+ShipRegion+"','"+ShipPostalCode+"','"+ShipCountry+"');";
                }
                    
                stmt.executeUpdate(sql);
                
            }
            products.close();
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\products.csv");
            products.readHeaders();
            while (products.readRecord()){
                String ProductID = products.get("ProductID");
                String ProductName = products.get("ProductName");
                String SupplierID = products.get("SupplierID");
                String CategoryID = products.get("CategoryID");
                String QuantityPerUnit = products.get("QuantityPerUnit");
                String UnitPrice = products.get("UnitPrice");
                String UnitsInStock = products.get("UnitsInStock");
                String UnitsOnOrder = products.get("UnitsOnOrder");
                String ReorderLevel = products.get("ReorderLevel");
                String Discontinued = products.get("Discontinued");
                stmt = conn.createStatement();
                sql = "INSERT INTO Products (ProductID,ProductName,SupplierID,CategoryID,QuantityPerUnit,UnitPrice,UnitsInStock,UnitOnOrder,ReorderLevel,Discontinued) "
                        + "VALUES (\""+ProductID+"\",\""+ProductName+"\",\""+SupplierID+"\",\""+CategoryID+"\",\""+QuantityPerUnit+"\",\""+UnitPrice+"\",\""+UnitsInStock+"\",\""+UnitsOnOrder+"\",\""+ReorderLevel+"\",\""+Discontinued+"\");";
                  stmt.executeUpdate(sql);
            }
            products.close();
            
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\shippers.csv");
            products.readHeaders();
            while (products.readRecord()){
                String Shipper = products.get("ShipperID");
                String CompanyName = products.get("CompanyName");
                String Phone = products.get("Phone");           
                stmt = conn.createStatement();
                sql ="insert into Shippers(Shipper,CompanyName,Phone) values(\""+Shipper+"\",\""+CompanyName+"\",\""+Phone+"\");";
                stmt.executeUpdate(sql);
            }
            products.close();
            
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\suppliers.csv");
            products.readHeaders();
            while (products.readRecord()){
                String SupplierID = products.get("SupplierID");
                String CompanyName = products.get("CompanyName");
                String ContactName = products.get("ContactName");
                String ContactTitle = products.get("ContactTitle");
                String Address = products.get("Address");
                String City = products.get("City");
                String Region = products.get("Region");
                String PostalCode = products.get("PostalCode");
                String Country = products.get("Country");
                String Phone = products.get("Phone");
                String Fax = products.get("Fax");
                String HomePage = products.get("HomePage");
                stmt = conn.createStatement();
                sql = "INSERT INTO Suppliers (SupplierID,CompanyName,ContactName,ContactTitle,Address,City,Region,PostalCode,Country,Phone,Fax,HomePage)"
                        + "VALUES (\""+SupplierID+"\",\""+CompanyName+"\",\""+ContactName+"\",\""+ContactTitle+"\",\""+Address+"\",\""+City+"\",\""+Region+"\",\""+PostalCode+"\",\""+Country+"\",\""+Phone+"\",\""+Fax+"\",\""+HomePage+"\");";
                stmt.executeUpdate(sql);
            }
            products.close();
            
            
            products = new CsvReader("C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\NorthWind\\territories.csv");
            products.readHeaders();
            while (products.readRecord()){
                String TerritoryID = products.get("TerritoryID");
                String TerritoryDescription = products.get("TerritoryDescription");
                String RegionID = products.get("RegionID");
                stmt = conn.createStatement();
                sql = "INSERT INTO territores (TerritoryID,TerritoryDescrition,RegionID)"
                        + "VALUES ('"+TerritoryID+"','"+TerritoryDescription+"','"+RegionID+"');";
                stmt.executeUpdate(sql);
            }
            products.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(SQLException se){
            se.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(stmt!=null)
                conn.close();
            }
            catch(SQLException se){
            }
            try{
                if(conn!=null)
                   conn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }
            }
        
        
    }
