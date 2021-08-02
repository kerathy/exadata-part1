package com.example.dependencyinjectionwithretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private Context context;
    private List<Songs> allSongs;


    public SongAdapter(Context context, List<Songs> allSongs) {
        this.context = context;
        this.allSongs = allSongs;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_layout, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.SongViewHolder holder, int position) {
        Songs song = allSongs.get(position);
        holder.songTitle.setText(song.getNodeId());
        holder.songAuthor.setText(song.getLogin());

//        String imagePath = Helper.ImageUrl + "images/" + song.getSongImage();
        String imagePath = song.getAvatarUrl();
        Glide.with(context).load(imagePath).fitCenter().into(holder.songImage);

    }

    @Override
    public int getItemCount() {
        return allSongs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{
        private TextView songTitle;
        private TextView songAuthor;
        private ImageView songImage;


        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songTitle = itemView.findViewById(R.id.song_name);
            songAuthor = itemView.findViewById(R.id.song_author);
            songImage = itemView.findViewById(R.id.song_image);
        }
    }
}
