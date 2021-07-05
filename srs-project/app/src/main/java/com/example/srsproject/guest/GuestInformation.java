package com.example.srsproject.guest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.srsproject.R;
import com.example.srsproject.room.RoomBooking;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuestInformation extends AppCompatActivity {

    String selectedTitle, selectedGender, selectedCountry, purpose;
    RadioGroup radioGroup;
    RadioButton radioButton;
    JsonApi jsonApi;
    Button buttonSubmit;

    EditText editTextFirstName, editTextMiddleInitial, editTextLastName, editTextEmail;
    EditText editTextCompanyName, editTextAddress, editTextCity, editTextPostalCode;
    EditText editTextTelephone, editTextMobilePhone, editTextComments;
    CheckBox checkBoxCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_information);

        Spinner titleDropDown = findViewById(R.id.title_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.titles, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        titleDropDown.setAdapter(arrayAdapter);
        titleDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTitle = parent.getItemAtPosition(position).toString();
                System.out.println("title: " + selectedTitle);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner genderDropDown = findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderDropDown.setAdapter(genderAdapter);
        genderDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedGender = parent.getItemAtPosition(position).toString();
                System.out.println("gender: " + selectedGender);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner countryDropDown = findViewById(R.id.spinner_country);
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryDropDown.setAdapter(countryAdapter);
        countryDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountry = parent.getItemAtPosition(position).toString();
                System.out.println("country: " + selectedCountry);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup = findViewById(R.id.radio_group);


        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonApi = retrofit.create(JsonApi.class);

        editTextFirstName = findViewById(R.id.edittext_firstname);
        editTextLastName = findViewById(R.id.edittext_lastname);
        editTextMiddleInitial = findViewById(R.id.edittext_middleinitial);
        editTextEmail = findViewById(R.id.edittext_emailaddress);

        editTextCompanyName = findViewById(R.id.edittext_companyname);
        editTextAddress = findViewById(R.id.edittext_filloutaddress);
        editTextCity = findViewById(R.id.edittext_city);
        editTextPostalCode = findViewById(R.id.edittext_postalcode);

        editTextTelephone = findViewById(R.id.edittext_telephone);
        editTextMobilePhone = findViewById(R.id.edittext_mobilephone);
        editTextComments = findViewById(R.id.edittext_comments);
        checkBoxCreateAccount = findViewById(R.id.checkbox_createaccount);

        buttonSubmit = findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGuestInfo();
                startActivity(new Intent(GuestInformation.this, RoomBooking.class));
                finish();
            }
        });

    }

    public void checkRadio(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        purpose = radioButton.getText().toString();
    }

    private void createGuestInfo() {
        Map<String, String> fields = new HashMap<>();
        String firstName = editTextFirstName.getText().toString();
        String middleInitial = editTextMiddleInitial.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();

        String companyName = editTextCompanyName.getText().toString();
        String address = editTextAddress.getText().toString();
        String city = editTextCity.getText().toString();
        String postalCode = editTextPostalCode.getText().toString();

        String telephone = editTextTelephone.getText().toString();
        String mobilePhone = editTextMobilePhone.getText().toString();

        String createAnAccount = checkBoxCreateAccount.isChecked() ? "true" : "false";
        String comments = editTextComments.getText().toString();

        fields.put("title", selectedTitle);
        fields.put("country", selectedCountry);
        fields.put("gender", selectedGender);

        fields.put("firstName", firstName);
        fields.put("middleInitial", middleInitial);
        fields.put("lastName", lastName);
        fields.put("email", email);

        fields.put("companyName", companyName);
        fields.put("address", address);
        fields.put("city", city);
        fields.put("postalCode", postalCode);

        fields.put("telephone", telephone);
        fields.put("mobilePhone", mobilePhone);
        fields.put("createAnAccount", createAnAccount);
        if (purpose != null) {
            fields.put("purpose", purpose);
        }
        fields.put("comments", comments);

        Call<GuestInfo> call = jsonApi.createPost(fields);
        call.enqueue(new Callback<GuestInfo>() {
            @Override
            public void onResponse(Call<GuestInfo> call, Response<GuestInfo> response) {
                if (!response.isSuccessful()) {
                    System.out.println("code" + response.code());
                    return;
                }
                GuestInfo body = response.body();
                String content = response.code() + "\n"
                        + "id: " + body.getId() + "\n"
                        + "title: " + body.getTitle() + "\n"
                        + "country: " + body.getCountry() + "\n"
                        + "gender: " + body.getGender() + "\n"
                        + "firstName: " + body.getFirstName() + "\n"
                        + "middleInitial: " + body.getMiddleInitial() + "\n"
                        + "lastName: " + body.getLastName() + "\n"
                        + "email: " + body.getEmail() + "\n"
                        + "companyName: " + body.getCompanyName() + "\n"
                        + "address: " + body.getAddress() + "\n"
                        + "city: " + body.getCity() + "\n"
                        + "postalCode: " + body.getPostalCode() + "\n"
                        + "telephone: " + body.getTelephone() + "\n"
                        + "mobilePhone: " + body.getMobilePhone() + "\n"
                        + "createAnAccount: " + body.isCreateAnAccount() + "\n"
                        + "purpose: " + body.getPurpose() + "\n"
                        + "comments: " + body.getComments() + "\n\n";
                System.out.println("content: " + content);
            }

            @Override
            public void onFailure(Call<GuestInfo> call, Throwable t) {
                System.out.println("failure message: " + t.getMessage());
            }
        });
    }
}