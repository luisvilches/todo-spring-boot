package com.bukitech.taskmaster.classes;

public class RemoveResponse {
    private boolean success;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RemoveResponse(boolean success, String message){
        this.message = message;
        this.success = success;
    }
}
