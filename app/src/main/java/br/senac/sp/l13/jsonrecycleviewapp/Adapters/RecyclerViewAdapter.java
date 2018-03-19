package br.senac.sp.l13.jsonrecycleviewapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import br.senac.sp.l13.jsonrecycleviewapp.Model.Anime;
import br.senac.sp.l13.jsonrecycleviewapp.R;

/**
 * Created by laercio.nsilva on 19/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context myContext;
    private List<Anime> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context myContext, List<Anime> mData) {
        this.myContext = myContext;
        this.mData = mData;


        //Requerindo option para Glide

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(myContext);

        view = inflater.inflate(R.layout.anime_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getStudio());
        holder.tv_category.setText(mData.get(position).getCategorie());

        Glide.with(myContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        ImageView img_thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.anime_name);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_studio = itemView.findViewById(R.id.studio);
            tv_category = itemView.findViewById(R.id.categorie);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }
}
