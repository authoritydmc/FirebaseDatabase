package authoritydmc.beast.firebasedatabase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class roomdetails_recycler_adapter extends RecyclerView.Adapter<roomdetails_recycler_adapter.ViewHolder> {
    ArrayList<Rooms> list_members;

    public roomdetails_recycler_adapter(ArrayList<Rooms> list) {
        list_members = list;
    }

    @NonNull
    @Override
    public roomdetails_recycler_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cardview_list_members, null);
        return new roomdetails_recycler_adapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final roomdetails_recycler_adapter.ViewHolder holder, final int position) {
        holder.textView.setText(String.valueOf(position + 1) + ".\t" + list_members.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.cardView.getContext(), ProfileMember.class);
                intent.putExtra(ProfileMember.GET_MEMBER_ID, list_members.get(position).getMobileno());
                intent.putExtra(ProfileMember.GET_ROOM_NO, list_members.get(position).getRoomno());
                holder.cardView.getContext().startActivity(intent);


                Toast.makeText(holder.cardView.getContext(), "Clicked on user", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.cardView_listmembers_textview);
            cardView = itemView.findViewById(R.id.cardView_listmembers);
        }
    }
}
