package com.naren.connectingwithserverviaretrofit.activityies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naren.connectingwithserverviaretrofit.R;
import com.naren.connectingwithserverviaretrofit.activityies.models.Post;

import java.util.List;

/**
 * Created by narendra on 11/2/18.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context mContext;
    private List<Post> mFeedList;

    public FeedAdapter(List<Post> postList, Context context) {
        this.mContext=context;
        this.mFeedList=postList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup itemView = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTvUserFullName.setText(mFeedList.get(position).firstName + " " + mFeedList.get(position).lastName);
    }

    @Override
    public int getItemCount() {
        return mFeedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvUserFullName;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvUserFullName = itemView.findViewById(R.id.user_full_name);
        }
    }
}
