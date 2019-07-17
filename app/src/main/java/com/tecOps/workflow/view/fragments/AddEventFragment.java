package com.tecOps.workflow.view.fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.tecOps.workflow.R;
import com.tecOps.workflow.databinding.FragmentAddEventBinding;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.repository.AddNewEventRepository;
import com.tecOps.workflow.viewModel.AddEventViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AddEventFragment extends Fragment {
    private AddEventViewModel addEventViewModel;
    public   final Calendar myCalendar = Calendar.getInstance();
    private View rootView;
    protected static FragmentAddEventBinding binding;
    private TextInputEditText eventDate,timeTo,timeFrom;
    public DatePickerDialog.OnDateSetListener date;
    TimePickerDialog.OnTimeSetListener mOnTimeToSetListener,mOnTimeFromSetListener;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        //binding
        addEventViewModel = ViewModelProviders.of(this).get(AddEventViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_event, container, false);
        binding.setLifecycleOwner(this);
        binding.setAddEventModel(addEventViewModel);
        eventDate=binding.getRoot().findViewById(R.id.input_EventDate);
        timeTo =binding.getRoot().findViewById(R.id.input_eventTimeto);
        timeFrom=binding.getRoot().findViewById(R.id.input_eventTimefrom);

        addEventViewModel.getEvent().observe(this, new Observer<EventModel>() {
            @Override
            public void onChanged(@Nullable EventModel eventModel) {
                if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventName())) {
                    binding.inputEventName.setError("Enter an Event Name");
                    binding.inputEventName.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventParticipants())) {
                    binding.inputEventParticipants.setError("Enter an Event Participants");
                    binding.inputEventParticipants.requestFocus();
                }
               else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventLocation())) {
                    binding.inputEventLocation.setError("Enter an Event Location");
                    binding.inputEventLocation.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventDate())) {
                    binding.inputEventDate.setError("Enter an Event Date");
                    binding.inputEventDate.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventOrganizer())) {
                    binding.inputEventBatch.setError("Enter an Event Organizer");
                    binding.inputEventBatch.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventEndTime())) {
                    binding.inputEventTimeto.setError("Enter an Event End Time");
                    binding.inputEventTimeto.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventStartTime())) {
                    binding.inputEventTimefrom.setError("Enter an Event Start Time");
                    binding.inputEventTimefrom.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventBudget())) {
                    binding.inputEventBudget.setError("Enter an Event Budget");
                    binding.inputEventBudget.requestFocus();
                }
                else if (TextUtils.isEmpty(Objects.requireNonNull(eventModel).getEventDescription())) {
                    binding.inputEventDescription.setError("Enter an Event Description");
                    binding.inputEventDescription.requestFocus();
                }
                else
                {
                    AddNewEventRepository addNewEventRepository=AddNewEventRepository.getInstance();
                    addNewEventRepository.getNews(eventModel);

                }
            }
        });


        selectDate();
        dateOnclick();
        timeOnclick();
        selectTimeTo();
        selectTimeFrom();



        return binding.getRoot();

    }

    public void selectDate()
    {

         date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
    }
    private void  dateOnclick(){
        eventDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(binding.getRoot().getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }
    private void timeOnclick(){
        timeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCalendar =  Calendar.getInstance();
                int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = mCalendar.get(Calendar.MINUTE);


                TimePickerDialog mTimePickerDialog = new TimePickerDialog(
                        binding.getRoot().getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mOnTimeToSetListener,
                        hour,minute,true);

                mTimePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mTimePickerDialog.show();

            }
        });

        timeFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mCalendar =  Calendar.getInstance();
                int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
                int minute = mCalendar.get(Calendar.MINUTE);


                TimePickerDialog mTimePickerDialog = new TimePickerDialog(
                        binding.getRoot().getContext(),
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mOnTimeFromSetListener,
                        hour,minute,true);

                mTimePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mTimePickerDialog.show();

            }
        });

    }
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        eventDate.setText(sdf.format(myCalendar.getTime()));
    }
    private void selectTimeTo(){
        mOnTimeToSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourofday, int minute) {
                String mTime = hourofday+":"+minute;
                timeTo.setText(mTime);
            }
        };

    }
    private void selectTimeFrom(){
        mOnTimeFromSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourofday, int minute) {
                String mTime = hourofday+":"+minute;
                timeFrom.setText(mTime);
            }
        };
    }


}
