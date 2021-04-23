package org.abc.demo.exception;



public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -3605030911925262261L;
    private String msg;
    private String code;

    public BaseException(String code) {
        super(code);
        this.initBaseException(code, ReturnCodeType.getNameByCode(code));
    }

    public BaseException(String code, String message) {
        super(code);
        this.initBaseException(code, message);
    }

    public BaseException(String code, String message, Throwable cause) {
        super(code, cause);
        this.initBaseException(code, message);
    }

    public BaseException(String code, Throwable cause) {
        super(code, cause);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.initBaseException(code, message);
    }

    public BaseException(ReturnCodeType returnCodeType) {
        super(returnCodeType.getCode());
        this.initBaseException(returnCodeType.getCode(), returnCodeType.getName());
    }

    public BaseException(ReturnCodeType returnCodeType, Throwable cause) {
        super(cause);
        this.initBaseException(returnCodeType.getCode(), returnCodeType.getName());
    }

    private void initBaseException(String code, String message) {
        this.msg = message;
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseException)) {
            return false;
        } else {
            BaseException other = (BaseException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseException;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int result = super.hashCode();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        return result;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseException(msg=" + this.getMsg() + ", code=" + this.getCode() + ")";
    }
}
