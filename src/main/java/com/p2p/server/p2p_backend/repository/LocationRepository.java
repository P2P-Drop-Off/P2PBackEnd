package com.p2p.server.p2p_backend.repository;

import com.p2p.server.p2p_backend.model.Location;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository {
    private final Firestore firestore;

    public LocationRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    // READ
    public Location getLocation(String locationId) throws Exception {
        DocumentSnapshot doc = firestore
                .collection("locations")
                .document(locationId)
                .get()
                .get();

        if (!doc.exists()) {
            System.out.println("Location not found: " + locationId);
            return null;
        }

        Location location = doc.toObject(Location.class);

        System.out.println("---- Got Location ----");
        System.out.println("Name: " + location.getName());
        System.out.println("City: " + location.getCity() + ", " + location.getState());

        return location;
    }

    // CREATE
    public Location createLocation(Location location) throws Exception {
        DocumentReference docRef = firestore.collection("locations").document();
        String locationId = docRef.getId();
        location.setId(locationId);
        
        docRef.set(location).get();
        
        System.out.println("---- Created Location ----");
        System.out.println("ID: " + locationId);
        System.out.println("Name: " + location.getName());
        System.out.println("City: " + location.getCity() + ", " + location.getState());
        
        return location;
    }
}
