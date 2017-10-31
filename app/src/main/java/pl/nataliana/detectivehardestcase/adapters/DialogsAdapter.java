package pl.nataliana.detectivehardestcase.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.nataliana.detectivehardestcase.Dialog;
import pl.nataliana.detectivehardestcase.R;

public class DialogsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Dialog> dialogs;

    public DialogsAdapter(List<Dialog> dialogs) {
        this.dialogs = dialogs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_list_item, parent, false);
        return new DialogRowHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((DialogRowHolder) holder).setDialog(dialogs.get(position));
    }

    public void addDialog(Dialog dialog) {
        dialogs.add(dialog);
        notifyItemInserted(dialogs.size()-1);
    }

    @Override
    public int getItemCount() {
        return dialogs.size();
    }

    public class DialogRowHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.face_iv)
        ImageView faceImageView;

        @BindView(R.id.name_tv)
        TextView nameLabel;

        @BindView(R.id.dialog_tv)
        TextView dialogLabel;

        public DialogRowHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setDialog(Dialog dialog) {
            faceImageView.setImageResource(dialog.getmImageDrawable());
            nameLabel.setText(dialog.getmName());
            dialogLabel.setText(dialog.getmText());
        }
    }
}
