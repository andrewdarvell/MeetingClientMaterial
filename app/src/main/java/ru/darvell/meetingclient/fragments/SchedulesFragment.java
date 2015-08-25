package ru.darvell.meetingclient.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.darvell.meetingclient.R;

public class SchedulesFragment extends Fragment{

    private View coordinator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schedules_frag, null);
        coordinator = view.findViewById(R.id.coordinator_schedules);
        initFAB(view);
        return view;
    }

    private void initFAB(View view){
        view.findViewById(R.id.fab_add).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Snackbar.make(coordinator, "Test Test", Snackbar.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
