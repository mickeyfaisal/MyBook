package com.dev;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WelcomeFragment extends Fragment {

    View view;
    TextView text_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getChildFragmentManager();
        view = inflater.inflate(R.layout.include_fragment_layout,container,false);
        view.setRotationY(180);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        getChildFragmentManager();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeComponents();
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    public void initializeComponents() {
        text_view = getView().findViewById(R.id.text_view);
        text_view.setText(R.string.text_welcome);
    }
}
