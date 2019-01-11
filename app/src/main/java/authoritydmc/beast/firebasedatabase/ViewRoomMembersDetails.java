package authoritydmc.beast.firebasedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewRoomMembersDetails extends AppCompatActivity {
    public static String GET_ROOM_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] defaultmembers = {"RAj", "Kaj", "Baj"};
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String roomnumber = null;
        setContentView(R.layout.activity_view_room_members_details);
        TextView roomno;
        ListView listView = findViewById(R.id.ViewMember_memberlistview);
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, defaultmembers));
        roomnumber = getIntent().getStringExtra(GET_ROOM_NO);
        roomno = findViewById(R.id.ViewMember_roomnotextview);
        roomno.setText("Room no. " + roomnumber);

    }
}
