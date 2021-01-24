package com.example.list_planets;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.ViewHolder>
{
    private ArrayList<planet> mDataSet;

    public PlanetAdapter(ArrayList<planet> monDataset)
    {
        mDataSet= monDataset;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        //Y declarer les objetsde la vuequi serontchargés (par le tableau de données)
        TextView title;
        TextView description;
        ImageView icon;
        //Constructeur du holder : le viewHoldera unereference verstousles objetsde la liste
        public ViewHolder(View v)
        {
            super(v);
            title= (TextView) v.findViewById(R.id.planet_name);
            description= (TextView) v.findViewById(R.id.planet_description);
            icon= (ImageView) v.findViewById(R.id.imageView);
        }
    }


    @Override
    public PlanetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_planet, parent, false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.title.setText(mDataSet.get(position).getName());
        holder.description.setText(mDataSet.get(position).getWeight());
        holder.icon.setImageResource(mDataSet.get(position).getIcon());
    }

}
