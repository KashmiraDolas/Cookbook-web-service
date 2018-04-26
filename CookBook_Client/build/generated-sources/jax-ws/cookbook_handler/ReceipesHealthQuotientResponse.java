
package cookbook_handler;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Receipes_HealthQuotientResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Receipes_HealthQuotientResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://CookBook_handler/}healthQuotient" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Receipes_HealthQuotientResponse", propOrder = {
    "_return"
})
public class ReceipesHealthQuotientResponse {

    @XmlElement(name = "return")
    protected HealthQuotient _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link HealthQuotient }
     *     
     */
    public HealthQuotient getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link HealthQuotient }
     *     
     */
    public void setReturn(HealthQuotient value) {
        this._return = value;
    }

}
