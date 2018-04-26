/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CookBook_handler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.NodeList;

/**
 *
 * @author CASH
 */
public class MyMessageHandler implements SOAPHandler<SOAPMessageContext> {
public boolean handleMessage(SOAPMessageContext messageContext) 
    {
        String outProperty = SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY;
        boolean outgoing = (Boolean) messageContext.get(outProperty);
        SOAPMessage msg = messageContext.getMessage();
        String username = "";
        try {
            if (outgoing) {
               msg.writeTo(System.out);
                return true;
            } else {
                SOAPHeader header = msg.getSOAPHeader();
                Iterator it = header.examineAllHeaderElements();
                while (it.hasNext()) {
                    SOAPHeaderElement e = (SOAPHeaderElement) it.next();
                    NodeList nl = e.getElementsByTagName("wsse:Username");
                    for (int i = 0; i < nl.getLength(); i++) {
                        username += nl.item(i).getTextContent();
                    }
                }
               
                
            }
            
            if (msg.getSOAPBody().getChildNodes().item(0).getLocalName().equalsIgnoreCase("findreceipes_mainingredient")) {
                    /* connecting the database to record session history */
                    Connection con = null;
                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FindReceipes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cookbook_DB", "CASH", "1234");

                    String sql = "Insert into sessionhistory (sessionid,operationid) values (?,?)";
                    PreparedStatement myStmt = con.prepareStatement(sql);
                    myStmt.setInt (1, Integer.parseInt(username));
                    myStmt.setString(2, msg.getSOAPBody().getChildNodes().item(0).getLocalName().toString());
                    

                    myStmt.executeUpdate();
                    con.close();
                    System.out.println("Inserted successfully");
                    return true;

                } else if (msg.getSOAPBody().getChildNodes().item(0).getLocalName().equalsIgnoreCase("findreceipes_directions")|| msg.getSOAPBody().getChildNodes().item(0).getLocalName().equalsIgnoreCase("receipes_healthquotient")) {
                    /* connecting the database to record session history */
                    Connection con = null;
                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FindReceipes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cookbook_DB", "CASH", "1234");

                    Statement stmt = con.createStatement();
                    //String operation_name = "displayBookmark";
                    int session_name = Integer.parseInt(username);
                    String sql = "SELECT sessionid FROM sessionhistory where sessionid='" + session_name + "'";
                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next() == true) {
                        Statement stmt1 = con.createStatement();

                        String sql1 = "Delete FROM sessionhistory where sessionid='" + session_name + "'";
                        stmt1.executeUpdate(sql1);
                        con.close();
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    return false;
                }

            }
         catch (SOAPException e) {
            System.out.println("SOAP IO Error!!!!");
            throw new RuntimeException(e);
        }
        catch (IOException ex) {
            System.err.println("3");
            Logger.getLogger(MyMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            System.err.println("4");
            Logger.getLogger(MyMessageHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }

    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }

    public void close(MessageContext context) {
    }

}
