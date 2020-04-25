package com.example.checnutritionapp.ui.user_profile;

import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.checnutritionapp.MainActivity;
import com.example.checnutritionapp.R;
import com.example.checnutritionapp.model.User;
import com.example.checnutritionapp.utility.UserSet;

public class UserProfileFragment extends Fragment {

    private UserProfileViewModel userProfileViewModel;

    private String Name;
    private String job;
    private String occ;
    private int fam;
    private String Fam;
    private int age;
    private String Age;
    private double bmi;
    private String BMI;
    private int foot;
    private int inch;
    private String height;
    private double lbs;
    private String weight;
    private int fbg;
    private String FBG;
    private double a1c;
    private String A1C;
    private int cholest;
    private String Cholest;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MainActivity mainActivity = (MainActivity) getActivity();
        User user = mainActivity.getCurrentUser();
        Name="Percy Jackson";

        job="Hero";

        occ="Occupation: "+job;

        fam=5;

        Fam="Family Size: "+fam;

        age=16;

        Age="Age: "+age;

        foot=5;

        inch=4;

        height=foot+"\'"+inch+"\"";

        lbs=130.01;

        weight=lbs+" lbs";

        bmi=(lbs/((foot*12+inch)*(foot*12+inch)))*703;

        BMI="BMI: "+ String.format("%.1f",bmi);

        fbg=108;

        FBG="FBG: "+fbg+" mg/dl";

        a1c=(46.7+fbg)/28.7;

        A1C="A1C: "+String.format("%.1f",a1c);

        cholest=150;

        Cholest="Cholesterol: "+cholest+" mg/dl";







        TextView name=getView().findViewById(R.id.textView8);

        TextView o=getView().findViewById(R.id.textView11);

        TextView f=getView().findViewById(R.id.textView12);

        TextView a=getView().findViewById(R.id.textView5);

        TextView b=getView().findViewById(R.id.textView7);

        TextView h=getView().findViewById(R.id.textView10);

        TextView fb=getView().findViewById(R.id.textView13);

        TextView a1=getView().findViewById(R.id.textView14);

        TextView l=getView().findViewById(R.id.textView17);

        TextView c=getView().findViewById(R.id.textView16);

        ImageView image =getView().findViewById(R.id.imageView3);

        name.setText(user.getFullName());

        o.setText(user.getOccupation());

      f.setText(Integer.toString(user.getFamilyCount()));

        a.setText(user.getAge());

        b.setText(BMI);

        h.setText(user.getHeight());

       fb.setText(Integer.toString(user.getGlucose()));

        a1.setText(A1C);

        l.setText(user.getWeight());

       c.setText(Integer.toString(user.getCholesterol()));

        image.setImageResource(R.drawable.percyjackson);

    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        userProfileViewModel =
               ViewModelProviders.of(this).get(UserProfileViewModel.class);


        View root = inflater.inflate(R.layout.fragment_user_profile, container, false);
       // final TextView textView = root.findViewById(R.id.text_user_profile);
        //userProfileViewModel.getText().observe(this, new Observer<String>() {
            //@Override
           // public void onChanged(@Nullable String s) {
          //      textView.setText(s);
            //}
        //});


        return root;
    }
}