package authoritydmc.beast.firebasedatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileMember extends AppCompatActivity {
    public static String GET_MEMBER_ID = "member_id";
    public static String GET_ROOM_NO = "get_room_no";
    TextView memberName, mMobile, mStatus;
    DatabaseReference rootref = FirebaseDatabase.getInstance().getReference().child("rooms");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        memberName = findViewById(R.id.profile_membername);
        mMobile = findViewById(R.id.profile_mobilenumber);
        mStatus = findViewById(R.id.profile_status);

        final String member_id = getIntent().getStringExtra(GET_MEMBER_ID);
        final String roomno = getIntent().getStringExtra(GET_ROOM_NO);
        DatabaseReference databaseReference = rootref.child("Room" + roomno).child(member_id);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                populateView(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void populateView(DataSnapshot dataSnapshot) {
        Log.d("TEST", "ref=" + dataSnapshot.getRef());
        Log.d("TEST", "key=" + dataSnapshot.getKey());
        Log.d("TEST", "value=" + dataSnapshot.getValue());
        Log.d("TEST", "\n-----------------\n");
        memberName.setText(dataSnapshot.child("name").getValue().toString());
        mMobile.setText(dataSnapshot.getKey());
        mStatus.setText(dataSnapshot.child("status").getValue().toString());
    }
}
