package com.tecOps.workflow.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.EventItemBinding;
import com.tecOps.workflow.databinding.InspectorItemBinding;
import com.tecOps.workflow.model.EventCoordinatorDetail;
import com.tecOps.workflow.model.EventInspectorDetail;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.utils.EventClickListener;

import java.util.List;

public class InspectAdapter extends RecyclerView.Adapter<InspectAdapter.ViewHolder> implements EventClickListener {
    private List<EventInspectorDetail> eventInspectorDetails;
    private Context context;

    public InspectAdapter(Context context, List<EventInspectorDetail> eventCoordinatorList){
        this.context=context;
        this.eventInspectorDetails=eventCoordinatorList;

    }
    @NonNull
    @Override
    public InspectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        InspectorItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.inspector_item, parent, false);
        return new InspectAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InspectAdapter.ViewHolder holder, int position) {

        EventInspectorDetail eventModel = eventInspectorDetails.get(position);
        holder.inspectorItemBinding.setEventModel(eventModel);
        holder.bind(eventModel);


    }

    @Override
    public int getItemCount() {
        return eventInspectorDetails.size();
    }

    @Override
    public void cardClicked(EventModel f) {

    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public InspectorItemBinding inspectorItemBinding;

        public ViewHolder(InspectorItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.inspectorItemBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            inspectorItemBinding.setVariable(BR.eventModel, obj);
            inspectorItemBinding.executePendingBindings();
        }
    }
}
