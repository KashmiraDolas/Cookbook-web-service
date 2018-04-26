/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookbook_client;

import java.util.Collections;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author CASH
 */
public class MyMessageHandler implements SOAPHandler<SOAPMessageContext> {

    public boolean handleMessage(SOAPMessageContext messageContext) {
        Boolean outboundProperty = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        String sessionID = CookBook_Client.getsessionflowId();
        if (outboundProperty.booleanValue()) {
//if the message is outgoing one, i.e., the request to a web service, we add account information into the header
            SOAPMessage message = messageContext.getMessage();
            try {
                SOAPEnvelope envelope = messageContext.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();
                if (header == null) {
                    header = envelope.addHeader();
                }
                SOAPElement usernameToken = header.addChildElement("UsernameToken", "wsse", "http://docs.oasis- open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
                SOAPElement username = usernameToken.addChildElement("Username", "wsse");
                username.addTextNode(sessionID);
            } catch (Exception e) {
                System.err.println("2");//e.printStackTrace();
            }
        } else { //if the message is an incoming one, i.e., the response from the service, then we print out the whole message 
            try {
                SOAPMessage message = messageContext.getMessage();
                //message.writeTo(System.out);
                System.out.println("");
            } catch (Exception ex) {
                System.err.println("1");//ex.printStackTrace();
            }

        }
        return outboundProperty;
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
