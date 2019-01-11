package authoritydmc.beast.firebasedatabase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mcontext;
    List<String> mylst;

    MyAdapter(Context mtx, List<String> list) {
        mcontext = mtx;
        mylst = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.cardview, null);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.cardtext.setText("Room No." + String.valueOf(position + 1));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "you clicked on Room no" + (position + 1), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mcontext, ViewRoomMembersDetails.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(ViewRoomMembersDetails.GET_ROOM_NO, String.valueOf(position + 1));
                mcontext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return 13;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView cardtext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardtext = itemView.findViewById(R.id.cardView_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
