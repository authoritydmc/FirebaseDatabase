package authoritydmc.beast.firebasedatabase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MemberViewDetails extends AppCompatActivity {
    public static String GET_MEMBER_ID = "member_id";
    TextView memberName, mMobile, mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_view_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        memberName = findViewById(R.id.view_member_details_membername);
        mMobile = findViewById(R.id.view_member_details_mobilenumber);
        mStatus = findViewById(R.id.view_member_details_status);

        int position = getIntent().getIntExtra(GET_MEMBER_ID, 0);
        memberName.setText(Rooms.defaultlist[position]);
        mMobile.setText("+91123456789");
        mStatus.setText("Due this month");
    }
}
