package com.example.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    AdapterDanhBa adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lvdanhba);
        final ArrayList<DanhBa> arrdanhba = new ArrayList<>();

        DanhBa c1 = new DanhBa("Liên hệ 1", "0763865276", Color.RED);
        DanhBa c2 = new DanhBa("Liên hệ 2", "0763865275", Color.YELLOW);
        DanhBa c3 = new DanhBa("Liên hệ 3", "0763865274", Color.BLUE);
        DanhBa c4 = new DanhBa("Liên hệ 4", "0763865273", Color.WHITE);
        DanhBa c5 = new DanhBa("Liên hệ 5", "0763865272", Color.BLACK);

        arrdanhba.add(c1);
        arrdanhba.add(c2);
        arrdanhba.add(c3);
        arrdanhba.add(c4);
        arrdanhba.add(c5);

        adapterDanhBa = new AdapterDanhBa(this, R.layout.list_danhba, arrdanhba);
        listView.setAdapter(adapterDanhBa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+arrdanhba.get(position).getHoten(), Toast.LENGTH_SHORT).show();

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Question(arrdanhba,position);
                return false;
            }
        });


    }
    public  void Question(final ArrayList<DanhBa> arrayList, final int vt){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Cảnh báo");
        builder.setMessage("Bạn có thật sự muốn xóa ?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayList.remove(vt);
                adapterDanhBa.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }

}
