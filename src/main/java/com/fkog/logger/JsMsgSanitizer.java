package com.fkog.logger;

public class JsMsgSanitizer implements MsgSanitizer {

    public static MsgSanitizer getInstance() {
        return new JsMsgSanitizer();
    }

    private JsMsgSanitizer() {

    }

    @Override
    public String sanitize(String inputString) {
        if (inputString != null) {
            return inputString.replace("<", "&lt;").replace(">", "&gt;");
        }
        return null;
    }
}
