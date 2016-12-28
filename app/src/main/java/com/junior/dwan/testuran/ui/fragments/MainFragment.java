package com.junior.dwan.testuran.ui.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.junior.dwan.testuran.R;
import com.junior.dwan.testuran.data.Controller;
import com.junior.dwan.testuran.data.Model;
import com.junior.dwan.testuran.utils.DBUtils;
import com.junior.dwan.testuran.utils.GenerateData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Might on 28.12.2016.
 */

public class MainFragment extends ListFragment {
    ArrayList<Model> mListModel;
    Controller mController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        mController=Controller.getInstance(getActivity());
        mListModel =mController.getListModels(getActivity());
        setupAdapterforList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setupAdapterforList() {
        ModelAdapter adapter = new ModelAdapter(mListModel);
        setListAdapter(adapter);
    }


    private class ModelAdapter extends ArrayAdapter<Model> {
        public ModelAdapter(ArrayList<Model> models) {
            super(getActivity(), 0, models);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item, null);
            registerForContextMenu(convertView);
            Model model = getItem(position);

            View colorBarOrange = convertView.findViewById(R.id.colorLeftBarOrange);
            View colorBarBlue = convertView.findViewById(R.id.colorLeftBarBlue);
            if (model.isBlue() && !model.isOrange()) {
                colorBarOrange.setVisibility(View.GONE);
                colorBarBlue.setVisibility(View.VISIBLE);
            } else if (!model.isBlue() && model.isOrange()) {
                colorBarOrange.setVisibility(View.VISIBLE);
                colorBarBlue.setVisibility(View.GONE);
            } else if (model.isOrange() && model.isBlue()) {
                colorBarOrange.setVisibility(View.VISIBLE);
                colorBarBlue.setVisibility(View.VISIBLE);
            } else if (!model.isOrange() && !model.isBlue()) {
                colorBarOrange.setVisibility(View.GONE);
                colorBarBlue.setVisibility(View.GONE);
            }

            ImageView imgType = (ImageView) convertView.findViewById(R.id.type_imageView);
            model.checkFileType();

            if (model.checkFileType().equals("image")) {
                imgType.setBackground(getResources().getDrawable(R.drawable.ic_photo_size_select_actual_black_24dp));
            } else if (model.checkFileType().equals("doc")) {
                imgType.setBackground(getResources().getDrawable(R.drawable.ic_insert_drive_file_black_24dp));
            } else if (model.checkFileType().equals("none")) {
                imgType.setBackground(getResources().getDrawable(R.drawable.ic_folder_black_24dp));
            }

            TextView tvtitle = (TextView) convertView.findViewById(R.id.list_title);
            tvtitle.setText(model.getFilename());

            TextView tvDate = (TextView) convertView.findViewById(R.id.list_date);
            SimpleDateFormat sdf;
            sdf = new SimpleDateFormat("MMMM d, yyyy");
            String format = sdf.format(model.getModDate());
            String dateString = "modified " + format;
            tvDate.setText(dateString);

            return convertView;
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Model model = ((ModelAdapter) getListAdapter()).getItem(position);
        if (!model.isFolder()) {
            Log.i("TAG", "was clicked " + model.getFilename());
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuBuilder menuBuilder = new MenuBuilder(getActivity());
        MenuInflater inflater = new MenuInflater(getActivity());
        inflater.inflate(R.menu.popup_menu, menuBuilder);
        MenuPopupHelper optionsMenu = new MenuPopupHelper(getActivity(), menuBuilder, v);
        optionsMenu.setForceShowIcon(true);


        optionsMenu.show(250, 0);


    }
}
