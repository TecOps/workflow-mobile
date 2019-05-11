package com.tecOps.workflow.view.adapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.EventsHistoryBinding;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.view.EventDetails;
import com.tecOps.workflow.viewModel.EventHistoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class EventHistoryAdapter extends RecyclerView.Adapter<EventHistoryAdapter.MyViewHolder> {

    Context context;
    List<EventModel> events;
    public LayoutInflater inflater;

    public EventHistoryAdapter(Context context, List<EventModel> events) {
        this.context = context;
        this.events = events;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eventhistory_item, parent, false);
//        MyViewHolder viewHolder = new MyViewHolder(view);
//        return viewHolder;
        if(inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        EventsHistoryBinding eventhistoryItemBinding = EventsHistoryBinding.inflate(inflater, parent,false);
        return new MyViewHolder(eventhistoryItemBinding);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        holder.name.setText(events.get(position).toString());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              Toast.makeText(context, events.get(position).toString(), Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(view.getContext(), EventDetails.class);
//                context.startActivity(i);
//            }
//        });
        holder.bind(events.get(position));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView name;
//        TextView body;
        private EventsHistoryBinding eventhistoryItemBinding;

        public MyViewHolder(EventsHistoryBinding eventhistoryItemBinding) {
            super(eventhistoryItemBinding.getRoot());
            this.eventhistoryItemBinding = eventhistoryItemBinding;
//            name = itemView.findViewById(R.id.cardViewTitle);
//            body = itemView.findViewById(R.id.cardViewTitle);
        }

        public void bind(EventHistoryViewModel eventHistoryViewModel){
            this.eventhistoryItemBinding.setEventHistoryViewModel(eventHistoryViewModel);
        }

        public EventsHistoryBinding getEventHistoryBinding() {
            return eventhistoryItemBinding;
        }
    }
}