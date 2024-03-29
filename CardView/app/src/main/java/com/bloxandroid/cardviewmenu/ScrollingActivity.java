package com.bloxandroid.cardviewmenu;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
    List<Pizza> pizzas = new ArrayList<>();
    private RecyclerView recyclerView;
    private PizzaAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        pAdapter = new PizzaAdapter(pizzas,this);

        // Create grids with 2 items in a row
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);

        populatePizzaDetails();
        pAdapter.notifyDataSetChanged();
    }

    private void populatePizzaDetails() {
        Pizza pizza = new Pizza("Deluxe Veggie",R.drawable.deluxe_veggie,58,5);
        pizzas.add(pizza);
        pizza = new Pizza("Farm House",R.drawable.farmhouse,55,5);
        pizzas.add(pizza);
        pizza = new Pizza("Peppy Paneer",R.drawable.peppy_paneer,57,5);
        pizzas.add(pizza);
        pizza = new Pizza("Mexican Green Wave",R.drawable.mexican_green_wave,60,10);
        pizzas.add(pizza);
        pizza = new Pizza("Chicken Fiesta",R.drawable.chicken_fiesta,52,5);
        pizzas.add(pizza);
        pizza = new Pizza("Chicken Golden Delight",R.drawable.chicken_golden_delight,55,10);
        pizzas.add(pizza);
        pizza = new Pizza("Chicken Dominator",R.drawable.dominator,62,5);
        pizzas.add(pizza);
        pizza = new Pizza("Non-Veg Supreme",R.drawable.non_veg_supreme,59,10);
        pizzas.add(pizza);
    }

    public static Pizza getPizzaInfo(int position) {
        List<Pizza> pizzas = new ArrayList<>();
        Pizza pizza = new Pizza("Deluxe Veggie",R.drawable.deluxe_veggie,58,5);
        pizzas.add(pizza);
        pizza = new Pizza("Farm House",R.drawable.farmhouse,55,5);
        pizzas.add(pizza);
        pizza = new Pizza("Peppy Paneer",R.drawable.peppy_paneer,57,5);
        pizzas.add(pizza);
        pizza = new Pizza("Mexican Green Wave",R.drawable.mexican_green_wave,60,10);
        pizzas.add(pizza);
        pizza = new Pizza("Chicken Fiesta",R.drawable.chicken_fiesta,52,5);
        pizzas.add(pizza);
        pizza = new Pizza("Chicken Golden Delight",R.drawable.chicken_golden_delight,55,10);
        pizzas.add(pizza);
        pizza = new Pizza("Chicken Dominator",R.drawable.dominator,62,5);
        pizzas.add(pizza);
        pizza = new Pizza("Non-Veg Supreme",R.drawable.non_veg_supreme,59,10);
        pizzas.add(pizza);
        return pizzas.get(position);
    }
}