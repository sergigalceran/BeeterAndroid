package edu.upc.eetac.dsa.beeter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import edu.upc.eetac.dsa.beeter.client.entity.StingCollection;

/**
 * Created by tono on 19/12/2015.
 */
public class StingCollectionAdapter extends BaseAdapter {

    private StingCollection stingCollection;
    private LayoutInflater layoutInflater;

    public StingCollectionAdapter(Context context, StingCollection stingCollection){
        layoutInflater = LayoutInflater.from(context);
        this.stingCollection = stingCollection;
    }

    class ViewHolder{
        TextView textViewCreator;
        TextView textViewSubject;
        TextView textViewDate;

        ViewHolder(View row){
            this.textViewCreator = (TextView) row
                    .findViewById(R.id.textViewCreator);
            this.textViewSubject = (TextView) row
                    .findViewById(R.id.textViewSubject);
            this.textViewDate = (TextView) row
                    .findViewById(R.id.textViewDate);
        }
    }

    @Override
    public int getCount() {
        return stingCollection.getStings().size();
    }

    @Override
    public Object getItem(int position) {
        return stingCollection.getStings().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_data, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String userid = stingCollection.getStings().get(position).getUserid();
        String subject = stingCollection.getStings().get(position).getSubject();
        Long date = stingCollection.getStings().get(position).getCreationTimestamp();
        String sdate = String.valueOf(date);

        viewHolder.textViewCreator.setText(userid);
        viewHolder.textViewSubject.setText(subject);
        viewHolder.textViewDate.setText(sdate);
        return convertView;
    }

}
