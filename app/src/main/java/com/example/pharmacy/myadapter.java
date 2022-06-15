package com.example.pharmacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{

ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    public myadapter() {
    myadapter ma = new myadapter();

    }


    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dtradename.setText(dataholder.get(position).getTradename());
        holder.dcommonname.setText(dataholder.get(position).getCommonname());
        holder.dcomposition.setText(dataholder.get(position).getComposition());
        holder.dbatchno.setText(dataholder.get(position).getBatchno());
        holder.dquantity.setText(dataholder.get(position).getQuantity());
        holder.dcp.setText(dataholder.get(position).getCostprice());
        holder.dsp.setText(dataholder.get(position).getSellingprice());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView dtradename,dcommonname,dcomposition,dbatchno,dquantity,dcp,dsp;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dtradename = (TextView)itemView.findViewById(R.id.displaytradename);
            dcommonname = (TextView)itemView.findViewById(R.id.displaycommonname);
            dcomposition = (TextView)itemView.findViewById(R.id.displaycomposition);
            dbatchno = (TextView)itemView.findViewById(R.id.displaybatchno);
            dquantity = (TextView)itemView.findViewById(R.id.displayquantity);
            dcp = (TextView)itemView.findViewById(R.id.displaycp);
            dsp = (TextView)itemView.findViewById(R.id.displaysp);
        }
    }
}
