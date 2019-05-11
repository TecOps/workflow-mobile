package com.tecOps.workflow.view.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tecOps.workflow.databinding.EventsHistoryBinding;
import com.tecOps.workflow.model.EventModel;
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
        if(inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        EventsHistoryBinding eventhistoryItemBinding = EventsHistoryBinding.inflate(inflater, parent,false);
        return new MyViewHolder(eventhistoryItemBinding);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
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

        public void bind(EventModel eventHistoryViewModel){
            this.eventhistoryItemBinding.setEventModel(eventHistoryViewModel);
        }
    }
}