package com.process.xboot.exception;


/**
 * @author xkx
 */
public class XbootRuntimeException extends RuntimeException {

  private Integer code;

  public XbootRuntimeException(Throwable e) {
    super(e);
  }

  public XbootRuntimeException(String message) {
    super(message);
  }

  public XbootRuntimeException(String message, Integer code) {
    super(message);
    this.code = code;
  }

  public XbootRuntimeException(String message, Integer code, Throwable e) {
    super(message, e);
    this.code = code;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }
}
