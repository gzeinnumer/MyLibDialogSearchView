package com.gzeinnumer.mylibsearchviewdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gzeinnumer.mylibsearchviewdialog.constant.ButtonStyle;
import com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialog.SearchViewDialog;
import com.gzeinnumer.mylibsearchviewdialog.model.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("Lorem ipsum dolor");
        list.add("sit amet, consectetur");
        list.add("adipiscing elit, sed do");
        list.add("eiusmod tempor");
        list.add("incididunt ut labore et dolore");
        list.add("magna aliqua");
        list.add("Ut enim ad minim veniam, quis nostrud exercitation");
        list.add("ullamco laboris nisi ut aliquip");
        list.add("ex ea commodo consequat.");
        list.add("Duis aute irure dolor");
        list.add("in reprehenderit");
        list.add("in voluptate");
        list.add("velit esse cillum dolor");

        initOnClick();
    }

    Button btn;
    TextView tv;

    private void initOnClick() {
        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv_title);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //choise 1
                initDialogSingle();
//                initDialogMulti();
//                initDialogSingleCustom();
//                initDialogMultiCustom();
            }
        });
    }

    private static final String TAG = "Main_Activity";

    private void initDialogSingle() {
        new SearchViewDialog(getSupportFragmentManager(), list)
                .setTitle("ini title")
                .setContent("ini content")
                .setButtonStyle(ButtonStyle.ButtonContained)
                .setButtonColor(R.color.amber_200)
                .onOkPressedCallBackSingle(new SearchViewDialog.OnOkPressedSingle() {
                    @Override
                    public void onOkSingle(int position, String value) {
                        String temp = "Single Select :\n\n";
                        temp = temp+"position on list => "+position+"\n";
                        temp = temp+"value on list => "+value+"\n";

                        tv.setText(temp);
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initDialogMulti() {
        new SearchViewDialog(getSupportFragmentManager(), list)
                .enableFullScreen()
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti(){
                    @Override
                    public void onOkMulti(List<SearchViewModel> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (SearchViewModel d: data){
                            temp = temp + "position on list => "+d.getPosition()+"\n";
                            temp = temp + "value on list => "+d.getName()+"\n\n";
                        }
                        tv.setText(temp);
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void initDialogSingleCustom() {
        new SearchViewDialog(getSupportFragmentManager(), list)
                .setCanvasWidth(1.0)
                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))

                .setTitle("ini title")
                .setTitleSize(21)
                .setTitleColor(getResources().getColor(R.color.colorAccent))
//                .setTitleColor(Color.parseColor("#03DAC5"))
                .setTitleAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setContent("ini content")
                .setContentSize(21)
                .setContentColor(getResources().getColor(R.color.colorAccent))
//                .setContentColor(Color.parseColor("#03DAC5"))
                .setContentAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setBtnCancelTitle("Batal")
                .setBtnCancelTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnCancelTitleColor(Color.parseColor("#03DAC5"))
                .setCancelIconLeft(R.drawable.ic_baseline_add_24)
                .setCancelIconTop(R.drawable.ic_baseline_add_24)
                .setCancelIconRight(R.drawable.ic_baseline_add_24)
                .setCancelIconBottom(R.drawable.ic_baseline_add_24)

                .setBtnOkTitle("Yuhuu")
                .setBtnOkTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnOkTitleColor(Color.parseColor("#03DAC5"))
                .setOkIconLeft(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconBottom(R.drawable.ic_baseline_add_24)

                .setButtonTextSize(21)
                .setButtonStyle(ButtonStyle.ButtonOutlined)
                .setButtonGravity(Gravity.CENTER)
                .setButtonColor(R.color.amber_200)

                .setTextSearchSize(30)
                .setTextSearchColor(getResources().getColor(R.color.colorAccent))
//                .setTextSearchColor(Color.parseColor("#03DAC5"))

                .setContentListHeight(900)

                .setTextListSize(30)
                .setTextListColor(getResources().getColor(R.color.colorAccent))
//                .setTextListColor(Color.parseColor("#03DAC5"))

                .onOkPressedCallBackSingle(new SearchViewDialog.OnOkPressedSingle() {
                    @Override
                    public void onOkSingle(int position, String value) {
                        String temp = "Single Select :\n\n";
                        temp = temp+"position on list => "+position+"\n";
                        temp = temp+"value on list => "+value+"\n";

                        tv.setText(temp);
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }

    private void initDialogMultiCustom() {
        new SearchViewDialog(getSupportFragmentManager(), list)
                .setCanvasWidth(1.0)
                .setDialogCanvas(getResources().getDrawable(R.drawable.rounded_corner_2))

                .setTitle("ini title")
                .setTitleSize(21)
                .setTitleColor(getResources().getColor(R.color.colorAccent))
//                .setTitleColor(Color.parseColor("#03DAC5"))
                .setTitleAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setContent("ini content")
                .setContentSize(21)
                .setContentColor(getResources().getColor(R.color.colorAccent))
//                .setContentColor(Color.parseColor("#03DAC5"))
                .setContentAlignment(View.TEXT_ALIGNMENT_TEXT_END)

                .setBtnCancelTitle("Batal")
                .setBtnCancelTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnCancelTitleColor(Color.parseColor("#03DAC5"))
                .setCancelIconLeft(R.drawable.ic_baseline_add_24)
                .setCancelIconTop(R.drawable.ic_baseline_add_24)
                .setCancelIconRight(R.drawable.ic_baseline_add_24)
                .setCancelIconBottom(R.drawable.ic_baseline_add_24)

                .setBtnOkTitle("Yuhuu")
                .setBtnOkTitleColor(getResources().getColor(R.color.colorAccent))
//                .setBtnOkTitleColor(Color.parseColor("#03DAC5"))
                .setOkIconLeft(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconTop(R.drawable.ic_baseline_add_24)
                .setOkIconBottom(R.drawable.ic_baseline_add_24)

                .setButtonTextSize(21)
                .setButtonStyle(ButtonStyle.ButtonOutlined)
                .setButtonGravity(Gravity.CENTER)

                .setTextSearchSize(30)
                .setTextSearchColor(getResources().getColor(R.color.colorAccent))
//                .setTextSearchColor(Color.parseColor("#03DAC5"))

                .setContentListHeight(900)

                .setTextListSize(30)
                .setTextListColor(getResources().getColor(R.color.colorAccent))
//                .setTextListColor(Color.parseColor("#03DAC5"))

                .onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti(){
                    @Override
                    public void onOkMulti(List<SearchViewModel> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (SearchViewModel d: data){
                            temp = temp + "position on list => "+d.getPosition()+"\n";
                            temp = temp + "value on list => "+d.getName()+"\n\n";
                        }
                        tv.setText(temp);
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }
}