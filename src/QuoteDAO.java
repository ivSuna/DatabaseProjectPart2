import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/QuoteDAO")
public class QuoteDAO {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public QuoteDAO(){}
	
	/** 
	 * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
    	//uses default connection to the database
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false&user=john&password=john1234");
            System.out.println(connect);
        }
    }
    
    public boolean database_login(String email, String password) throws SQLException{
    	try {
    		connect_func("root","pass1234");
    		String sql = "select * from Clients where email = ?";
    		preparedStatement = connect.prepareStatement(sql);
    		preparedStatement.setString(1, email);
    		ResultSet rs = preparedStatement.executeQuery();
    		return rs.next();
    	}
    	catch(SQLException e) {
    		System.out.println("failed login");
    		return false;
    	}
    }
    
    public void connect_func(String username, String password) throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://127.0.0.1:3306/testdb?"
  			          + "useSSL=false&user=" + username + "&password=" + password);
            System.out.println(connect);
        }
    }
    
    
    public List<Quote> listAllQuotes() throws SQLException {
    	System.out.println("Begin of listQuote");
        List<Quote> listQuote = new ArrayList<Quote>();        
        String sql = "SELECT * FROM Quotes";      
        connect_func();      
        statement = (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int quote_id = resultSet.getInt("quote_id");
            String firstName = resultSet.getString("firstName");
            String date = resultSet.getString("date");
            String num_trees = resultSet.getString("num_trees");
            int price = resultSet.getInt("price");
            String status = resultSet.getString("status");
            boolean completed = resultSet.getBoolean("completed");  
            
          
            Quote quotes = new Quote(quote_id, firstName, date, num_trees, price, status, completed);
            listQuote.add(quotes);
        }        
        System.out.println(listQuote.size());
        resultSet.close();
        disconnect();  
        System.out.println("End of listQuote");
        return listQuote;
        
    }
    
    
    public void insert(Quote quote) throws SQLException {
    	connect_func();         
		String sql = "insert into Quotes(quote_id, firstName, date, num_trees, price, status, completed) values (?, ?, ?, ?, ?, ?, ?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			preparedStatement.setInt(1, quote.getQuote_Id());
			preparedStatement.setString(2, quote.getFirst_Name());
			preparedStatement.setString(3, quote.get_Date());
			preparedStatement.setString(4, quote.getNum_Trees());
			preparedStatement.setInt(5, quote.get_Price());
			preparedStatement.setString(6, quote.get_Status());
			preparedStatement.setBoolean(7, quote.get_Completed());		
					
					
		preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    
    
    public boolean delete(int quote_id) throws SQLException {
        String sql = "DELETE FROM Quotes WHERE quote_id = ?";        
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, quote_id);
         
        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        return rowDeleted;     
    }
    
    
    public Quote getQuote(String fName) throws SQLException {
    	Quote quote = null;
        String sql = "SELECT * FROM Quotes WHERE quote_id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setString(2, fName);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	int quote_id = resultSet.getInt("quote_id");
        	String date = resultSet.getString("date");
            String num_trees = resultSet.getString("num_trees");
            int price = resultSet.getInt("price");
            String status = resultSet.getString("status");
            boolean completed = resultSet.getBoolean("completed");
            
            quote = new Quote(quote_id, fName, date, num_trees, price, status, completed);
        }
         
        resultSet.close();
        statement.close();
         
        return quote;
    }
    
    public void init() throws SQLException, FileNotFoundException, IOException{
    	connect_func();
        statement =  (Statement) connect.createStatement();
        
        String[] INITIAL = {"use testdb; ",
					        
					        "drop table if exists Quotes; ",
					        ("CREATE TABLE if not exists Quotes( " +
					        	"quote_id INT AUTO_INCREMENT, " +
					        	"firstName VARCHAR(10) NOT NULL, " +
					        	"date DATE NOT NULL, " +
					        	"price DECIMAL(13,2) DEFAULT 0, " + 
					        	"num_trees VARCHAR(10) NOT NULL, " + 
					        	"status VARCHAR(8) DEFAULT 'pending', " + 
					        	"completed BOOLEAN DEFAULT false, " + 
					        	"PRIMARY KEY (quote_id)" + "); "),					        		
					        
        					};
        
    
        
        String[] TUPLES_QUOTES = {("insert into Quotes(quote_id,firstName, date, num_trees, price, status, completed)"+
    			"values (quote_id, 'Don', '2023-10-01', '1', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-02', '2', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-03', '3', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-04', '1', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-05', '2', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-06', '3', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-07', '1', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-08', '4', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-09', '5', '0', 'pending', false),"+
        				"(quote_id, 'Hussein','2023-10-10', '2', '0', 'pending', false);")        		
        					};
        
        //for loop to put these in database
        for (int i = 0; i < INITIAL.length; i++)
        	statement.execute(INITIAL[i]);
   
        
        for (int i = 0; i < TUPLES_QUOTES.length; i++)	
        	statement.execute(TUPLES_QUOTES[i]);
        
        
        disconnect();
    }
    
    
    
    
    
    
    
    protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
    
    
    
    
    
    
    
    
    
    
}
