package com.tecOps.workflow.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.android.databinding.library.baseAdapters.BR;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.tecOps.workflow.R;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.utils.EventClickListener;
import com.tecOps.workflow.databinding.EventItemBinding;
import com.tecOps.workflow.view.EventDetails;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> implements EventClickListener {
    private List<EventModel> eventList;
    private Context context;

    public EventAdapter(Context context,List<EventModel> eventList){
        this.context=context;
        this.eventList=eventList;

    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EventItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.event_item, parent, false);
               return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        EventModel eventModel = eventList.get(position);
        holder.itemEventBinding.setEventModel(eventModel);
        holder.bind(eventModel);
        holder.itemEventBinding.setEventClickListener(this);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    @Override
    public void cardClicked(EventModel f) {
        EventRepository.sendPost(f.getEventId().toString());
        EventDetails.slider.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED); //to close slider
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public EventItemBinding itemEventBinding;

        public ViewHolder(EventItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemEventBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemEventBinding.setVariable(BR.eventModel, obj);
            itemEventBinding.executePendingBindings();
        }
    }


}
