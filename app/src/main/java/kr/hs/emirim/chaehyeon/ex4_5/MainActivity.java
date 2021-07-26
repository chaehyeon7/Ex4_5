package kr.hs.emirim.chaehyeon.ex4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> arrList;
    ArrayAdapter<String> adapter;
    EditText edtItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrList = new ArrayList<String>();
        ListView list1 = findViewById(R.id.list1);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrList);
        list1.setAdapter(adapter);
        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}