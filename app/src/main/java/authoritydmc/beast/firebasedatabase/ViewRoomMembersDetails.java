package authoritydmc.beast.firebasedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewRoomMembersDetails extends AppCompatActivity {
    public static String GET_ROOM_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String roomnumber = null;
        setContentView(R.layout.activity_view_room_members_details);
        TextView roomno;
        ListView listView = findViewById(R.id.ViewMember_memberlistview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Rooms.defaultlist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MemberViewDetails.class);
                intent.putExtra(MemberViewDetails.GET_MEMBER_ID, position);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);
            }
        });
        listView.setAdapter(arrayAdapter);
        roomnumber = getIntent().getStringExtra(GET_ROOM_NO);
        roomno = findViewById(R.id.ViewMember_roomnotextview);
        roomno.setText("Room no. " + roomnumber);

    }
}
