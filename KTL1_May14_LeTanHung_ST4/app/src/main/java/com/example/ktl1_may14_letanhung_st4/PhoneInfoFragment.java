package com.example.ktl1_may14_letanhung_st4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PhoneInfoFragment extends Fragment {
    private ListView phoneListView;
    private ArrayList<Flag> flagList;
    private Spinner manufacturerSpinner;
    private EditText searchEditText;
    private Button searchButton;
    private ArrayList<Phone> phoneList;
    private ArrayAdapter<String> adapter;

    public PhoneInfoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_phone_info, container, false);
        phoneListView = rootView.findViewById(R.id.phone_list_view);
        manufacturerSpinner = rootView.findViewById(R.id.continent_spinner);
        searchEditText = rootView.findViewById(R.id.search_edit_text);
        searchButton = rootView.findViewById(R.id.btn_Search);

        setupSpinner();

        try {
            phoneList = loadJsonCS();
            showAllPhones();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        flagList = Flag.initFlag();

        FlagAdapter flagAdapter = new FlagAdapter(getContext(), flagList);
        phoneListView.setAdapter(flagAdapter);

        phoneListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Phone selectedPhone = phoneList.get(position);
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra("selectedPhone", selectedPhone);
                startActivity(intent);
            }
        });

        phoneListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showDeleteConfirmationDialog(position);
                return true;
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });

        return rootView;
    }

    public ArrayList<Phone> loadJsonCS() throws IOException, JSONException {
        ArrayList<Phone> phoneList = new ArrayList<>();
        InputStream inputStream = getResources().getAssets().open("dssp.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder jsonString = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonString.append(line);
        }
        reader.close();
        inputStream.close();

        JSONObject jsonObject = new JSONObject(jsonString.toString());
        JSONArray jsonArray = jsonObject.getJSONArray("phones");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject phoneObject = jsonArray.getJSONObject(i);
            String name = phoneObject.getString("name");
            String manufacturer = phoneObject.getString("manufacturer");
            int year = phoneObject.getInt("year");
            String price = phoneObject.getString("price");
            int img = phoneObject.getInt("image");

            Phone phone = new Phone(name, manufacturer, year, price, img);
            phoneList.add(phone);
        }

        return phoneList;
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.phones_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        manufacturerSpinner.setAdapter(spinnerAdapter);

        manufacturerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedManufacturer = parent.getItemAtPosition(position).toString();
                if (selectedManufacturer.equals(getString(R.string.all))) {
                    showAllPhones();
                } else {
                    filterPhonesByManufacturer(selectedManufacturer);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void showAllPhones() {
        ArrayList<String> allPhones = new ArrayList<>();
        for (Phone phone : phoneList) {
            allPhones.add(formatPhoneInfo(phone));
        }
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, allPhones);
        phoneListView.setAdapter(adapter);
    }

    private void filterPhonesByManufacturer(String manufacturer) {
        if (phoneList != null) {
            ArrayList<String> filteredPhones = new ArrayList<>();
            for (Phone phone : phoneList) {
                if (phone.getManufacturer().equals(manufacturer)) {
                    filteredPhones.add(formatPhoneInfo(phone));
                }
            }
            adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, filteredPhones);
            phoneListView.setAdapter(adapter);
        }
    }

    private void performSearch() {
        String searchText = searchEditText.getText().toString().trim().toLowerCase();
        if (phoneList != null && !searchText.isEmpty()) {
            ArrayList<Phone> searchResult = new ArrayList<>();
            for (Phone phone : phoneList) {
                if (phone.getName().toLowerCase().contains(searchText)) {
                    searchResult.add(phone);
                }
            }
            if (searchResult.size() > 0) {
                displaySearchResult(searchResult);
            } else {
                Toast.makeText(getContext(), "Không có sản phẩm này", Toast.LENGTH_SHORT).show();
                showAllPhones();
            }
        } else {
            Toast.makeText(getContext(), "Vui lòng nhập tên sản phẩm", Toast.LENGTH_SHORT).show();
        }
    }

    private void displaySearchResult(ArrayList<Phone> searchResult) {
        ArrayList<String> resultStrings = new ArrayList<>();
        for (Phone phone : searchResult) {
            resultStrings.add(formatPhoneInfo(phone));
        }
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, resultStrings);
        phoneListView.setAdapter(adapter);
    }

    private String formatPhoneInfo(Phone phone) {
        return phone.getName() + " - " + phone.getManufacturer() + " - " + phone.getYear() + " - " + phone.getPrice();
    }

    private void showDeleteConfirmationDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage("Bạn có muốn xóa sản phẩm này?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deletePhone(position);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void deletePhone(int position) {
        if (phoneList != null && position >= 0 && position < phoneList.size()) {
            phoneList.remove(position);
            adapter.notifyDataSetChanged();
        }
    }
}
