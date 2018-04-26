
package cookbook_handler;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for healthQuotient complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="healthQuotient">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="calories" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="fat" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="protein" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="sodium" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "healthQuotient", propOrder = {
    "calories",
    "fat",
    "id",
    "protein",
    "sodium"
})
public class HealthQuotient {

    protected float calories;
    protected float fat;
    protected int id;
    protected float protein;
    protected float sodium;

    /**
     * Gets the value of the calories property.
     * 
     */
    public float getCalories() {
        return calories;
    }

    /**
     * Sets the value of the calories property.
     * 
     */
    public void setCalories(float value) {
        this.calories = value;
    }

    /**
     * Gets the value of the fat property.
     * 
     */
    public float getFat() {
        return fat;
    }

    /**
     * Sets the value of the fat property.
     * 
     */
    public void setFat(float value) {
        this.fat = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the protein property.
     * 
     */
    public float getProtein() {
        return protein;
    }

    /**
     * Sets the value of the protein property.
     * 
     */
    public void setProtein(float value) {
        this.protein = value;
    }

    /**
     * Gets the value of the sodium property.
     * 
     */
    public float getSodium() {
        return sodium;
    }

    /**
     * Sets the value of the sodium property.
     * 
     */
    public void setSodium(float value) {
        this.sodium = value;
    }

}
