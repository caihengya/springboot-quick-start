package org.abc.demo.exception;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Arrays;

public enum StatusType {
    SUCCESS(1, "成功"),
    ERROR(0, "失败");

    private int code;
    private String name;

    private StatusType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(int code) {
        return (String)Arrays.stream(values()).filter((enuma) -> {
            return enuma.getCode() == code;
        }).findFirst().map(StatusType::getName).orElse("未知枚举项");
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
