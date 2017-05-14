package com.nstu.fami.lab8;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {

    final String[] catNamesArray = new String[] {
            "Рыжик", "Барсик", "Мурзик",
            "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок",
            "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба"
    };

    private String[] mMonthArray = { "Январь", "Февраль", "Март", "Апрель", "Май",
            "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь",
            "Декабрь" };

    private String[] mDayOfWeekArray = new String[] { "Понедельник", "Вторник", "Среда",
            "Четверг", "Пятница", "Суббота", "Воскресенье" };

    // Создадим два адаптера
    private ArrayAdapter<String> mMonthAdapter, mWeekOfDayAdapter;
    private String mMonth, mDayOfWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMonthAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mMonthArray);
        mWeekOfDayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDayOfWeekArray);

        setListAdapter(mMonthAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if (getListAdapter() == mMonthAdapter) {
            mMonth = (String) l.getItemAtPosition(position);
            setListAdapter(mWeekOfDayAdapter);
            mWeekOfDayAdapter.notifyDataSetChanged();
        } else {
            mDayOfWeek = (String) l.getItemAtPosition(position);
            Toast.makeText(getBaseContext(), mMonth + ": " + mDayOfWeek,
                    Toast.LENGTH_LONG).show();
            setListAdapter(mMonthAdapter);
            mMonthAdapter.notifyDataSetChanged();
        }

    }
}
