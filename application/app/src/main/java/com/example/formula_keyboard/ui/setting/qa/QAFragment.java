package com.example.formula_keyboard.ui.setting.qa;

import android.app.Activity;
import android.content.Context;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;

import com.example.formula_keyboard.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//public class QAFragment extends Fragment {
public class QAFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;


    public static Fragment newInstance() {
        QAFragment fragment = new QAFragment();
        return fragment;
    }

    /* Called when the activity is first created. */





        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.q_and_a, null);

            expListView = (ExpandableListView) rootView.findViewById(R.id.QAListView);

            prepareListData();

            listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
            expListView.setAdapter(listAdapter);

            Log.i("groups", listDataHeader.toString());
            Log.i("details", listDataChild.toString());

            // Listview Group click listener
            expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

                @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                    // Toast.makeText(getApplicationContext(),
                    // "Group Clicked " + listDataHeader.get(groupPosition),
                    // Toast.LENGTH_SHORT).show();
                    return false;
                }
            });

            // Listview Group expanded listener
            expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                    Toast.makeText(getActivity().getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
                }
            });

            // Listview Group collasped listener
            expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

                @Override
                public void onGroupCollapse(int groupPosition) {
                    Toast.makeText(getActivity().getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
                }
            });

            // Listview on child click listener
            expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v,
                                            int groupPosition, int childPosition, long id) {
                    Toast.makeText(getActivity().getApplicationContext(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
            return rootView;
        }

        private void prepareListData() {
            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<String>>();

            // Adding child data
            listDataHeader.add("Q.キーボードの設定の方法が分かりません。");
            listDataHeader.add("Q.個人情報などが盗まれたりはしませんか？");
            listDataHeader.add("Q.このアプリへの意見や要望があるのですが。");

            // Adding child data
            List<String> top250 = new ArrayList<String>();
            top250.add("A.設定の方法はアプリ内の他のページにて詳細な説明を行っているため、そちらをご覧ください。");


            List<String> nowShowing = new ArrayList<String>();
            nowShowing.add("A.キーボードを提供するだけのアプリとなっていますので、個人情報などが盗まれる可能性はございません");

            List<String> comingSoon = new ArrayList<String>();
            comingSoon.add("A.ご意見やご要望につきましてはこちらのメールアドレスにてご連絡ください。");


            listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
            listDataChild.put(listDataHeader.get(1), nowShowing);
            listDataChild.put(listDataHeader.get(2), comingSoon);

        }


        public class ExpandableListAdapter extends BaseExpandableListAdapter {

            private Activity _context;
            private List<String> _listDataHeader; // header titles
            // child data in format of header title, child title
            private HashMap<String, List<String>> _listDataChild;

            public ExpandableListAdapter(Activity context, List<String> listDataHeader,
                                         HashMap<String, List<String>> listChildData) {
                this._context = context;
                this._listDataHeader = listDataHeader;
                this._listDataChild = listChildData;
            }

            @Override
            public Object getChild(int groupPosition, int childPosititon) {
                return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                        .get(childPosititon);
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public View getChildView(int groupPosition, final int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {

                final String childText = (String) getChild(groupPosition, childPosition);

                if (convertView == null) {
                    LayoutInflater infalInflater = (LayoutInflater) this._context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = infalInflater.inflate(R.layout.q_and_a_list_item, null);
                }

                TextView txtListChild = (TextView) convertView.findViewById(R.id.lblListItem);

                txtListChild.setText(childText);
                return convertView;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                        .size();
            }

            @Override
            public Object getGroup(int groupPosition) {
                return this._listDataHeader.get(groupPosition);
            }

            @Override
            public int getGroupCount() {
                return this._listDataHeader.size();
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded,
                                     View convertView, ViewGroup parent) {
                String headerTitle = (String) getGroup(groupPosition);
                if (convertView == null) {
                    LayoutInflater infalInflater = (LayoutInflater) this._context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = infalInflater.inflate(R.layout.q_and_a_list_group, null);
                }

                TextView lblListHeader = (TextView) convertView.findViewById(R.id.lblListHeader);
                lblListHeader.setTypeface(null, Typeface.BOLD);
                lblListHeader.setText(headerTitle);

                return convertView;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        }
    }




/*



 top250.add("A.設定の方法はアプリ内の他のページにて詳細な説明を行っているため、そちらをご覧ください。");


            List<String> nowShowing = new ArrayList<String>();
            nowShowing.add("A.キーボードを提供するだけのアプリとなっていますので、個人情報などが盗まれる可能性はございません");

            List<String> comingSoon = new ArrayList<String>();
            comingSoon.add("A.ご意見やご要望につきましてはこちらのメールアドレスにてご連絡ください。");

//public class QAFragment extends Fragment {
public class QAFragment extends Fragment {

    int PARENT_DATA = 3;
    int CHILD_DATA = 3;

    String question[]={"Q.キーボードの設定の方法が分かりません。","Q.個人情報などが盗まれたりはしませんか？","Q.このアプリへの意見や要望があるのですが。"};
    String answer[]={" A.設定の方法はアプリ内の他のページにて詳細な説明を行っているため、そちらをご覧ください。","A.キーボードを提供するだけのアプリとなっていますので、個人情報などが盗まれる可能性はございません"," A.ご意見やご要望につきましてはこちらのメールアドレスにてご連絡ください。"};



    public static Fragment newInstance() {
        QAFragment fragment = new QAFragment();
        return fragment;
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.q_and_a, container, false);


        return root;
        // super.onCreate(savedInstanceState);

       //super.onCreateView(inflater,container,savedInstanceState);
       return inflater.inflate(R.layout.q_and_a,container,false);

        // 親ノードのリスト
       //List<Map<String, String>> parentList = new ArrayList<Map<String, String>>();
        // 全体の子ノードのリスト
      //List<List<Map<String, String>>> allChildList = new ArrayList<List<Map<String, String>>>();

        // 親ノードに表示する内容を生成
       // for (int i = 0; i < PARENT_DATA; i++) {
            Map<String, String> parentData = new HashMap<String, String>();
            parentData.put("title", "title" + Integer.toString(i));
            // 親ノードのリストに内容を格納
            parentList.add(parentData);
        }

        // 子ノードに表示する文字を生成
        for (int i = 0; i < PARENT_DATA; i++) {
            // 子ノード全体用のリスト
            List<Map<String, String>> childList = new ArrayList<Map<String, String>>();

            // 各子ノード用データ格納
            for (int j = 0; j < 3; j++) {
                Map<String, String> childData = new HashMap<String, String>();
                childData.put("TITLE", "child" + Integer.toString(j));
                childData.put("SUMMARY", "summary" + Integer.toString(j));
                // 子ノードのリストに文字を格納
                childList.add(childData);
            }
            // 全体の子ノードリストに各小ノードリストのデータを格納
            allChildList.add(childList);
        }


        // アダプタを作る
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this, parentList,
                android.R.layout.simple_expandable_list_item_1,
                new String[] { "title" }, new int[] { android.R.id.text1 },
                allChildList, android.R.layout.simple_expandable_list_item_2,
                new String[] { "TITLE", "SUMMARY" }, new int[] {
                android.R.id.text1, android.R.id.text2 });

        ExpandableListView lv = (ExpandableListView) findViewById(R.id.expandableListView1);
        //生成した情報をセット
        lv.setAdapter(adapter);



        // リスト項目がクリックされた時の処理
        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view,
                                        int groupPosition, int childPosition, long id) {
                ExpandableListAdapter adapter = parent
                        .getExpandableListAdapter();

                // クリックされた場所の内容情報を取得
                Map<String, String> item = (Map<String, String>) adapter
                        .getChild(groupPosition, childPosition);

                // トーストとして表示
                Toast.makeText(
                        getApplicationContext(),
                        "child clicked " + item.get("TITLE") + " "
                                + item.get("SUMMARY"), Toast.LENGTH_LONG)
                        .show();
                return false;
            }
        });

        // グループの親項目がクリックされた時の処理

        lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View view,
                                        int groupPosition, long id) {

                ExpandableListAdapter adapter = parent
                        .getExpandableListAdapter();

                // クリックされた場所の内容情報を取得
                Map<String, String> item = (Map<String, String>) adapter
                        .getGroup(groupPosition);
                // トーストとして表示
                Toast.makeText(getApplicationContext(),
                        "parent clicked " + item.get("title"),
                        Toast.LENGTH_LONG).show();
                return false;
            }
        });
        return root;
    }
}
 */
