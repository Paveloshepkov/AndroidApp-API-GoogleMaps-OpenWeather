package com.example.tewotv0.Activity;

import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.example.tewotv0.models.weatherModels.forecastModels.ForecastWeatherModel;
import com.example.tewotv0.models.weatherModels.forecastModels.WeatherDay;
import com.example.tewotv0.R;
import com.squareup.picasso.Picasso;
import java.util.Calendar;

public class ForecastActivity extends AppCompatActivity {

    private TableLayout table;

    private TableRow firstRow;
    private TableRow secondRow;
    private TableRow lastRow;

    private static ForecastWeatherModel forecastWeatherModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.forecast_activity);

        initTable();

        this.setContentView(table);
    }

    private void initTable() {
        firstRow = new TableRow(this);
        secondRow = new TableRow(this);
        lastRow = new TableRow(this);

        table = new TableLayout(this);
        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);

        initRowsTitle();
        initFirstColumn();
    }

    private void initRowsTitle() {
        TextView title = new TextView(this);
        title.setText("Погода на 5 дней");

        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 6;

        TableRow rowTitle = new TableRow(this);
        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        rowTitle.addView(title, params);
        table.addView(rowTitle);
    }

    private void initFirstColumn() {
        firstRow.addView(getNewTextView("Дата"));
        secondRow.addView(getNewTextView("Погода"));
        lastRow.addView(getNewTextView("Иконка"));

        setDateInTable();
        setTemperature();
        setLogoInTable();

        table.addView(firstRow);
        table.addView(secondRow);
        table.addView(lastRow);
    }

    private void setLogo(String logoPath, ImageView imageView) {
        Picasso.with(this).load(logoPath).into(imageView);
    }

    private TextView getNewTextView(String text) {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        return textView;
    }

    private void setDateInTable() {
        for (WeatherDay weatherDay : forecastWeatherModel.getItems()) {
            firstRow.addView(getNewTextView(String.valueOf(weatherDay.getDate().get(Calendar.DAY_OF_MONTH))));
        }
    }

    private void setTemperature() {
        for (WeatherDay weatherDay : forecastWeatherModel.getItems()) {
            secondRow.addView(getNewTextView(String.valueOf(weatherDay.getTemp())));
        }
    }

    private void setLogoInTable() {
        for (WeatherDay weatherDay: forecastWeatherModel.getItems()) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = 100;
            params.leftMargin = 100;
            lastRow.addView(imageView);
            setLogo(weatherDay.getIconUrl(), imageView);
        }
    }

    public static void setForecastWeatherModel(ForecastWeatherModel list) {
        forecastWeatherModel = list;
    }
}
