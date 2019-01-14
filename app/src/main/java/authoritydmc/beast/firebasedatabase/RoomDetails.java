package authoritydmc.beast.firebasedatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RoomDetails extends AppCompatActivity {
    public static String GET_ROOM_NO = "room_number";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference rootref = database.getReference().child("rooms");
    ArrayList<Rooms> memberslist;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String roomnumber = getIntent().getStringExtra(GET_ROOM_NO);
        setContentView(R.layout.roomdetails);
        memberslist = new ArrayList<Rooms>();
        recyclerView = findViewById(R.id.listRoom_member_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(RoomDetails.this, 2));

        TextView roomno = findViewById(R.id.listRoom_roomnotextview);
        roomno.setText("Room No:" + roomnumber);
        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("Room" + roomnumber)) {///Member found
                    Toast.makeText(getApplicationContext(), "FOund Members", Toast.LENGTH_SHORT).show();
                    Log.d("fetched", "found members");
                    DatabaseReference members = rootref.child("Room" + roomnumber);

                    members.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            fetchData(dataSnapshot);
                            populateview();
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            fetchData(dataSnapshot);
                            populateview();
                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                } else {
                    Toast.makeText(getApplicationContext(), "No members in Current Room", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void populateview() {
        roomdetails_recycler_adapter recycler_adapter = new roomdetails_recycler_adapter(memberslist);
        recyclerView.setAdapter(recycler_adapter);


    }

    private void fetchData(DataSnapshot dataSnapshot) {

        String TAG = "fetched";
        Log.d(TAG, "1.Reference=" + dataSnapshot.getRef());

        Log.d(TAG, "2.Value=" + dataSnapshot.getValue());
        Log.d(TAG, "3.KEy=" + dataSnapshot.getKey());
        Log.d(TAG, "\n_____________________\n");

        memberslist.add(new Rooms(dataSnapshot.child("name").getValue().toString(), dataSnapshot.getKey(), dataSnapshot.child("rentamount").getValue().toString(), dataSnapshot.child("status").getValue().toString(), dataSnapshot.child("roomno").getValue().toString()));

    }
}
