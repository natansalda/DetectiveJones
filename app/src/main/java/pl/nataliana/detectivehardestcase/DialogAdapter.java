package pl.nataliana.detectivehardestcase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DialogAdapter extends ArrayAdapter<Dialog> {
    //TODO: check the code below and add coments

    public DialogAdapter(Context context, ArrayList<Dialog> proofsData) {
        super(context, 0 , proofsData);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.dialog_list_item,parent,false);

        Dialog currentDialog = getItem(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.face_iv);
        image.setImageResource(currentDialog.getmImageDrawable());

        TextView name = (TextView) listItem.findViewById(R.id.name_tv);
        name.setText(currentDialog.getmName());

        TextView dialog = (TextView) listItem.findViewById(R.id.dialog_tv);
        dialog.setText(currentDialog.getmText());

        return listItem;
    }
}
