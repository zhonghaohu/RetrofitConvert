package com.zhonghao.retrofitconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private String jsonUser = "{\n" +
            "    \"age\": 10,\n" +
            "    \"name\": \"张三\"\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void invoke(View view) {

        MyRetrofit retrofit = new MyRetrofit();
        TestService testService = retrofit.create(TestService.class);
        Call<User> call = testService.getUser(jsonUser);
        call.enqueue(new Callback<User>() {
            @Override
            public void onSuccess(User user) {
                Toast.makeText(getApplicationContext(), user.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
