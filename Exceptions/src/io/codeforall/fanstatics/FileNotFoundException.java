package io.codeforall.fanstatics;

public class FileNotFoundException extends FileException{

    @Override
    public String getMessage() {
        return "File not found";
    }
}
