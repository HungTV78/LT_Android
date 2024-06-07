package com.example.ktl1_may14_letanhung_st4;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentInfoFragment extends Fragment {

    private TextView mssvTextView;
    private TextView fullNameTextView;
    private TextView classCodeTextView;
    private ImageView studentImageView;

    public StudentInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        // Initialize views
        mssvTextView = view.findViewById(R.id.text_mssv);
        fullNameTextView = view.findViewById(R.id.text_full_name);
        classCodeTextView = view.findViewById(R.id.text_class_code);
        studentImageView = view.findViewById(R.id.image_student);

        mssvTextView.setText("MSSV: 2001210520");
        fullNameTextView.setText("Họ và tên: Lê Tấn Hưng ");
        classCodeTextView.setText("Lớp: 12DHTH04");
        studentImageView.setImageResource(R.drawable.avt);

        return view;
    }
}