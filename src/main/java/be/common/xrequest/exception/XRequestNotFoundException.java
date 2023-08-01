package be.common.xrequest.exception;

public class XRequestNotFoundException extends RuntimeException
{
    public XRequestNotFoundException(String xrequest) {
        super("The request(s): ["+xrequest+"] was/were not found");
    }
}
