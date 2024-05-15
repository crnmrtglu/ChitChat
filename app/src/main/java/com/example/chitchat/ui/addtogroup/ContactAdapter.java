package com.example.chitchat.ui.addtogroup;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chitchat.ContactModel;
import com.example.chitchat.OnClickItemEventListener;
import com.example.chitchat.R;

import java.util.List;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    List<ContactModel> contactModelList;
    OnClickItemEventListener onContactClickListener;

    public ContactAdapter(List<ContactModel> contactModelList, OnClickItemEventListener onContactClickListener) {
        this.contactModelList = contactModelList;
        this.onContactClickListener = onContactClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactViewHolder (LayoutInflater.from(parent.getContext()).inflate(R.layout.item_addtogroup_contact, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactModel contactModel = contactModelList.get(position);
        holder.setData(contactModel);
    }

    @Override
    public int getItemCount() {
        return contactModelList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageImageView;
        TextView nameTextView, numberTextView;

        public ContactViewHolder(View itemView) {
            super(itemView);

            imageImageView = itemView.findViewById(R.id.item_addtogroup_contact_imageImageView);
            nameTextView = itemView.findViewById(R.id.item_addtogroup_contact_nameTextView);
            numberTextView = itemView.findViewById(R.id.item_addtogroup_contact_numberTextView);

            itemView.setOnClickListener(this);
        }

        public void setData(ContactModel contactModel) {
            nameTextView.setText(contactModel.getName());
            numberTextView.setText(contactModel.getNumber());


            if (contactModel.getImage() != null) {
                imageImageView.setImageURI(Uri.parse(contactModel.getImage()));
            } else {

            }
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                onContactClickListener.onClickItemEvent(position);
            }
        }
    }
}