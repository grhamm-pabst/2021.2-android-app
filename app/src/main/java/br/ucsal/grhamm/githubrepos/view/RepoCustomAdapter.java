package br.ucsal.grhamm.githubrepos.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import br.ucsal.grhamm.githubrepos.R;

import br.ucsal.grhamm.githubrepos.model.Repo;

public class RepoCustomAdapter extends RecyclerView.Adapter<RepoCustomAdapter.CustomViewHolder> {

    private List<Repo> data;

    public RepoCustomAdapter(List<Repo> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list_item, parent, false);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Repo repo = data.get(position);
        holder.getName().setText(repo.getName());
        holder.getDescription().setText(repo.getDescription());
        holder.getLanguage().setText("Linguagem: " + repo.getLanguage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void update(List<Repo> repos) {

        notifyItemRangeRemoved(0,this.data.size());
        this.data.clear();
        this.data.addAll(repos);
        notifyItemRangeInserted(0,this.data.size());
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView description;

        public TextView getName() {
            return name;
        }

        public TextView getDescription() {
            return description;
        }

        public TextView getLanguage() {
            return language;
        }

        private final TextView language;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
            language = view.findViewById(R.id.language);


        }
    }
}
