package com.tribe7.mvptest.article;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.bean.ArticleBean;

import java.util.List;

/**
 * Created by admin on 2016/8/23.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ItemViewHolder> {
    private RecyclerView mRecyclerView;
    private List<ArticleBean> mDatas;
    private LayoutInflater mInflater;
    private OnItemClickListener mOnItemClickListener;

    private Context context;

    public ArticleAdapter(Context context, List<ArticleBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder itemViewHolder, final int i) {
        ArticleBean article = mDatas.get(i);
        itemViewHolder.tv_title.setText(article.getTitle());
        itemViewHolder.tv_content.setText(Html.fromHtml(article.getContent()));
        itemViewHolder.tv_hits.setText(context.getString(R.string.hits, new Object[]{article.getHits()}));
        itemViewHolder.tv_comments.setText(context.getString(R.string.comments, new Object[]{article.getComments()}));
        itemViewHolder.tv_type.setText(article.getType()+"");

        if (mOnItemClickListener != null) {
            if (!itemViewHolder.itemView.hasOnClickListeners()) {
                itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = itemViewHolder.getPosition();
                        mOnItemClickListener.onItemClick(v, pos);
                    }
                });
                itemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = itemViewHolder.getPosition();
                        mOnItemClickListener.onItemLongClick(v, pos);
                        return true;
                    }
                });
            }
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        mRecyclerView = recyclerView;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ItemViewHolder holder = new ItemViewHolder(mInflater.inflate(R.layout.item_lv_article, viewGroup, false));
        return holder;
    }

    /**
     * 向指定位置添加元素
     *
     * @param position
     * @param article
     */
    public void add(int position, ArticleBean article) {
        if (position > mDatas.size()) {
            position = mDatas.size();
        }
        if (position < 0) {
            position = 0;
        }
        mDatas.add(position, article);
        /**
         * 使用notifyItemInserted/notifyItemRemoved会有动画效果
         * 而使用notifyDataSetChanged()则没有
         */
        notifyItemInserted(position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    /**
     * 处理item的点击事件和长按事件
     */
    interface OnItemClickListener {
        public void onItemClick(View view, int position);

        public void onItemLongClick(View view, int position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private TextView tv_content;
        private TextView tv_hits;
        private TextView tv_comments;
        private TextView tv_type;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_content = (TextView) itemView.findViewById(R.id.tv_content);
            tv_hits = (TextView) itemView.findViewById(R.id.tv_hits);
            tv_comments = (TextView) itemView.findViewById(R.id.tv_comments);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }
}
