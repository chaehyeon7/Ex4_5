package kr.hs.emirim.chaehyeon.ex4_5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        edtItem = findViewById(R.id.edit_item);
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
                edtItem.setText("");
            }
        });
        list1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialg = new AlertDialog.Builder(MainActivity.this);
                dialg.setTitle("삭제여부 확인");
//                dialg.setIcon(R.drawable.delete);
                dialg.setMessage("정말로 삭제하시겠습니까?");
                dialg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrList.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialg.setNegativeButton("취소", null);
                dialg.show();
                return false;
            }
        });
    }
}