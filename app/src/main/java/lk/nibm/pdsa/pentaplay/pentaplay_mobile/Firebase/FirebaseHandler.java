package lk.nibm.pdsa.pentaplay.pentaplay_mobile.Firebase;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Player;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Search;
import lk.nibm.pdsa.pentaplay.pentaplay_mobile.Model.Sort;

public class FirebaseHandler {

    private FirebaseFirestore firestore;
    private CollectionReference playersCollection;
    private CollectionReference searchCollection;
    private CollectionReference sortCollection;

    public FirebaseHandler() {
        firestore = FirebaseFirestore.getInstance();
        playersCollection = firestore.collection("Player");
        searchCollection = firestore.collection("Search");
        sortCollection = firestore.collection("Sort");
    }

    public void store(Player player, Map<String, Object> answer) {
        if (player != null && player.getId() != null) {
            Map<String, Object> playerData = new HashMap<>();
            playerData.put("name", player.getName());
            playerData.put("game code", player.getGameCode());
            playerData.put("answer", answer);
            playerData.put("date", player.getDate());
            playerData.put("time", player.getTime());

            // Store data in Firebase using player's id
            playersCollection.document(player.getId()).set(playerData, SetOptions.merge())
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully written"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
        } else {
            System.err.println("Player or player id is null");
        }
    }

    public void store(Player player, int answer) {
        if (player != null && player.getId() != null) {
            Map<String, Object> playerData = new HashMap<>();
            playerData.put("name", player.getName());
            playerData.put("answer", answer);
            playerData.put("date", player.getDate());
            playerData.put("time", player.getTime());

            // Store data in Firebase using player's id
            playersCollection.document(player.getId()).set(playerData, SetOptions.merge())
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully written"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));
        } else {
            System.err.println("Player or player id is null");
        }
    }

    public void storeSearch(Search search) {
        if (search != null) {
            Map<String, Object> searchData = new HashMap<>();
            searchData.put("searchType", search.getType());
            searchData.put("searchDuration", search.getDuration() + " NanoSecs");

            // Store search data in Firebase
            searchCollection.add(searchData)
                    .addOnSuccessListener(documentReference -> Log.d(TAG, "Search data added successfully"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding search data", e));
        } else {
            System.err.println("Search object is null");
        }
    }

    public void storeSort(Sort sort) {
        if (sort != null) {
            Map<String, Object> sortData = new HashMap<>();
            sortData.put("sortType", sort.getType());
            sortData.put("sortDuration", sort.getDuration() + " NanoSecs");

            // Store sort data in Firebase
            sortCollection.add(sortData)
                    .addOnSuccessListener(documentReference -> Log.d(TAG, "Sort data added successfully"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error adding sort data", e));
        } else {
            System.err.println("Sort object is null");
        }
    }

}
