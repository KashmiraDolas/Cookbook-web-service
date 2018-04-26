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
public class ReceipeName {
    int   receipeId;
    String    receipeTitle;
    
    public void setId(int r)
    {    
       receipeId = r ;    
    }
    public int getId()
    {
        return receipeId;
    }   
    public void setTitle(String t)
    {    
       receipeTitle = t;    
    }
    public String getTitle()
    {
        return receipeTitle;
    }   
    
}
