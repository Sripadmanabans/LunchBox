package zerobase.us.lunchbox.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.lunchbox.R;

/**
 * This is the adapter that is used to populate the menu in the shop fragment.
 * Created by Sripad on 1/12/2016.
 */
public class ShopMenuListAdapter extends BaseAdapter {

    private String[] name = {"Pizza", "Burger", "Doughnut", "Coffee", "Tea"};
    private Double[] prices = {8.99, 4.99, 0.99, 1.99, 1.49};

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.shop_menu_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.shopMenuItemName.setText(name[position]);
        viewHolder.shopMenuItemPrice.setText(prices[position].toString());

        return convertView;
    }

    protected static class ViewHolder {

        @Bind(R.id.shop_menu_item_name)
        TextView shopMenuItemName;

        @Bind(R.id.shop_menu_item_price)
        TextView shopMenuItemPrice;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
