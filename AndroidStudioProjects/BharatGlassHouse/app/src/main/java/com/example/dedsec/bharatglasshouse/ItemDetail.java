package com.example.dedsec.bharatglasshouse;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.dedsec.bharatglasshouse.Database.Database;
import com.example.dedsec.bharatglasshouse.Model.Item;
import com.example.dedsec.bharatglasshouse.Model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ItemDetail extends AppCompatActivity {

    TextView item_name,item_price,item_description;
    ImageView item_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String itemId="";

    FirebaseDatabase database;

    DatabaseReference items;

    Item currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        database = FirebaseDatabase.getInstance();
        items = database.getReference("Items");

        numberButton = (ElegantNumberButton)(findViewById(R.id.number_button));
        btnCart = (FloatingActionButton)(findViewById(R.id.btnCart));

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        itemId,
                        currentItem.getName(),
                        numberButton.getNumber(),
                        currentItem.getPrice(),
                        currentItem.getDiscount()
                        ));

                Toast.makeText(ItemDetail.this,"Added to Cart",Toast.LENGTH_SHORT).show();
            }
        });

        item_description = (TextView) findViewById(R.id.item_description);
        item_name = (TextView) findViewById(R.id.item_name);
        item_price = (TextView) findViewById(R.id.item_price);
        item_image = (ImageView) findViewById(R.id.img_item);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        if (getIntent()!=null)
            itemId = getIntent().getStringExtra("ItemID");
        if(!itemId.isEmpty()) {
            getDetailItem(itemId);
        }
    }

    private void getDetailItem(String itemId) {
        items.child(itemId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentItem = dataSnapshot.getValue(Item.class);
                Picasso.with(getBaseContext()).load(currentItem.getImage()).into(item_image);

                collapsingToolbarLayout.setTitle(currentItem.getName());

                item_price.setText(currentItem.getPrice());

                item_name.setText(currentItem.getName());

                item_description.setText(currentItem.getDescription());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
