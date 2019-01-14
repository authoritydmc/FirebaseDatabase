package authoritydmc.beast.firebasedatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddMembers extends AppCompatActivity {
    EditText name_member, mobileno, roomno, amount;
    Button register;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference rootref = firebaseDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        name_member = findViewById(R.id.add_member_name);
        amount = findViewById(R.id.add_member_amount);
        mobileno = findViewById(R.id.add_member_mobile);
        roomno = findViewById(R.id.add_member_roomNO);
        register = findViewById(R.id.add_member_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (amount.getText().toString().isEmpty())
                    amount.setText("1100");
                if (roomno.getText().toString().isEmpty()) {
                    roomno.setError("Enter Room No please ");
                    return;
                }
                if (mobileno.getText().toString().isEmpty()) {
                    mobileno.setError("Enter Mobile Number  please ");
                    return;
                }
                if (name_member.getText().toString().isEmpty()) {
                    name_member.setError("Enter Name please ");
                    return;
                }
                SaveDetails();
            }
        });
    }

    private void SaveDetails() {
        DatabaseReference valueref = rootref.child("rooms").child("Room" + roomno.getText().toString()).child(mobileno.getText().toString());


        Map<String, String> values = new HashMap<>();
        values.put("name", name_member.getText().toString());
        values.put("rentamount", amount.getText().toString());
        values.put("status", "Not paid");
        values.put("roomno", roomno.getText().toString());
        valueref.setValue(values).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddMembers.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}
