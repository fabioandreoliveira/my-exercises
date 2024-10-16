package io.codeforall.fanstatics;

public class NotEnoughPermissionException extends FileException {


    @Override
    public String getMessage() {
        return "NotEnoughPermission";
    }
}
