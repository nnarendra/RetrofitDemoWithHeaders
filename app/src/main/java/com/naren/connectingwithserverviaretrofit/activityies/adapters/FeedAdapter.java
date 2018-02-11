package com.naren.connectingwithserverviaretrofit.activityies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.naren.connectingwithserverviaretrofit.R;
import com.naren.connectingwithserverviaretrofit.activityies.models.Post;
import com.naren.connectingwithserverviaretrofit.activityies.utils.DateTimeUtility;

import java.util.Date;
import java.util.List;

/**
 * Created by narendra on 11/2/18.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context mContext;
    private List<Post> mFeedList;

    public FeedAdapter(List<Post> postList, Context context) {
        this.mContext = context;
        this.mFeedList = postList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup itemView = (ViewGroup) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_list_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mFeedList.get(position).photo)
                .crossFade()
                .placeholder(R.drawable.user_avatar)
                .error(R.drawable.user_avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .fitCenter()
                .into(holder.mIvUserImage);

        Date postDate = mFeedList.get(position).postTimestamp == null ? new Date() : DateTimeUtility.stringToDateSafe(mFeedList.get(position).postTimestamp);
        holder.mTripTime.setText(DateTimeUtility.getTimeFromDate(postDate));

        //todo below text view i need to show it as per the design.
        holder.mTripDate.setText(DateTimeUtility.getUTCString(postDate, "yyyy-MM-dd"));

        holder.mPostTime.setText(DateUtils.getRelativeTimeSpanString(
                postDate.getTime(),
                new Date().getTime(),
                0
                )
        );
        holder.mTvUserFullName.setText(mFeedList.get(position).firstName + " " + mFeedList.get(position).lastName);

        if (mFeedList.get(position).ride != null) {
            holder.mTripDistance.setText(mFeedList.get(position).ride.distance == null ? "0" : mFeedList.get(position).ride.distance + " KM");
            holder.mStartAddress.setText(mFeedList.get(position).ride.srcAddr == null ? "NA" : mFeedList.get(position).ride.srcAddr);
            holder.mEndAddress.setText(mFeedList.get(position).ride.destAddr == null ? "NA" : mFeedList.get(position).ride.destAddr);
            Integer seats = mFeedList.get(position).ride.seat == null ? 0 : mFeedList.get(position).ride.seat;
            if (mFeedList.get(position).ride.rideType != null && mFeedList.get(position).ride.rideType.equalsIgnoreCase("OFFER")) {
                holder.mReqSeats.setText("Offering Seats: " + Integer.toString(seats));
            } else {
                holder.mReqSeats.setText("Requested Seats: " + Integer.toString(seats));
            }


        } else {
            holder.mTripDistance.setText("0 KM");
            holder.mStartAddress.setText("NA");
            holder.mEndAddress.setText("NA");
            holder.mReqSeats.setText("NA");
        }
        holder.mActionCounts.setText(
                mFeedList.get(position).likes + " Like.  " + mFeedList.get(position).commentCount + " Comments.  " +
                        mFeedList.get(position).shareCount + " Shares"

        );


    }

    @Override
    public int getItemCount() {
        return mFeedList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvUserFullName, mTripDistance, mActionCounts,
                mStartAddress, mEndAddress, mReqSeats, mPostTime,
                mTripTime, mTripDate;
        public ImageView mIvUserImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvUserFullName = itemView.findViewById(R.id.tv_user_full_name);
            mIvUserImage = itemView.findViewById(R.id.iv_profile_image);
            mTripDistance = itemView.findViewById(R.id.tv_trip_distance);
            mActionCounts = itemView.findViewById(R.id.tv_action_counts);
            mStartAddress = itemView.findViewById(R.id.tv_from_address);
            mEndAddress = itemView.findViewById(R.id.tv_to_address);
            mReqSeats = itemView.findViewById(R.id.tv_requested_seats);
            mPostTime = itemView.findViewById(R.id.tv_requested_time);
            mTripTime = itemView.findViewById(R.id.tv_trip_time);
            mTripDate = itemView.findViewById(R.id.tv_trip_date);
        }
    }
}
