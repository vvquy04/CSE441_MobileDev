package com.example.lesson1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnClickMe;
    private TextView txtGreeting;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main); //thiết lập layout để hiển thị
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Tham chiếu đến phần tử giao diện
        btnClickMe = (Button) findViewById(R.id.btn_clickme);
        txtGreeting = (TextView) findViewById(R.id.txt_greeting);

        // Bắt sự kiện
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nội dung sự kiện
                String greeting = txtGreeting.getText().toString();
                Toast.makeText(getApplicationContext(), "noi dung hien thi la " + greeting, Toast.LENGTH_SHORT).show();
                txtGreeting.setText("hehehee");
            }
        });

    }
}