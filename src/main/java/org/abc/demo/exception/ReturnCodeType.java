package org.abc.demo.exception;

import java.util.Arrays;
import java.util.stream.Stream;

public enum ReturnCodeType {
    RPC_ERROR("00006", "服务内部调用异常"),
    TOKEN_ERROR("00000", "TOKEN验证失败"),
    AUTH_ERROR("00001", "用户无权限"),
    ADD_AES_ERROR("00004", "添加AES错误"),
    ADD_SIGNATURE_ERROR("00004", "添加签名错误"),
    BASE_ERROR("10002", "失败"),
    BASE_SUCCESS("10001", "成功"),
    BASE_ENUM_ERROR("10003", "未定义枚举错误"),

    INSERT_ERROR("10010", "插入失败"),
    DELETE_ERROR("10011", "删除失败"),
    UPDATE_ERROR("10012", "更新失败"),

    SELECT_UNION_PAY_MERCHANT_ERROR("100121", "无对应银联商户信息"),
    ;

    private String code;
    private String name;

    private ReturnCodeType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(String code) {
        return (String)Arrays.stream(values()).filter((codeType) -> {
            return codeType.getCode().equals(code);
        }).findFirst().map(ReturnCodeType::getName).orElse(getNameByCode(code));
    }

    public static boolean inCode(String code) {
        Stream var10000 = Arrays.stream(values()).map(ReturnCodeType::getCode);
        code.getClass();
        return var10000.anyMatch(code::equals);
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}
