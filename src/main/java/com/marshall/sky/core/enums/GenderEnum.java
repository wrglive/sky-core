package com.marshall.sky.core.enums;

import java.util.Arrays;

public enum GenderEnum {
    NONE(0),
    MAN(1),
    WOMEN(2);

    int index;

    public static GenderEnum getByIndex(Integer index) {
        return Arrays.stream(GenderEnum.values())
            .filter(genderEnum -> genderEnum.getIndex() == index)
            .findFirst()
            .orElse(NONE);
    }

    GenderEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
