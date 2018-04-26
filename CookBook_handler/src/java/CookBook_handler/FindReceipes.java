/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CookBook_handler;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.HandlerChain;
/**
 *
 * @author CASH
 */
@WebService(serviceName = "FindReceipes")
@HandlerChain(file = "FindReceipes_handler.xml")
public class FindReceipes {
    
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "FindReceipes_MainIngredient")
    public ArrayList<ReceipeName> FindReceipes_MainIngredient(@WebParam(name = "value") String value) 
    {   
        String DB_DRIVER = "org.postgresql.Driver";
        String DB_CONNECTION = "jdbc:postgresql://localhost:5432/cookbook_DB";
        String DB_USER = "CASH";
        String DB_PASSWORD = "1234";
    
        Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {
                    System.err.println("5");
			e.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, 
                             DB_USER,
                             DB_PASSWORD);
                        

		} catch (SQLException e) {
                    System.err.println("6");
                    e.printStackTrace();
		}
        
        
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT receipe_id, title from receipe_table where "+ value +" = 1 ORDER BY rating desc";
        ArrayList<ReceipeName> list = new ArrayList<ReceipeName>();
        try{
        
        preparedStatement = dbConnection.prepareStatement(selectSQL);
        ResultSet rs = preparedStatement.executeQuery();
        int count_display = 10;
        while (rs.next()) 
        {
        if (count_display == 0)
            break;
        ReceipeName rn = new ReceipeName();
        rn.setId(rs.getInt("receipe_id"));
        rn.setTitle(rs.getString("title"));
        list.add(rn);
        count_display--;
        
        } 

    }   catch (SQLException ex) {   
            Logger.getLogger(FindReceipes.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    return list;
    }
    
    @WebMethod(operationName = "Receipes_HealthQuotient")
    public HealthQuotient Receipes_HealthQuotient(@WebParam(name = "value") String value) 
    {   
        String DB_DRIVER = "org.postgresql.Driver";
        String DB_CONNECTION = "jdbc:postgresql://localhost:5432/cookbook_DB";
        String DB_USER = "CASH";
        String DB_PASSWORD = "1234";
        HealthQuotient hq = new HealthQuotient();
        Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {
                    System.err.println("7");
			e.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, 
                             DB_USER,
                             DB_PASSWORD);
                        

		} catch (SQLException e) {
                    System.err.println("8");
                    e.printStackTrace();
		}
        
        
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT receipe_id, calories, protein, fat, sodium FROM receipe_table WHERE receipe_id = ?";
        
        try{
        preparedStatement = dbConnection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, Integer.parseInt(value));
        
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        hq.setId(rs.getInt("receipe_id"));
        hq.setCalories(rs.getFloat("calories"));
        hq.setFat(rs.getFloat("fat"));
        hq.setProtein(rs.getFloat("protein"));
        hq.setSodium(rs.getFloat("sodium"));
        
        }   catch (SQLException ex) {   
            Logger.getLogger(FindReceipes.class.getName()).log(Level.SEVERE, null, ex);
        }   
    return hq;
    }
    @WebMethod(operationName = "FindReceipes_Directions")
    public ReceipeDirections FindReceipes_Directions(@WebParam(name = "value") String value) 
    {   
        String DB_DRIVER = "org.postgresql.Driver";
        String DB_CONNECTION = "jdbc:postgresql://localhost:5432/cookbook_DB";
        String DB_USER = "CASH";
        String DB_PASSWORD = "1234";
        ReceipeDirections rd = new ReceipeDirections();
        Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {
                    System.err.println("9");
			e.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(
                             DB_CONNECTION, 
                             DB_USER,
                             DB_PASSWORD);
                        

		} catch (SQLException e) {
                    e.printStackTrace();
		}
        
        
        PreparedStatement preparedStatement = null;
        String selectSQL = "SELECT receipe_id, directions from receipe_table where receipe_id = ?";
        
        try{
        preparedStatement = dbConnection.prepareStatement(selectSQL);
        preparedStatement.setInt(1, Integer.parseInt(value));
        
        ResultSet rs = preparedStatement.executeQuery();

        rs.next();
        ReceipeName rn = new ReceipeName();
        rd.setId(rs.getInt("receipe_id"));
        rd.setDirections(rs.getString("directions"));

    }   catch (SQLException ex) {   
        System.err.println("10");
            Logger.getLogger(FindReceipes.class.getName()).log(Level.SEVERE, null, ex);
    }   
    
    return rd;
    }
    
}
