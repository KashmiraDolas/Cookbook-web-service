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
public class HealthQuotient {
    int receipeId;
    float calories;
    float protein;
    float fat;
    float sodium;
    
    public void setId(int r)
    {    
       receipeId = r ;    
    }
    public int getId()
    {
        return receipeId;
    }   
    public void setCalories(float c)
    {    
       calories = c;    
    }
    public float getCalories()
    {
        return calories;
    }   
    
    public void setProtein(float p)
    {    
       protein = p;    
    }
    public float getProtein()
    {
        return protein;
    }   
    public void setFat(float f)
    {    
       fat = f;    
    }
    public float getFat()
    {
        return fat;
    }   
    public void setSodium(float s)
    {    
       sodium = s;    
    }
    public float getSodium()
    {
        return sodium;
    }   
    
    
    
}
