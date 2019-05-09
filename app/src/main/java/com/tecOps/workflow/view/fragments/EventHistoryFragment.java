package com.tecOps.workflow.view.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.ActivityEventDetailsBinding;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.view.adapter.EventHistoryAdapter;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;
import com.tecOps.workflow.viewModel.EventHistoryViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class EventHistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private EventModel eventModel;
    private EventHistoryViewModel eventHistoryViewModel;
    private View rootView;
    protected static ActivityEventDetailsBinding activityEventDetailsBinding;


    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_event_history, container, false);
        InItDataBinding();
        return rootView;
    }


    private void InItDataBinding()
    {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.eventHistoryListView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        EventHistoryAdapter mAdapter = new EventHistoryAdapter(getContext(), personNames);
        recyclerView.setAdapter(mAdapter);

        eventModel=new EventModel();

        eventHistoryViewModel=new EventHistoryViewModel(rootView.getContext(),eventModel);
        activityEventDetailsBinding = DataBindingUtil.setContentView(this, R.layout.fragment_event_history);
        activityEventDetailsBinding.setEventModel(eventModel);
        EventRepository eventRepository=new EventRepository(this,eventModel) ;
        eventRepository.sendPost("1");


        activityEventDetailsBinding.executePendingBindings();
    }
}
