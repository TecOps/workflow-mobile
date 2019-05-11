package com.tecOps.workflow.view.fragments;

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
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.EventRepository;
import com.tecOps.workflow.view.adapter.EventHistoryAdapter;
import java.util.ArrayList;
import java.util.List;

public class EventHistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private EventModel eventModel;
    private View rootView;


    public static List<EventModel> events = new ArrayList<EventModel>();
    public boolean IsEmpty;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        eventModel = new EventModel();
        GetData();
        rootView = inflater.inflate(R.layout.fragment_event_history, container, false);
        InItDataBinding();
        return rootView;
    }

    public void GetData(){
        EventRepository eventRepository = new EventRepository(getContext(),eventModel);
        eventRepository.getEventHistory();
    }
    public void SetData(List<EventModel> events){
        this.events = events;

    }

    private void InItDataBinding()
    {
        IsEmpty = ((events.size() == 0) ? true : false);
        recyclerView = rootView.findViewById(R.id.eventHistoryListView);
        layoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(layoutManager);

        EventHistoryAdapter mAdapter = new EventHistoryAdapter(getContext(), events);
        recyclerView.setAdapter(mAdapter);
    }
}
