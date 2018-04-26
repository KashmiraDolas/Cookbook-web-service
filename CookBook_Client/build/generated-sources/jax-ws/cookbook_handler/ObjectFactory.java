
package cookbook_handler;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cookbook_handler package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReceipesHealthQuotient_QNAME = new QName("http://CookBook_handler/", "Receipes_HealthQuotient");
    private final static QName _FindReceipesDirections_QNAME = new QName("http://CookBook_handler/", "FindReceipes_Directions");
    private final static QName _FindReceipesDirectionsResponse_QNAME = new QName("http://CookBook_handler/", "FindReceipes_DirectionsResponse");
    private final static QName _ReceipesHealthQuotientResponse_QNAME = new QName("http://CookBook_handler/", "Receipes_HealthQuotientResponse");
    private final static QName _FindReceipesMainIngredient_QNAME = new QName("http://CookBook_handler/", "FindReceipes_MainIngredient");
    private final static QName _FindReceipesMainIngredientResponse_QNAME = new QName("http://CookBook_handler/", "FindReceipes_MainIngredientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cookbook_handler
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindReceipesDirections }
     * 
     */
    public FindReceipesDirections createFindReceipesDirections() {
        return new FindReceipesDirections();
    }

    /**
     * Create an instance of {@link ReceipesHealthQuotient }
     * 
     */
    public ReceipesHealthQuotient createReceipesHealthQuotient() {
        return new ReceipesHealthQuotient();
    }

    /**
     * Create an instance of {@link FindReceipesMainIngredient }
     * 
     */
    public FindReceipesMainIngredient createFindReceipesMainIngredient() {
        return new FindReceipesMainIngredient();
    }

    /**
     * Create an instance of {@link FindReceipesMainIngredientResponse }
     * 
     */
    public FindReceipesMainIngredientResponse createFindReceipesMainIngredientResponse() {
        return new FindReceipesMainIngredientResponse();
    }

    /**
     * Create an instance of {@link FindReceipesDirectionsResponse }
     * 
     */
    public FindReceipesDirectionsResponse createFindReceipesDirectionsResponse() {
        return new FindReceipesDirectionsResponse();
    }

    /**
     * Create an instance of {@link ReceipesHealthQuotientResponse }
     * 
     */
    public ReceipesHealthQuotientResponse createReceipesHealthQuotientResponse() {
        return new ReceipesHealthQuotientResponse();
    }

    /**
     * Create an instance of {@link ReceipeDirections }
     * 
     */
    public ReceipeDirections createReceipeDirections() {
        return new ReceipeDirections();
    }

    /**
     * Create an instance of {@link ReceipeName }
     * 
     */
    public ReceipeName createReceipeName() {
        return new ReceipeName();
    }

    /**
     * Create an instance of {@link HealthQuotient }
     * 
     */
    public HealthQuotient createHealthQuotient() {
        return new HealthQuotient();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceipesHealthQuotient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CookBook_handler/", name = "Receipes_HealthQuotient")
    public JAXBElement<ReceipesHealthQuotient> createReceipesHealthQuotient(ReceipesHealthQuotient value) {
        return new JAXBElement<ReceipesHealthQuotient>(_ReceipesHealthQuotient_QNAME, ReceipesHealthQuotient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReceipesDirections }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CookBook_handler/", name = "FindReceipes_Directions")
    public JAXBElement<FindReceipesDirections> createFindReceipesDirections(FindReceipesDirections value) {
        return new JAXBElement<FindReceipesDirections>(_FindReceipesDirections_QNAME, FindReceipesDirections.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReceipesDirectionsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CookBook_handler/", name = "FindReceipes_DirectionsResponse")
    public JAXBElement<FindReceipesDirectionsResponse> createFindReceipesDirectionsResponse(FindReceipesDirectionsResponse value) {
        return new JAXBElement<FindReceipesDirectionsResponse>(_FindReceipesDirectionsResponse_QNAME, FindReceipesDirectionsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceipesHealthQuotientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CookBook_handler/", name = "Receipes_HealthQuotientResponse")
    public JAXBElement<ReceipesHealthQuotientResponse> createReceipesHealthQuotientResponse(ReceipesHealthQuotientResponse value) {
        return new JAXBElement<ReceipesHealthQuotientResponse>(_ReceipesHealthQuotientResponse_QNAME, ReceipesHealthQuotientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReceipesMainIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CookBook_handler/", name = "FindReceipes_MainIngredient")
    public JAXBElement<FindReceipesMainIngredient> createFindReceipesMainIngredient(FindReceipesMainIngredient value) {
        return new JAXBElement<FindReceipesMainIngredient>(_FindReceipesMainIngredient_QNAME, FindReceipesMainIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReceipesMainIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://CookBook_handler/", name = "FindReceipes_MainIngredientResponse")
    public JAXBElement<FindReceipesMainIngredientResponse> createFindReceipesMainIngredientResponse(FindReceipesMainIngredientResponse value) {
        return new JAXBElement<FindReceipesMainIngredientResponse>(_FindReceipesMainIngredientResponse_QNAME, FindReceipesMainIngredientResponse.class, null, value);
    }

}
