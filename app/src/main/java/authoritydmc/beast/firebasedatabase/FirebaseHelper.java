package authoritydmc.beast.firebasedatabase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;

public class FirebaseHelper {


    private void fetchData(DataSnapshot dataSnapshot) {

        String TAG = "fetched";
        Log.d(TAG, "1.Reference=" + dataSnapshot.getRef());

        Log.d(TAG, "2.Value=" + dataSnapshot.getValue());
        Log.d(TAG, "3.KEy=" + dataSnapshot.getKey());
        Log.d(TAG, "\n_____________________\n");

        //    memberslist.add(new Rooms(dataSnapshot.child("name").getValue().toString(),dataSnapshot.getKey().toString(),dataSnapshot.child("rentamount").getValue().toString(),dataSnapshot.child("status").getValue().toString()));

    }
}
