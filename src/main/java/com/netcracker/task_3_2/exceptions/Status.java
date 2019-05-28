package com.netcracker.task_3_2.exceptions;

import io.swagger.annotations.ApiModelProperty;

public class Status {

    @ApiModelProperty(notes = "The status of the operation")
    private Flag status;

    public Status(){
        status = Flag.NO_STATUS;
    }

    public Status(Flag flag) {
        status = flag;
    }

    public Flag getStatus() {
        return status;
    }

    public void setStatus(Flag status) {
        this.status = status;
    }

}