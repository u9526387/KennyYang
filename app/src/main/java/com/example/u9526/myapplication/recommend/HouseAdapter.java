package com.example.u9526.myapplication.recommend;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.u9526.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.android.volley.VolleyLog.TAG;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.ProductViewHolder> {
    private Context mCtx;
    private List<house> houseList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public HouseAdapter(Context mCtx, List<house> productList) {
        this.mCtx = mCtx;
        this.houseList = productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recommend_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        house product = houseList.get(position);

        String imageUrl = product.getImage();
        String Title = product.getTitle();
        String Address = product.getAddress();
        int Price = product.getPrice();
        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.textViewID.setText(String.valueOf(product.getId()));
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewAddress.setText(product.getAddress());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));


    }

    @Override
    public int getItemCount() {
        return houseList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewTitle, textViewAddress, textViewPrice, textViewID;
        public ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.textViewID);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
