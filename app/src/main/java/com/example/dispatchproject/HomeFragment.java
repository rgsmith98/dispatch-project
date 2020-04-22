package com.example.dispatchproject;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View RootView = inflater.inflate(R.layout.home_fragment, container, false);

        TableLayout table = (TableLayout)RootView.findViewById(R.id.order_list_table);

        String headingFields[] = {"Sr.No.", "Customer", "Part Name", "Part No.", "Department", "Output Stock", "Date", "Total", "Balance"};
        String data1[][] = {{"1", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"},{"2", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"},{"3", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"},{"4", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"},{"5", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"},{"6", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"},{"7", "Customer 1", "Part 1", "ABCD-123", "Production", "200", "14-4-2020", "150", "50"}};
        TableRow tmp_tr = new TableRow(getContext());
        for(int k=0;k<=8;k++){

            tmp_tr.setPadding(0,0,0,5);

            TableRow.LayoutParams llp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0,0,2,5);

            RelativeLayout cell = new RelativeLayout(getContext());
            cell.setBackgroundColor(Color.parseColor("#045263"));
            cell.setLayoutParams(llp);
            cell.setPadding(0,0,0,5);

            TextView tv = new TextView(getContext());

            tv.setText(" "+headingFields[k]+"  ");
            tv.setTextColor(Color.WHITE);
            tv.setPadding(0,0,4,3);
            tv.setTextSize(18);

            Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.open_sans);
            tv.setTypeface(typeface);

            cell.addView(tv);
            tmp_tr.addView(cell);
        }

        table.addView(tmp_tr);

        for(int i=0;i<=6;i++)
        {
            TableRow tr = new TableRow(getContext());

            //tr.setBackgroundColor(Color.BLACK);
            tr.setPadding(0,0,0,5);

            TableRow.LayoutParams llp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
            llp.setMargins(0,0,2,5);

            for(int j=0;j<data1[i].length;j++)
            {
                RelativeLayout cell = new RelativeLayout(getContext());
                cell.setBackgroundColor(Color.parseColor("#ebebeb"));
                cell.setLayoutParams(llp);
                cell.setPadding(0,0,0,5);

                TextView tv = new TextView(getContext());

                tv.setText(" "+data1[i][j]+"  ");
                tv.setTextColor(Color.parseColor("#0783e6"));
                tv.setPadding(0,0,4,3);
                tv.setTextSize(15);

                Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.open_sans);
                tv.setTypeface(typeface);

                cell.addView(tv);
                tr.addView(cell);
            }


            table.addView(tr);
        }


        return RootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Dashboard");
    }
}
