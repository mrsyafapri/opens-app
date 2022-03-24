package com.mrsyafapri.opensapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mrsyafapri.opensapp.hospital.*;

public class Hospital extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listHospital = {
                "RS Awal Bros",
                "RS Eka Hospital",
                "RSUD Arifin Ahmad",
                "RSJ Tampan",
                "RS Tabrani"
        };
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listHospital));
    }

    protected void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        Object item = this.getListAdapter().getItem(position);
        String pilihan = item.toString();
        showPilihan(pilihan);
    }

    private void showPilihan(String pilihan) {
        try {
            Intent a = null;
            if ("RS Awal Bros".equals(pilihan)) {
                a = new Intent(this, AwalBross.class);
            } else if (pilihan.equals("RS Eka Hospital")) {
                a = new Intent(this, EkaHospital.class);
            } else if ("RSUD Arifin Ahmad".equals(pilihan)) {
                a = new Intent(this, ArifinAchmad.class);
            } else if ("RSJ Tampan".equals(pilihan)) {
                a = new Intent(this, Tampan.class);
            } else if ("RS Tabrani".equals(pilihan)) {
                a = new Intent(this, Tabrani.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
