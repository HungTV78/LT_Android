package com.example.lab8_letanhung_2001210520;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainActivity extends AppCompatActivity {
    private EditText edtName, edtClass;
    private TextView txtStudentInfo;
    private Button btnAddStudent, btnShowStudents;

    private ArrayList<Student> studentList;
    private String fileName = "students.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtClass = findViewById(R.id.edtClass);
        txtStudentInfo = findViewById(R.id.txtStudentInfo);
        btnAddStudent = findViewById(R.id.btnAddStudent);
        btnShowStudents = findViewById(R.id.btnShowStudents);

        studentList = new ArrayList<>();

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudent();
            }
        });

        btnShowStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showStudents();
            }
        });

        loadStudentsFromFile();
        updateStudentCount();
    }

    private void addStudent() {
        String name = edtName.getText().toString();
        String className = edtClass.getText().toString();
        Student student = new Student(name, className);
        studentList.add(student);
        saveStudentsToFile();
        updateStudentCount();
        edtName.setText("");
        edtClass.setText("");
    }

    private void showStudents() {
        StringBuilder builder = new StringBuilder();
        for (Student student : studentList) {
            builder.append("Name: ").append(student.getName()).append("\n");
            builder.append("Class: ").append(student.getClassName()).append("\n\n");
        }
        txtStudentInfo.setText(builder.toString());
    }


    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilesDir() + "/" + fileName))) {
            for (Student student : studentList) {
                writer.write(student.getName() + "," + student.getClassName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStudentsFromFile() {
        try (Scanner scanner = new Scanner(openFileInput(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Student student = new Student(parts[0], parts[1]);
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStudentCount() {
        txtStudentInfo.setText("Total students: " + studentList.size());
    }
}