package org.abc.demo.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by @author fww on 2019-05-15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse<T> implements Serializable {
    private static final long serialVersionUID = -2932524468952580504L;

    /**
     * 接口状态成功或失败
     */
    private Integer status;

    /**
     * 返回的状态码
     */
    private String returnCode;

    /**
     * 返回的状态信息
     */
    private String returnMsg;

    /**
     * 如果是分页的话返回的是数据量
     */
    private Long total;

    /**
     * 返回的数据jsonBody
     */
    private T data;

    /**
     * @param data 数据信息
     * @return
     */
    public static <T> ServerResponse<T> success(T data) {
        return success(ReturnCodeType.BASE_SUCCESS, data);
    }

    /**
     * 成功无 data
     * @return
     */
    public static <T> ServerResponse<T> success() {
        return success(ReturnCodeType.BASE_SUCCESS,null);
    }




    public static <T> ServerResponse<T> success(ReturnCodeType codeType, T data) {
        return loadValue(StatusType.SUCCESS, codeType, 0L, data);
    }

    public static <T> ServerResponse<T> successWithPageData(T data, Long total) {
        return successWithPageData(ReturnCodeType.BASE_SUCCESS, data, total);
    }

    public static <T> ServerResponse<T> successWithPageData(ReturnCodeType codeType, T data, Long total) {
        return loadValue(StatusType.SUCCESS, codeType, total, data);
    }

    public static <T> ServerResponse<T> error() {
        return error(ReturnCodeType.BASE_ERROR);
    }

    public static <T> ServerResponse<T> error(ReturnCodeType codeType) {
        return loadValue(StatusType.ERROR, codeType, null, null);
    }

    public static <T> ServerResponse<T> error(Exception exception) {
        if (exception instanceof BaseException) {
            BaseException baseException = (BaseException) exception;
            return error(baseException.getCode(), baseException.getMsg());
        }
        return error(ReturnCodeType.BASE_ERROR.getCode(), exception.getMessage());
    }


    public static <T> ServerResponse<T> error(String returnCode, String returnMsg) {
        return new ServerResponse<T>(StatusType.ERROR.getCode(), returnCode, returnMsg, null, null);
    }

    private static <T> ServerResponse<T> loadValue(StatusType statusType, ReturnCodeType codeType, Long total, T data) {
        return new ServerResponse<T>(statusType.getCode(), codeType.getCode(), codeType.getName(), total, data);
    }
}
