package com.mrsyafapri.opensapp.hospital;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EkaHospital extends ListActivity {
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
                String telephone = "tel:(0761) 6989999";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(telephone));
            } else if ("SMS Center".equals(pilihan)) {
                String smsText = "Daftar Antrian a/n Muhammad Rizki Syafapri";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:(0761) 6989999"));
                a.putExtra("sms_body", smsText);
            } else if ("Driving Direction".equals(pilihan)) {
                String location = "https://maps.app.goo.gl/q8DHoTGP2GQpiT9SA";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
            } else if ("Website".equals(pilihan)) {
                String website = "https://www.ekahospital.com/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            } else if ("Info Google".equals(pilihan)) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY, "Rumah Sakit Eka Hospital Pekanbaru");
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
