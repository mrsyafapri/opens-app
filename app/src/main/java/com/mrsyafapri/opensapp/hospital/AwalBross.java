package com.mrsyafapri.opensapp.hospital;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AwalBross extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listMenu = {
                "Call Center",
                "SMS Center",
                "Driving Direction",
                "Website",
                "Info Google",
                "Exit"
        };
        this.setListAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listMenu));
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
            if ("Call Center".equals(pilihan)) {
                String telephone = "tel:(0761) 47333";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(telephone));
            } else if ("SMS Center".equals(pilihan)) {
                String smsText = "Daftar Antrian a/n Muhammad Rizki Syafapri";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:076147333"));
                a.putExtra("sms_body", smsText);
            } else if ("Driving Direction".equals(pilihan)) {
                String location = "google.navigation:q=0.463823,101.390353";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
            } else if ("Website".equals(pilihan)) {
                String website = "https://haloawalbros.com/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            } else if ("Info Google".equals(pilihan)) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Awal Bros Pekanbaru");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
