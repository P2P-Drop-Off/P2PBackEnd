package com.p2p.server.p2p_backend.exceptions;

public class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String id) {
            super("Item with id " + id + " not found.");
        }
}
