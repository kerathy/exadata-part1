package com.example.dependencyinjectionwithretrofit;

import com.google.gson.annotations.SerializedName;

public class Songs {

    @SerializedName("login")
    private String login;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public Songs(String login, String nodeId, String avatarUrl) {
        this.login = login;
        this.nodeId = nodeId;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
