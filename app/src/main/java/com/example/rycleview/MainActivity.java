package com.example.rycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import book.Book;
import category.Category;
import category.CategoryAdapter;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvCategory=findViewById(R.id.rcv_category);
        categoryAdapter=new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Book> listBook=new ArrayList<>();
        listBook.add(new Book(R.drawable.batman,"Book 1"));
        listBook.add(new Book(R.drawable.avenger,"Book 2"));
        listBook.add(new Book(R.drawable.hulk,"Book 3"));
        listBook.add(new Book(R.drawable.jumanji,"Book 4"));
        listBook.add(new Book(R.drawable.venom,"Book 5"));

        listBook.add(new Book(R.drawable.batman,"Book 1"));
        listBook.add(new Book(R.drawable.avenger,"Book 2"));
        listBook.add(new Book(R.drawable.hulk,"Book 3"));
        listBook.add(new Book(R.drawable.jumanji,"Book 4"));
        listBook.add(new Book(R.drawable.venom,"Book 5"));

        listCategory.add(new Category("Category 1",listBook));
        listCategory.add(new Category("Category 2",listBook));
        listCategory.add(new Category("Category 3",listBook));
        listCategory.add(new Category("Category 4",listBook));

        return listCategory ;
    }
}