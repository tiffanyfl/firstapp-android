package com.example.tiffany.firstapp;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by tiffany on 15/03/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    // Méthode appelée chaque fois que le token change
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        // Envoyer le token vers le serveur

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // Ajouter ou modifier une propriété
        database.getReference("Token/token_1/num")
                .setValue(token, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError,
                                           DatabaseReference databaseReference) {
                        if (databaseError != null) {
                        } else if (databaseReference != null) { // Succès }
                        }
                    }

                });

    }
}
