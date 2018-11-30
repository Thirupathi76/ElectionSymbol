package com.example.admin.electionsymbol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

class VoteAdapter extends BaseAdapter{
    String[] names;
    int[] image;
    Context context;
    private RadioButton selected = null;
    private int mSelectedPosition = -1;
    private RadioButton mSelectedRB;

    public VoteAdapter(CastVoteActivity mainActivity, String[] names, int[] image) {
        this.image=image;
        this.names=names;
        this.context=mainActivity;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View cview= LayoutInflater.from(context).inflate(R.layout.party_symbol,viewGroup,false);
        CircleImageView circleImageView;
        LinearLayout layout_vote;
        TextView txt1;
        final RadioButton radio;
        txt1=cview.findViewById(R.id.name);
        circleImageView=cview.findViewById(R.id.image);
        radio=cview.findViewById(R.id.radio1);
        layout_vote=cview.findViewById(R.id.layout_vote);
        txt1.setText(names[i]);
        radio.setClickable(false);
        circleImageView.setImageResource(image[i]);
        if (i == getCount() - 1) {
            if (selected == null) {
                radio.setChecked(true);
                selected = radio;
            }
        }

       layout_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(i != mSelectedPosition && mSelectedRB != null){
                    mSelectedRB.setChecked(false);
                }

                mSelectedPosition = i;
                mSelectedRB = radio;

                if(mSelectedPosition != i){
                    radio.setChecked(false);
                } else {
                    radio.setChecked(true);
                }

                Utilities.setPreference(context, Constants.YOUR_VOTE, names[i] );
            }
        });

        if(mSelectedPosition != i){
            radio.setChecked(false);
        } else {
            radio.setChecked(true);
            /*if(mSelectedRB != null && radio != mSelectedRB){
                mSelectedRB = radio;
            }*/
        }
        return cview;
    }


    }

