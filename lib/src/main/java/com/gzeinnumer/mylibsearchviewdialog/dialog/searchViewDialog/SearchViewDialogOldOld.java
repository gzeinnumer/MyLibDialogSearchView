package com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialog;

import android.graphics.drawable.Drawable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.gzeinnumer.mylibsearchviewdialog.constant.ButtonStyle;
import com.gzeinnumer.mylibsearchviewdialog.constant.SelectType;
import com.gzeinnumer.mylibsearchviewdialog.model.SearchViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SearchViewDialogOldOld extends SearchViewDialogSettingOld {

    public static final String TAG = "CustomDialog";

    private FragmentManager _context;
    private FragmentTransaction _transaction;

    /**
     * @deprecated "for better performance, you should use
     * new SearchViewDialog(getSupportFragmentManager())
     *     .setItems(listString)"
     */
    @Deprecated
    public SearchViewDialogOldOld(FragmentManager context, ArrayList<String> list) {
        this._context = context;

        if (list==null)
            list = new ArrayList<>();

        this.listFromUser = list;

        _transaction = _context.beginTransaction();
        Fragment previous = _context.findFragmentByTag(SearchViewDialogOldOld.TAG);
        if (previous != null) {
            _transaction.remove(previous);
        }
    }

    public SearchViewDialogOldOld(FragmentManager _context) {
        this._context = _context;
        _transaction = _context.beginTransaction();
        Fragment previous = _context.findFragmentByTag(SearchViewDialogOldOld.TAG);
        if (previous != null) {
            _transaction.remove(previous);
        }
    }

    // Input Model
    public <T> SearchViewDialogOldOld setItems(ArrayList<String> items) {
        if (list==null)
            list = new ArrayList<>();

        this.listFromUser = items;
        return this;
    }

    public <T> SearchViewDialogOldOld setItems(T[] items) {
        return setItems(Arrays.asList(items));
    }

    public <T> SearchViewDialogOldOld setItems(List<T> items) {
        for (int i = 0; i < items.size(); i++) {
            this.listFromUser.add(items.get(i).toString());
        }
        return this;
    }

    //CANVAS
    public SearchViewDialogOldOld setDialogCanvas(Drawable resource) {
        this.shapeCanvas = resource;
        return this;
    }

    //TITLE
    public SearchViewDialogOldOld setTitle(String title) {
        this.tvTitleValue = title;
        return this;
    }
    public SearchViewDialogOldOld setTitleSize(int size) {
        this.tvTitleSize = size;
        return this;
    }
    public SearchViewDialogOldOld setTitleColor(int color) {
        this.tvTitleColor = color;
        return this;
    }
    public SearchViewDialogOldOld setTitleAlignment(int alignment) {
        this.tvTitleAlignment = alignment;
        return this;
    }

    //CONTENT
    public SearchViewDialogOldOld setContent(String title) {
        this.tvContentValue = title;
        return this;
    }
    public SearchViewDialogOldOld setContentSize(int size) {
        this.tvContentSize = size;
        return this;
    }
    public SearchViewDialogOldOld setContentColor(int color) {
        this.tvContentColor = color;
        return this;
    }
    public SearchViewDialogOldOld setContentAlignment(int alignment) {
        this.tvContentAlignment = alignment;
        return this;
    }

    //CANCEL
    public SearchViewDialogOldOld setBtnCancelTitle(String title) {
        this.dBtnCancelValue = title;
        return this;
    }
    public SearchViewDialogOldOld setBtnCancelTitleColor(int color) {
        this.btnTextColorCancel = color;
        return this;
    }

    //CANCEL ICON
    public SearchViewDialogOldOld setCancelIconLeft(int icon) {
        this.cancelIconL = icon;
        return this;
    }
    public SearchViewDialogOldOld setCancelIconTop(int icon) {
        this.cancelIconT = icon;
        return this;
    }
    public SearchViewDialogOldOld setCancelIconRight(int icon) {
        this.cancelIconR = icon;
        return this;
    }
    public SearchViewDialogOldOld setCancelIconBottom(int icon) {
        this.cancelIconB = icon;
        return this;
    }

    //OK
    public SearchViewDialogOldOld setBtnOkTitle(String title) {
        this.dBtnOkValue = title;
        return this;
    }
    public SearchViewDialogOldOld setBtnOkTitleColor(int color) {
        this.btnTextColorOk = color;
        return this;
    }

    //OK ICON
    public SearchViewDialogOldOld setOkIconLeft(int icon) {
        this.okIconL = icon;
        return this;
    }
    public SearchViewDialogOldOld setOkIconTop(int icon) {
        this.okIconT = icon;
        return this;
    }
    public SearchViewDialogOldOld setOkIconRight(int icon) {
        this.okIconR = icon;
        return this;
    }
    public SearchViewDialogOldOld setOkIconBottom(int icon) {
        this.okIconB = icon;
        return this;
    }

    //BUTTON STYLE
    public SearchViewDialogOldOld setButtonStyle(ButtonStyle style) {
        this.btnStyle = style;
        return this;
    }
    public SearchViewDialogOldOld setButtonTextSize(int size) {
        this.dBtnTextSize = size;
        return this;
    }
    public SearchViewDialogOldOld setButtonGravity(int gravity) {
        this.buttonGravity = gravity;
        return this;
    }

    //ACTION CALLBACK
    public SearchViewDialogOldOld onCancelPressedCallBack(OnCancelPressed callBack) {
        this.onCancelPressed = callBack;
        return this;
    }
    public SearchViewDialogOldOld onOkPressedCallBackSingle(OnOkPressedSingle callBack) {
        this.type = SelectType.TYPE_SINGLE;
        this.onOkPressedSingle = callBack;
        return this;
    }
    public SearchViewDialogOldOld onOkPressedCallBackMulti(OnOkPressedMulti callBack) {
        this.type = SelectType.TYPE_MULTI;
        this.onOkPressedMulti = callBack;
        return this;
    }

    public SearchViewDialogOldOld setContentListHeight(int listHeight) {
        this.listHeight = listHeight;
        return this;
    }

    public SearchViewDialogOldOld setTextListColor(int color) {
        this.textListColor = color;
        return this;
    }

    public SearchViewDialogOldOld setTextListSize(int size) {
        this.textListSize = size;
        return this;
    }

    public SearchViewDialogOldOld setTextSearchSize(int size) {
        this.textSearchSize = size;
        return this;
    }

    public SearchViewDialogOldOld setTextSearchColor(int color) {
        this.textSearchColor = color;
        return this;
    }

    public SearchViewDialogOldOld setCanvasWidth(double size) {
        this.canvasWidth = size;
        return this;
    }

    public SearchViewDialogOldOld enableFullScreen() {
        this.isFullScreen = true;
        return this;
    }

    public SearchViewDialogOldOld setButtonColor(int color) {
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
        this.show(_transaction, SearchViewDialogOldOld.TAG);
    }
}