package com.yobijoss.RestEmployeeService.model;

public enum Status {
    INACTIVE,
    ACTIVE;

    public static Status parseInt(int i) {
        if (i == INACTIVE.ordinal()) {
            return INACTIVE;
        }
        return ACTIVE;
    }
}
