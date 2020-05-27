package com.example.edur.security;

public enum ApplicationUserPermission {
    EMPLOYEE_WRITE("employee:write"),
    EMPLOYEE_READ("employee:read"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");



    private final String permission;

    ApplicationUserPermission (String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
