package com.example.admin.electionsymbol;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import de.hdodenhof.circleimageview.CircleImageView;

class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.MyHolder>{
    Context context;
    int[] image1;
    String[] names1;
    int[] seekbarvalues;
    String[] percentages;
    int[] colors;


    public ResultsAdapter(ResultsActivity resultsActivity, int[] image1, String[] names1, int[] seekbarvalues, String[] percentages, int[] colors) {
        this.context= resultsActivity;
        this.image1=image1;
        this.names1=names1;
        this.seekbarvalues=seekbarvalues;
        this.percentages=percentages;
        this.colors=colors;
    }

    @Override
    public int getItemCount() {
        return names1.length;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.result, viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.percentage.setText(percentages[i]);
        myHolder.name1.setText(names1[i]);
        myHolder.imageView1.setImageResource(image1[i]);
        myHolder.percentage.setText(percentages[i]);
        myHolder.progressBar.setProgress(seekbarvalues[i]);
        myHolder.progressBar.setProgressColors(context.getResources().getColor(R.color.progress_bg), context.getResources().getColor(colors[i]));
        myHolder.progressBar.animateProgress(2000, 0, seekbarvalues[i]);
    }



    public class MyHolder extends RecyclerView.ViewHolder{
        TextView name1, percentage;
        CircleImageView imageView1;
        RoundedHorizontalProgressBar progressBar;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name1 = itemView.findViewById(R.id.name1);
            percentage = itemView.findViewById(R.id.percentage);
            imageView1 = itemView.findViewById(R.id.image1);
            progressBar = itemView.findViewById(R.id.progress_bar_1);
        }
    }
}
