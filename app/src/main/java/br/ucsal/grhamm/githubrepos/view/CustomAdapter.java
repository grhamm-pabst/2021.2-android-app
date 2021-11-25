package br.ucsal.grhamm.githubrepos.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import br.ucsal.grhamm.githubrepos.R;

import br.ucsal.grhamm.githubrepos.model.User;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<User> data;

    public CustomAdapter() { this.data = Collections.emptyList(); }

    public CustomAdapter(List<User> data){
        this.data = data;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_history_list_item, parent, false);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        User user = data.get(position);
        holder.getUsername().setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void update(List<User> users) {
        notifyItemRangeRemoved(0,this.data.size());
        this.data.clear();
        this.data.addAll(users);
        notifyItemRangeInserted(0,this.data.size());
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private final TextView username;

        public TextView getUsername() {
            return username;
        }

        public CustomViewHolder(@NonNull View view) {
            super(view);
            username = view.findViewById(R.id.search_username_item);


        }
    }
}
