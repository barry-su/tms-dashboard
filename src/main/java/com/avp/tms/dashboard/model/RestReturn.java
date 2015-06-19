/**
 * Copyright (c) 2015 All Rights Reserved, ROAM Data, Inc.
 */
package com.avp.tms.dashboard.model;

public class RestReturn<T> {

private String status;
private String errCode;
private String errMsg;
private T result;

public RestReturn() {
// TODO Auto-generated constructor stub
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getErrCode() {
return errCode;
}

public void setErrCode(String errCode) {
this.errCode = errCode;
}

public String getErrMsg() {
return errMsg;
}

public void setErrMsg(String errMsg) {
this.errMsg = errMsg;
}

public T getResult() {
return result;
}

public void setResult(T result) {
this.result = result;
}


}
