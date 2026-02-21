package com.p2p.server.p2p_backend.repository;
import com.google.api.core.ApiFuture;
import com.p2p.server.p2p_backend.exceptions.ItemNotFoundException;
import com.p2p.server.p2p_backend.model.Item;
import com.p2p.server.p2p_backend.model.User;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository {
    private final Firestore firestore;

    public UserRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    public User getUser(String userId) throws Exception {
        try {
            DocumentSnapshot doc = firestore
                    .collection(User.PATH)
                    .document(userId)
                    .get().get();

            if (!doc.exists()) {
                throw new ItemNotFoundException(userId);
            }
            return doc.toObject(User.class);

        } catch (InterruptedException e) {
            //Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while fetching user", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to fetch user from database", e);
        }
    }

    public void deleteUser(String userId) throws Exception{
        try {
            firestore.collection(User.PATH).document(userId).delete();
        } catch (Exception e) {
            throw new Exception("Failed to delete user with id: " + userId, e);
        }
    }

    public User createUser(User user) throws Exception {
        DocumentReference docRef = firestore.collection(User.PATH).document();
        String userId = docRef.getId();
        user.setId(userId);
        docRef.set(user).get();
        return user;
    }

    public void updateUser(User user) throws Exception{
        ApiFuture<WriteResult> future = firestore
                .collection(User.PATH)
                .document(user.getId())
                .set(user);
        WriteResult result = future.get();
        System.out.println("User " + user.getFirstName() + " updated fields.");
    }
}
