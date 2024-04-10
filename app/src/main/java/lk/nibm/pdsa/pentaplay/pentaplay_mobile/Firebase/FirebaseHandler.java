package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Firebase;

import static android.content.ContentValues.TAG;

import android.util.Log;


import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Player;

public class FirebaseHandler {

    private FirebaseFirestore firestore;
    private CollectionReference playersCollection;

    public FirebaseHandler() {
        firestore = FirebaseFirestore.getInstance();
        playersCollection = firestore.collection("Players");
    }

    public void store(Player player, Map<String, Object> answer) {
        if (player != null && player.getName() != null) {
            Map<String, Object> playerData = new HashMap<>();
            playerData.put("name", player.getName());
            playerData.put("answer", answer);
            playerData.put("date", player.getDate());
            playerData.put("time", player.getTime());

            // Store data in Firebase
            playersCollection.document(player.getName()).set(playerData, SetOptions.merge())
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully written"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
        } else {
            System.err.println("Player or player name is null");
        }
    }

    public void store(Player player, int answer) {
        if (player != null && player.getName() != null) {
            Map<String, Object> playerData = new HashMap<>();
            playerData.put("name", player.getName());
            playerData.put("answer", answer);
            playerData.put("date", player.getDate());
            playerData.put("time", player.getTime());

            // Store data in Firebase
            playersCollection.document(player.getName()).set(playerData, SetOptions.merge())
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully written"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
        } else {
            System.err.println("Player or player name is null");
        }
    }

}
