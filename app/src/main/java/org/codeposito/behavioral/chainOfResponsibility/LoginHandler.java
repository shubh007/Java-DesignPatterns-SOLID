package org.codeposito.behavioral.chainOfResponsibility;

/**
 * Concrete handler for processing login requests.
 */
public class LoginHandler extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getType() == RequestType.LOGIN;
    }

    @Override
    protected void processRequest(Request request) {
        System.out.println("LoginHandler: Processing login request - " + request.getDescription());
        System.out.println("LoginHandler: Validating credentials and authenticating user...");
        System.out.println("LoginHandler: Login request processed successfully.");
    }
} 