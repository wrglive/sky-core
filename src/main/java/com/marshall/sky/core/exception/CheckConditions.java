package com.marshall.sky.core.exception;


import java.util.Objects;

public class CheckConditions {
    private CheckConditions() {
    }

    public static void checkNotNull(Object o, String message) {
        if (o == null) {
            throw new SkyException(new SkyExceptionMsgModel(-1, "", message, null, null));
        }
    }

    public static void checkNotNull(Object o) {
        if (o == null) {
            throw new SkyException(new SkyExceptionMsgModel(-1, "", "参数为空", null, null));
        }
    }

    public static void checkNotNull(Object o, ExFactor exFactor) {
        if (o == null) {
            throw new SkyException(exFactor);
        }
    }

    public static void checkTrue(Boolean o, String message) {
        if (!Objects.equals(o, true)) {
            throw new SkyException(new SkyExceptionMsgModel(-1, "", message, null, null));
        }
    }

    public static void checkTrue(Boolean o, ExFactor exFactor) {
        if (!Objects.equals(o, true)) {
            throw new SkyException(exFactor);
        }
    }

    public static void checkTrue(Boolean o) {
        if (!Objects.equals(o, true)) {
            throw new SkyException(new SkyExceptionMsgModel(-1, "", "is false", null, null));
        }
    }
}