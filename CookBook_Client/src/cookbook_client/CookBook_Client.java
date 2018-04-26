/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cookbook_client;
//import CookBook_handler.ReceipeDirections;

import cookbook_handler.HealthQuotient;
import cookbook_handler.ReceipeDirections;
import cookbook_handler.ReceipeName;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import javax.xml.soap.SOAPException;
import java.util.Scanner;


/**
 *
 * @author CASH
 */
public class CookBook_Client {
    static String sessionflowId = "";
    static String operationflowName = "";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Select from the following options:\n "
                        + "1. Find Receipes with the name of the main ingredient..\n "
                        + "2. See the health quotient of the receipe using unique id..\n "
                        + "3. Get cooking directions using unique id..\n "
                        + "4. Exit ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.print("Enter the name of the main ingredient you want to cook with.. ");
                        String ingredient = sc.next();
                        SetoperationflowName("findReceipesMainIngredient");
                        setsessionflowId("1");
                        
                        java.util.List<cookbook_handler.ReceipeName> rlist = findReceipesMainIngredient(ingredient);//ingredient);
                        System.out.println("\nRequesting service..\n");
                        pprint();
                        System.out.println("UID \t Title");
                        for (int i = 0; i < rlist.size(); i++) {
                            ReceipeName rn = rlist.get(i);
                            System.out.println(rn.getId()+"\t"+rn.getTitle());
                        }
                        System.out.println();
                        pprint();
                        break;
                        
                    case 2:
                        System.out.print("Enter UID of the receipe for health quotient info.. ");
                        String value = sc.next();
                        
                        SetoperationflowName("receipesHealthQuotient");
                        setsessionflowId("1");
                        System.out.println("\nRequesting service..\n");
                        HealthQuotient hq = receipesHealthQuotient(value);
                        pprint();
                        System.out.println("This food contains:");
                        if (hq.getCalories() > 0.0)
                            System.out.println("Calories - " + hq.getCalories() );
                        if (hq.getProtein() > 0.0)
                            System.out.println("Protein - "+ hq.getProtein() + "g");
                        if (hq.getFat() > 0.0)
                            System.out.println("Fat - "+ hq.getFat() + "g");
                        if (hq.getSodium() > 0.0)
                            System.out.println("Sodium - "+ hq.getSodium() + "mg");
                        System.out.println();
                        pprint();
                        break;
                    case 3:
                        System.out.print("Enter UID of the receipe for cooking directions.. ");
                        String value1 = sc.next();
                        
                        SetoperationflowName("findReceipesDirections");
                        setsessionflowId("1");
                        System.out.println("\nRequesting service..\n");
                        ReceipeDirections hd = findReceipesDirections(value1);
                        pprint();
                        System.out.println("Directions:");
                        System.out.println(hd.getDirections() );
                        
                        //System.out.println(updateBookmark(id, name1, website1));
                        System.out.println();
                        pprint();
                        break;
                    case 4:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The flow of operations is Find receipes before "
                    + "\nenquiring the Health quotient or the directions...\n"
                    + "Request again in correct flow");
        }
        
    }

    private static ReceipeDirections findReceipesDirections(java.lang.String value) {
        cookbook_handler.FindReceipes_Service service = new cookbook_handler.FindReceipes_Service();
        cookbook_handler.FindReceipes port = service.getFindReceipesPort();
        return port.findReceipesDirections(value);
        
        
    }

    private static java.util.List<cookbook_handler.ReceipeName> findReceipesMainIngredient(java.lang.String value) {
        cookbook_handler.FindReceipes_Service service = new cookbook_handler.FindReceipes_Service();
        cookbook_handler.FindReceipes port = service.getFindReceipesPort();
        return port.findReceipesMainIngredient(value);
    }

    private static HealthQuotient receipesHealthQuotient(java.lang.String value) {
        cookbook_handler.FindReceipes_Service service = new cookbook_handler.FindReceipes_Service();
        cookbook_handler.FindReceipes port = service.getFindReceipesPort();
        return port.receipesHealthQuotient(value);
    }
    
     public static void SetoperationflowName(String name) {
        operationflowName = name;
    }
    
    public static String GetoperationflowName() {
        return operationflowName;
    }
   
    public static void setsessionflowId(String session) {
        sessionflowId = session;
    }
    public static String getsessionflowId() {
        return sessionflowId;
    }
    public static void pprint(){
        System.out.println("------------------------------------------------------------------------------------------------");
    }
    
    
}
