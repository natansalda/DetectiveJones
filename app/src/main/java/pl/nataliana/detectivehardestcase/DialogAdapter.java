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

    private Context mContext;
    private List<Dialog> dialogList = new ArrayList<>();

    public DialogAdapter(@NonNull Context context, ArrayList<Dialog> list) {
        super(context, 0 , list);
        mContext = context;
        dialogList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.dialog_list_item,parent,false);

        Dialog currentDialog = dialogList.get(position);

        ImageView image = (ImageView)listItem.findViewById(R.id.face_iv);
        image.setImageResource(currentDialog.getmImageDrawable());

        TextView name = (TextView) listItem.findViewById(R.id.name_tv);
        name.setText(currentDialog.getmName());

        TextView release = (TextView) listItem.findViewById(R.id.dialog_tv);
        release.setText(currentDialog.getmText());

        return listItem;
    }
}
