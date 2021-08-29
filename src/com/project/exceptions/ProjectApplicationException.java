package com.project.exceptions;

public class ProjectApplicationException extends Exception {

    public ProjectApplicationException() {
    }

    public ProjectApplicationException(String arg0) {
        super(arg0);
    }

    public ProjectApplicationException(Throwable arg0) {
        super(arg0);
    }

    public ProjectApplicationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ProjectApplicationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
