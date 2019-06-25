package com.bloxandroid.cardviewmenu;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.CustomViewHolder> {
    private Context mContext;
    private List<Pizza> pizzas;

    //Class PizzaAdapter Constructor
    public PizzaAdapter(List<Pizza> pizzas, Context mContext) {
        this.mContext = mContext;
        this.pizzas = pizzas;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.pizza_card, viewGroup, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder customViewHolder, final int i) {
        Pizza pizza = pizzas.get(i);
        customViewHolder.name.setText(pizza.getName());
        customViewHolder.price.setText(pizza.getPriceString());
        customViewHolder.image.setImageResource(pizza.getImageResource());
        customViewHolder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOptionsMenu(customViewHolder.menu,i);
            }
        });
    }

    private void showOptionsMenu(ImageView menu,int i) {
        PopupMenu popup = new PopupMenu(mContext, menu);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_pizza, popup.getMenu());
        PizzaMenuItemClickListener listener=new PizzaMenuItemClickListener();
        listener.setPizzaId(i);
        popup.setOnMenuItemClickListener(listener);
        popup.show();
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        //ViewHolder Atributtes
        private TextView name, price;
        private ImageView image, menu;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.pizzaName);
            price = (TextView) itemView.findViewById(R.id.pizzaPrice);
            image = (ImageView) itemView.findViewById(R.id.pizzaImage);
            menu = (ImageView) itemView.findViewById(R.id.menuDots);
        }
    }

    private class PizzaMenuItemClickListener implements PopupMenu.OnMenuItemClickListener{
        private int pizzaId;

        public void setPizzaId(int pizzaId) {
            this.pizzaId = pizzaId;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favorite:
                    Toast.makeText(mContext, "Add to Favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.order_now:
                    Intent intent=new Intent(mContext,OrderActivity.class);
                    intent.putExtra("pizza_id",pizzaId+"");
                    mContext.startActivity(intent);
            }
            return false;
        }
    }
}//Pizza Adapter end-class
