package com.tecOps.workflow.repository;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.tecOps.workflow.model.EventCoordinatorDetail;
import com.tecOps.workflow.model.EventModel;
import com.tecOps.workflow.remote.APIService;
import com.tecOps.workflow.remote.ApiUtils;
import com.tecOps.workflow.utils.ConvertDateAndTime;
import com.tecOps.workflow.view.Calender;
import com.tecOps.workflow.view.fragments.EventHistoryFragment;
import com.tecOps.workflow.viewModel.EventDetailsViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class EventRepository extends Observable {
    private static APIService mAPIService;
    private static Context context;
    private static EventModel eventModel;
    static ConvertDateAndTime dateAndTime;
    public static int eventId;
    public EventRepository(Context context, EventModel eventModel) {
        this.context = context;
        this.eventModel = eventModel;
        dateAndTime = new ConvertDateAndTime();

    }

    public static void sendPost(String id) {

        mAPIService = ApiUtils.getEventAPIService();
        Call<EventModel> call = mAPIService.eventGet(id);
        call.enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                if (response.code() == 403) {
                    //login_page.HideAnimation();
                    Toast.makeText(context, "Your UserName or Password might be wrong!", Toast.LENGTH_SHORT).show();
                } else if (response.code() == 200) {
                    //login_page.HideAnimation();

                    EventModel event = response.body();
                    updateDashbord(event);


                }

                if (response.isSuccessful()) {
                    Log.i(TAG, "post submitted to API." + response.body().toString());

                }

            }

            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {
                //login_page.HideAnimation();
                Toast.makeText(context, "Somthing went wrong!", Toast.LENGTH_SHORT).show();

            }
        });


    }
    public static void updateDashbord(EventModel event)
    {
        eventId=event.getEventId();
        EventDetailsViewModel eventDetailsViewModel = new EventDetailsViewModel(context, eventModel);
        eventModel.setEventDescription(event.getEventDescription());
        eventModel.seteventlocationdate(dateAndTime.convertDate(event.getEventDate()) + " | " + dateAndTime.convertTime(event.getEventStartTime()) + " onwards | " + event.getEventLocation());
        eventModel.setEventName(event.getEventName());
        eventModel.setEventParticipants(event.getEventParticipants());
        eventModel.setEventCoordinatorDetails(event.getEventCoordinatorDetails());
        eventModel.setStatus(event.getEventStatus());
        eventModel.setShowbuffer(false);
        eventModel.setShowConstraint(true);
    }
    public static void searchMonthEvents(String year, String month) {
        mAPIService = ApiUtils.getEventAPIService();
        Call<List<EventModel>> call = mAPIService.filter(year,month);
        call.enqueue(new Callback<List<EventModel>>() {
            @Override
             public void onResponse(Call <List<EventModel>> call, Response  <List<EventModel>> response) {
                if (response.code() == 403) {
                    //login_page.HideAnimation();
                    Toast.makeText(context, "Your UserName or Password might be wrong!", Toast.LENGTH_SHORT).show();
                }
                else if (response.code() == 200) {
                    //login_page.HideAnimation();
                    List <EventModel>  event = response.body();
                        Calender calender =new Calender();
                        calender.showEvents(event);
                }

                if (response.isSuccessful()) {
                    Log.i(TAG, "post submitted to API." + response.body().toString());

                }

            }

            @Override
            public void onFailure(Call <List<EventModel>>call, Throwable t) {
                Toast.makeText(context, "Somthing went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void getEventHistory() {

        /**
         * This is only a hardcoded List<>. This should be refactored with below code after the API avaliable.

         @param
         #
         mAPIService = ApiUtils.getEventAPIService();
         Call<List<EventModel>> call = mAPIService.getAllEvents();
         call.enqueue(new Callback<List<EventModel>>() {
         @Override
         public void onResponse(Call <List<EventModel>> call, Response  <List<EventModel>> response) {
         if (response.code() == 403) {
         //login_page.HideAnimation();
         Toast.makeText(context, "Your UserName or Password might be wrong!", Toast.LENGTH_SHORT).show();
         }
         else if (response.code() == 200) {
         //login_page.HideAnimation();
         List <EventModel>  events = response.body();
         if (!events.isEmpty()) {
         EventHistoryFragment eventHistoryFragment = new EventHistoryFragment();
         eventHistoryFragment.SetData(events);
         }


         }

         if (response.isSuccessful()) {
         Log.i(TAG, "post submitted to API." + response.body().toString());

         }

         }

         @Override
         public void onFailure(Call <List<EventModel>>call, Throwable t) {
         Toast.makeText(context, "Somthing went wrong!", Toast.LENGTH_SHORT).show();
         }
         });

         */

        EventModel eventModel1 = new EventModel(1, "Piritha", "", "", "", "", "", new List<EventCoordinatorDetail>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<EventCoordinatorDetail> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(EventCoordinatorDetail eventCoordinatorDetail) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends EventCoordinatorDetail> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends EventCoordinatorDetail> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public EventCoordinatorDetail get(int i) {
                return null;
            }

            @Override
            public EventCoordinatorDetail set(int i, EventCoordinatorDetail eventCoordinatorDetail) {
                return null;
            }

            @Override
            public void add(int i, EventCoordinatorDetail eventCoordinatorDetail) {

            }

            @Override
            public EventCoordinatorDetail remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<EventCoordinatorDetail> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<EventCoordinatorDetail> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<EventCoordinatorDetail> subList(int i, int i1) {
                return null;
            }
        }, "", "", "In Sri Lanka, the pirith mandapaya is one such space- a consecrated spot where the words of the Buddha are chanted. Pirith (paritta in Pali) means 'protection', usually 'protection from all directions", "", "", "");
        EventModel eventModel2 = new EventModel(1, "Wesak", "", "", "", "", "", new List<EventCoordinatorDetail>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<EventCoordinatorDetail> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(EventCoordinatorDetail eventCoordinatorDetail) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends EventCoordinatorDetail> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends EventCoordinatorDetail> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public EventCoordinatorDetail get(int i) {
                return null;
            }

            @Override
            public EventCoordinatorDetail set(int i, EventCoordinatorDetail eventCoordinatorDetail) {
                return null;
            }

            @Override
            public void add(int i, EventCoordinatorDetail eventCoordinatorDetail) {

            }

            @Override
            public EventCoordinatorDetail remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<EventCoordinatorDetail> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<EventCoordinatorDetail> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<EventCoordinatorDetail> subList(int i, int i1) {
                return null;
            }
        }, "", "", "Vesak, also known as Buddha Jayanti, Buddha Purnima and Buddha Day, is a holiday traditionally observed by Buddhists and some Hindus on different days in India, Sri Lanka, Nepal, Tibet, Bangladesh", "", "", "");
        EventModel eventModel3 = new EventModel(1, "Going Down", "", "", "", "", "", new List<EventCoordinatorDetail>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<EventCoordinatorDetail> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] ts) {
                return null;
            }

            @Override
            public boolean add(EventCoordinatorDetail eventCoordinatorDetail) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends EventCoordinatorDetail> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends EventCoordinatorDetail> collection) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public EventCoordinatorDetail get(int i) {
                return null;
            }

            @Override
            public EventCoordinatorDetail set(int i, EventCoordinatorDetail eventCoordinatorDetail) {
                return null;
            }

            @Override
            public void add(int i, EventCoordinatorDetail eventCoordinatorDetail) {

            }

            @Override
            public EventCoordinatorDetail remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @NonNull
            @Override
            public ListIterator<EventCoordinatorDetail> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<EventCoordinatorDetail> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<EventCoordinatorDetail> subList(int i, int i1) {
                return null;
            }
        }, "", "", "a person or group taking one side of a question, dispute, or contest The parties in the lawsuit reached an agreement. 2 : a group of persons organized for the purpose of directing the policies of a government political parties with opposing agendas", "", "", "");

        List<EventModel> events=new ArrayList<EventModel>();
        events.add(eventModel1);
        events.add(eventModel2);
        events.add(eventModel3);
        events.add(eventModel1);
        events.add(eventModel2);
        events.add(eventModel3);

        EventHistoryFragment eventHistoryFragment = new EventHistoryFragment();
        eventHistoryFragment.SetData(events);
    }

    public static void deleteEvent(int eventId){
        mAPIService = ApiUtils.getEventAPIService();
        Call<String> call = mAPIService.deleteEvent(eventId);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(context, response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
}



