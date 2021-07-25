package com.example.dependencyinjectionwithdagger2;

public class Repository {
    private String name;
    private String fullName;
    private String description;
    private String defaultBranch;

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }
}
