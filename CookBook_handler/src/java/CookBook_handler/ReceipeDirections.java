/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CookBook_handler;

/**
 *
 * @author CASH
 */
public class ReceipeDirections {
    int receipeId;
    String receipeDirections;
    
    public void setId(int r)
    {    
       receipeId = r ;    
    }
    public int getId()
    {
        return receipeId;
    }   
    public void setDirections(String d)
    {    
       receipeDirections = d;    
    }
    public String getDirections()
    {
        return receipeDirections;
    }   
}
