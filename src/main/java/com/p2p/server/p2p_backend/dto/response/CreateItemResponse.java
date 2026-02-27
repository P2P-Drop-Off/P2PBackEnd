package com.p2p.server.p2p_backend.dto.response;

public class CreateItemResponse {
    private String id;
    private String title;

    public CreateItemResponse(String id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
}
