package com.example.tewotv0.CustomInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.tewotv0.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CWadapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private Context context;

    public CWadapter(Context context) {
        this.context = context;
        this.mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info, null);
    }

    private void renderWindowText(Marker marker, View view) {
        String title = marker.getTitle();
        TextView tvTitle = view.findViewById(R.id.markerTitel);

        if (!title.equals("")) {
            tvTitle.setText(title);
        }

        String snipped = marker.getSnippet();
        TextView tvSnipped = view.findViewById(R.id.snipped);

        if (!snipped.equals("")) {
            tvSnipped.setText(snipped);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }
}
