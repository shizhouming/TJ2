package com.example.lenovo.tj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.tj.R;
import com.example.lenovo.tj.bean.Bean_Recycler;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.R.attr.data;

/**
 * date: 2017/5/10
 * author: 史洲铭(lenovo)
 * function:
 */

public class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter2.ListViewHolder>{

    private Context mContext;
    //泛型是RecyclerView所需的bean类
    private List<Bean_Recycler.StudentsBean.StudentBean> mDataBeen;

    //构造方法,一般需要接收两个参数,上下文及集合对象.
    public MyRecyclerAdapter2(Context context, List<Bean_Recycler.StudentsBean.StudentBean> dataBean) {
        mContext=context;
        mDataBeen=dataBean;
    }

    //创建ViewHolder,并把VIewHolder(也可以理解为一个item)返回出去
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //转换一个View布局对象,决定了Item的样子.参数:1.上下文    2.XML布局资源     3.一般为null
        View itemView = View.inflate(mContext, R.layout.item_list2, null);
        //创建一个VIewHolder对象
        ListViewHolder listViewHolder = new ListViewHolder(itemView);
        //把ViewHolder对象传出去
        return listViewHolder;
    }

    //当VIewHolder和数据绑定时回调
    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        //从集合里拿对应item的数据对象
        Bean_Recycler.StudentsBean.StudentBean bean = mDataBeen.get(position);
        //给holder里面的控件对象设置数据
        holder.setData(bean);
    }

    //决定RecyclerView多少条item
    @Override
    public int getItemCount() {
        //数据不为null,有几条数据就显示几条数据
        if(mDataBeen !=null && mDataBeen.size()>0){
            return mDataBeen.size();
        }
        return 0;
    }

    //自动帮我写的ViewHolder,参数:View布局对象
    public class ListViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivIcon;
        //private final TextView tvName;

        public ListViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.img_recycler);
            //tvName = (TextView) itemView.findViewById(R.id.tv_recycler);
        }

        public void setData(Bean_Recycler.StudentsBean.StudentBean bean) {
            //给imageView设置图片数据
            Picasso.with(mContext).load(bean.getImg()).into(ivIcon);
            //给TextView设置文本数据
            //tvName.setText(bean.getName());
        }

    }
}