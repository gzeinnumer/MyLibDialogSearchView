package com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialog;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gzeinnumer.mylibsearchviewdialog.constant.ButtonStyle;
import com.gzeinnumer.mylibsearchviewdialog.constant.SelectType;
import com.gzeinnumer.mylibsearchviewdialog.model.SearchViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchViewDialog extends SearchViewDialogSetting {

    public static final String TAG = "CustomDialog";

    private FragmentManager _context;
    private FragmentTransaction _transaction;

    public SearchViewDialog(FragmentManager context, ArrayList<String> list) {
        this._context = context;

        if (list==null)
            list = new ArrayList<>();

        this.listFromUser = list;

        _transaction = _context.beginTransaction();
        Fragment previous = _context.findFragmentByTag(SearchViewDialog.TAG);
        if (previous != null) {
            _transaction.remove(previous);
        }
    }

    public SearchViewDialog(FragmentManager _context) {
        this._context = _context;
        _transaction = _context.beginTransaction();
        Fragment previous = _context.findFragmentByTag(SearchViewDialog.TAG);
        if (previous != null) {
            _transaction.remove(previous);
        }
    }

    // Input Model
    public <T> SearchViewDialog setItems(T[] items) {
         return setItems(Arrays.asList(items));
    }

    public <T> SearchViewDialog setItems(List<T> items) {
        for (int i = 0; i < items.size(); i++) {
            this.listFromUser.add(items.get(i).toString());
        }
        return this;
    }

    //CANVAS
    public SearchViewDialog setDialogCanvas(Drawable resource) {
        this.shapeCanvas = resource;
        return this;
    }

    //TITLE
    public SearchViewDialog setTitle(String title) {
        this.tvTitleValue = title;
        return this;
    }
    public SearchViewDialog setTitleSize(int size) {
        this.tvTitleSize = size;
        return this;
    }
    public SearchViewDialog setTitleColor(int color) {
        this.tvTitleColor = color;
        return this;
    }
    public SearchViewDialog setTitleAlignment(int alignment) {
        this.tvTitleAlignment = alignment;
        return this;
    }

    //CONTENT
    public SearchViewDialog setContent(String title) {
        this.tvContentValue = title;
        return this;
    }
    public SearchViewDialog setContentSize(int size) {
        this.tvContentSize = size;
        return this;
    }
    public SearchViewDialog setContentColor(int color) {
        this.tvContentColor = color;
        return this;
    }
    public SearchViewDialog setContentAlignment(int alignment) {
        this.tvContentAlignment = alignment;
        return this;
    }

    //CANCEL
    public SearchViewDialog setBtnCancelTitle(String title) {
        this.dBtnCancelValue = title;
        return this;
    }
    public SearchViewDialog setBtnCancelTitleColor(int color) {
        this.btnTextColorCancel = color;
        return this;
    }

    //CANCEL ICON
    public SearchViewDialog setCancelIconLeft(int icon) {
        this.cancelIconL = icon;
        return this;
    }
    public SearchViewDialog setCancelIconTop(int icon) {
        this.cancelIconT = icon;
        return this;
    }
    public SearchViewDialog setCancelIconRight(int icon) {
        this.cancelIconR = icon;
        return this;
    }
    public SearchViewDialog setCancelIconBottom(int icon) {
        this.cancelIconB = icon;
        return this;
    }

    //OK
    public SearchViewDialog setBtnOkTitle(String title) {
        this.dBtnOkValue = title;
        return this;
    }
    public SearchViewDialog setBtnOkTitleColor(int color) {
        this.btnTextColorOk = color;
        return this;
    }

    //OK ICON
    public SearchViewDialog setOkIconLeft(int icon) {
        this.okIconL = icon;
        return this;
    }
    public SearchViewDialog setOkIconTop(int icon) {
        this.okIconT = icon;
        return this;
    }
    public SearchViewDialog setOkIconRight(int icon) {
        this.okIconR = icon;
        return this;
    }
    public SearchViewDialog setOkIconBottom(int icon) {
        this.okIconB = icon;
        return this;
    }

    //BUTTON STYLE
    public SearchViewDialog setButtonStyle(ButtonStyle style) {
        this.btnStyle = style;
        return this;
    }
    public SearchViewDialog setButtonTextSize(int size) {
        this.dBtnTextSize = size;
        return this;
    }
    public SearchViewDialog setButtonGravity(int gravity) {
        this.buttonGravity = gravity;
        return this;
    }

    //ACTION CALLBACK
    public SearchViewDialog onCancelPressedCallBack(OnCancelPressed callBack) {
        this.onCancelPressed = callBack;
        return this;
    }
    public SearchViewDialog onOkPressedCallBackSingle(OnOkPressedSingle callBack) {
        this.type = SelectType.TYPE_SINGLE;
        this.onOkPressedSingle = callBack;
        return this;
    }
    public SearchViewDialog onOkPressedCallBackMulti(OnOkPressedMulti callBack) {
        this.type = SelectType.TYPE_MULTI;
        this.onOkPressedMulti = callBack;
        return this;
    }

    public SearchViewDialog setContentListHeight(int listHeight) {
        this.listHeight = listHeight;
        return this;
    }

    public SearchViewDialog setTextListColor(int color) {
        this.textListColor = color;
        return this;
    }

    public SearchViewDialog setTextListSize(int size) {
        this.textListSize = size;
        return this;
    }

    public SearchViewDialog setTextSearchSize(int size) {
        this.textSearchSize = size;
        return this;
    }

    public SearchViewDialog setTextSearchColor(int color) {
        this.textSearchColor = color;
        return this;
    }

    public SearchViewDialog setCanvasWidth(double size) {
        this.canvasWidth = size;
        return this;
    }

    public SearchViewDialog enableFullScreen() {
        this.isFullScreen = true;
        return this;
    }

    public SearchViewDialog setButtonColor(int color) {
        this.buttonColor = color;
        return this;
    }

    //callback
    public interface OnCancelPressed {
        void onCancelPressed();
    }

    public interface OnOkPressedSingle {
        void onOkSingle(int position, String value);
    }

    public interface OnOkPressedMulti {
        void onOkMulti(List<SearchViewModel> data);
    }

    public void show() {
        this.show(_transaction, SearchViewDialog.TAG);
    }
}