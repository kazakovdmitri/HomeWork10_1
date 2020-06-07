package com.kazakovdmitri.homework10_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String ATRIBUTE_NAME_ONE = "one";
    private static final String ATRIBUTE_NAME_TWO = "two";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        String[] from = {ATRIBUTE_NAME_ONE, ATRIBUTE_NAME_TWO};
        int[] to = {R.id.tv_one, R.id.tv_two};
        return new SimpleAdapter(this, values, R.layout.list_item, from, to);
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        String[] strings = getString(R.string.large_text).split("\n\n");
        List<Map<String, String>> list = new ArrayList<>();
        for (String str : strings) {
            Map<String, String> map = new HashMap<>();
            map.put(ATRIBUTE_NAME_ONE, str.length() + "");
            map.put(ATRIBUTE_NAME_TWO, str);
            list.add(map);
        }
        return list;
    }
}
