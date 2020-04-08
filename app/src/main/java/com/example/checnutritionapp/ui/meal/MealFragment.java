package com.example.checnutritionapp.ui.meal;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.checnutritionapp.MealAllergensFragment;
import com.example.checnutritionapp.MealNutrition;
import com.example.checnutritionapp.MealProcedureFragment;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.Meal;

public class MealFragment extends Fragment {

    private MealViewModel mViewModel;

    public static MealFragment newInstance() {
        return new MealFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Handling meal object
        final Bundle b = this.getArguments();
        Meal m = (Meal) b.getSerializable("meal");
        System.out.println(m.getName() + " -- in Meal Fragment");

        View v = inflater.inflate(R.layout.meal_fragment, container, false);

        TextView title = (TextView) v.findViewById(R.id.textView6);
        title.setText(m.getName());

        Button openNutFacts = (Button) v.findViewById(R.id.nut_button);
        openNutFacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealNutrition nutritionFragment = new MealNutrition();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.meal_layout, nutritionFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        Button openProcedure = (Button) v.findViewById(R.id.proc_button);
        openProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealProcedureFragment procFragment = new MealProcedureFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.meal_layout, procFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        Button openAllergens = (Button) v.findViewById(R.id.allergen_button);
        openAllergens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MealAllergensFragment allergenFragment = new MealAllergensFragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(R.id.meal_layout, allergenFragment);
                trans.addToBackStack(null);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MealViewModel.class);
        // TODO: Use the ViewModel
    }

}
