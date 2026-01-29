package com.p2p.server.p2p_backend.repository;

import com.p2p.server.p2p_backend.model.StoreUser;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Repository;

@Repository
public class StoreUserRepository {
    private final Firestore firestore;

    public StoreUserRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    // READ
    public StoreUser getStoreUser(String storeUserId) throws Exception {
        DocumentSnapshot doc = firestore
                .collection("storeUsers")
                .document(storeUserId)
                .get()
                .get();

        if (!doc.exists()) {
            System.out.println("StoreUser not found: " + storeUserId);
            return null;
        }

        StoreUser storeUser = doc.toObject(StoreUser.class);

        System.out.println("---- Got StoreUser ----");
        System.out.println("Name: " + storeUser.getFirstName() + " " + storeUser.getLastName());
        System.out.println("Email: " + storeUser.getEmail());

        return storeUser;
    }

    // CREATE
    public StoreUser createStoreUser(StoreUser storeUser) throws Exception {
        DocumentReference docRef = firestore.collection("storeUsers").document();
        String storeUserId = docRef.getId();
        storeUser.setId(storeUserId);
        
        docRef.set(storeUser).get();
        
        System.out.println("---- Created StoreUser ----");
        System.out.println("ID: " + storeUserId);
        System.out.println("Name: " + storeUser.getFirstName() + " " + storeUser.getLastName());
        System.out.println("Email: " + storeUser.getEmail());
        
        return storeUser;
    }
}
