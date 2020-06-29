package com.example.myapplication_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


// 하단 메뉴바 메소드에 필요한 변수 선언
    private BottomNavigationView mBottomNV;


//// 원형 차트 변수 선언
//// 예시로 만들어 보기 위해 데이터 직접 입력
//// **그래프 코드 분석 완료되고 디비 연결하면 입력 데이터에 의해 변경되게 다시 코딩
//    AnyChartView anyChartView;
//
//    String[] meals = {"아침", "점심", "저녁", "간식", ""};
//    int[] calories = {200, 500, 250, 450, 100};
//
//// 막대 차트 변수 선언
//// 예시로 만들어 보기 위해 데이터 직접 입력
//// **그래프 코드 분석 완료되고 디비 연결하면 입력 데이터에 의해 변경되게 다시 코딩
//    BarChart stackedChart;
//    int[] colorArray = new int[]{Color.rgb(114, 80, 201)};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//하단 메뉴바 설정한거 ID로 연결
        mBottomNV = findViewById(R.id.nav_view);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());

                return true;
            }
        });
        mBottomNV.setSelectedItemId(R.id.home);



//    // 원형 차트
//        anyChartView = findViewById(R.id.any_chart_view);
//        setupPieChart();
//
//    // 막대 차트
//        stackedChart = findViewById(R.id.stacked_barChart);
//
//        BarDataSet barDataSet = new BarDataSet(dataValues1(), "Bar Set");
//        barDataSet.setColors(colorArray);
//
//        BarData barData = new BarData(barDataSet);
//        stackedChart.setData(barData);


    }


//BottomNavigation 페이지 변경하는 메소드
    private void BottomNavigate(int id){
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if(currentFragment != null){
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if(fragment == null){
            if(id == R.id.home){
                fragment = new FragmentHome();
            } else if (id == R.id.recommend){
                fragment = new FragmentRecommend();
            } else if (id == R.id.calendar){
                fragment = new FragmentCalendar();
            } else {
                fragment = new FragmentMyPage();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();
    }

//    // 원형차트 데이터 입력
//    // 현재 직접 입력한 데이터 넣어주는 형식
//    // 추후에 자동 입력되게 다시 코딩
//    public void setupPieChart() {
//        Pie pie = AnyChart.pie();
//        List<DataEntry> dataEntries = new ArrayList<>();
//
//        for (int i = 0; i < meals.length; i++) {
//            dataEntries.add(new ValueDataEntry(meals[i], calories[i]));
//        }
//
//        pie.data(dataEntries);
//        anyChartView.setChart(pie);
//    }
//
//    // 막대 차트 데이터 입력
//    // 현재 직접 입력한 데이터 넣어주는 형식
//    // 추후에 자동 입력되게 다시 코딩
//    private ArrayList<BarEntry> dataValues1() {
//        ArrayList<BarEntry> dataVals = new ArrayList<>();
//
//        dataVals.add(new BarEntry(0, new float[]{2, 5.5f, 4}));
//        dataVals.add(new BarEntry(1, new float[]{2, 8f, 4.2f}));
//        dataVals.add(new BarEntry(2, new float[]{3, 5.5f, 4}));
//        dataVals.add(new BarEntry(3, new float[]{4, 6.5f, 4}));
//        dataVals.add(new BarEntry(4, new float[]{2, 5.5f, 3.3f}));
//
//        return dataVals;
//    }


}
