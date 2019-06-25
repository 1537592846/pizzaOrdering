package com.bloxandroid.cardviewmenu;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    Pizza pizza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Getting the intent info and the fields to change
        Intent intent=getIntent();
        String pizzaId=intent.getStringExtra("pizza_id");
        pizza=ScrollingActivity.getPizzaInfo(Integer.parseInt(pizzaId));
        updateInfo();
    }

    public void onClickCoupon(View view){
        TextView pizzaCoupon=findViewById(R.id.edtxt_coupon);
        String couponValue= pizzaCoupon.getText().toString();
        switch (couponValue){
            case "teleport":
                pizza.setCouponDiscount(pizza.getDelivery_fee());
                break;
            case "please":
                pizza.setCouponDiscount(5);
                break;
            case "imhungry":
                pizza.setCouponDiscount(pizza.getPrice()/2);
                break;
            default:
                return;
        }
        updateInfo();
    }

    protected void updateInfo(){
        ImageView imageView=findViewById(R.id.pizzaImage);
        TextView pizzaName=findViewById(R.id.txt_pizza_name);
        TextView pizzaPrice=findViewById(R.id.txt_pizza_price);
        TextView pizzaDeliveryFee=findViewById(R.id.txt_pizza_delivery_fee);
        TextView pizzaCouponDiscount=findViewById(R.id.txt_pizza_coupon_discount);
        TextView pizzaFinalPrice=findViewById(R.id.txt_pizza_final_price);

        imageView.setImageResource(pizza.getImageResource());
        pizzaName.setText(pizza.getName());
        pizzaPrice.setText(pizza.getPriceString());
        pizzaDeliveryFee.setText(pizza.getDelivery_feeString());
        pizzaCouponDiscount.setText(pizza.getCouponDiscountString());
        pizzaFinalPrice.setText(pizza.getFinalPrice());
    }
}