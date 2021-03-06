package kz.mobile.fragmentapp;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    private Button button;

    private FirstFragmentListener listener;

    private int counter = 0;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FirstFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button = view.findViewById(R.id.button); //Init button in Fragment with view
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show toast on click
                counter++;
                listener.counterResult(counter);
            }
        });
    }

    interface FirstFragmentListener {

        void counterResult(int count);
    }
}
