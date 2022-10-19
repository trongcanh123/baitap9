package category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rycleview.R;

import java.time.temporal.Temporal;
import java.util.List;

import book.BookAdapter;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<Category> mListCategory;
    private Object LinearLayoutManager;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void  setData(List<Category> list){
        this.mListCategory= list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category= mListCategory.get(position);
        if (category==null){
            return;
        }
        holder.tvNameCategory.setText(category.getNameCategory());
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL,false);
        holder.rcvBook.setLayoutManager(linearLayoutManager);
        
        BookAdapter bookAdapter= new BookAdapter();
        bookAdapter.setData(category.getBooks());
        holder.rcvBook.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListCategory!=null ){
            return mListCategory.size();

        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameCategory;
        private RecyclerView rcvBook;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory= itemView.findViewById(R.id.tv_name_category);
            rcvBook= itemView.findViewById(R.id.rcv_book);
        }
    }
}
