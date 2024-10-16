package io.codeforall.fanstatics;

public class NotEnoughSpaceException extends FileException{

    @Override
    public String getMessage() {
        return "NotEnoughSpaceException";
    }
}
