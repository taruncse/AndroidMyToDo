package com.tkb.mytodo;

import java.util.List;

public class Profile {

    private String name;
    private boolean isActive;
    private String email;

    private List<String> permissions;
    // For sponsor
    public Profile(String name, String email,boolean isActive) {
        this.name = name;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getEmail() {
        return email;
    }

}
