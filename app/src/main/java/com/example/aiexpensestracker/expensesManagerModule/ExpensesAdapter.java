package com.example.aiexpensestracker.expensesManagerModule;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiexpensestracker.R;

import java.util.ArrayList;
import java.util.List;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.MyViewHolder>{
    private Context context;
    private OnItemClick onItemClick;
    private List<ExpenseModel> expenseModelList;

    public ExpensesAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        expenseModelList = new ArrayList<>();
        this.onItemClick = onItemClick;
    }

    public void add(ExpenseModel expenseModel){
        expenseModelList.add(expenseModel);
        notifyDataSetChanged();

    }

    public void clear(){
        expenseModelList.clear();
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExpenseModel expenseModel = expenseModelList.get(position);
        if (expenseModel.getType().equals("Income")){
            holder.amount.setText(String.valueOf("+ RM" + expenseModel.getAmount()));
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.teal_700));
        }

        if (expenseModel.getType().equals("Expense")){
            holder.amount.setText(String.valueOf("- RM" + expenseModel.getAmount()));
            holder.amount.setTextColor(ContextCompat.getColor(context, R.color.red));
        }


        holder.name.setText(expenseModel.getItemName());
        holder.category.setText(expenseModel.getCategory());
        holder.date.setText(expenseModel.getDate());
        holder.time.setText(expenseModel.getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(expenseModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return expenseModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name, category, amount, date, time;


            public MyViewHolder(@NonNull View itemView){
                super(itemView);

                name = itemView.findViewById(R.id.name);
                category = itemView.findViewById(R.id.category);
                amount = itemView.findViewById(R.id.amount);
                date = itemView.findViewById(R.id.date);
                time = itemView.findViewById(R.id.time);

            }


        }



}
