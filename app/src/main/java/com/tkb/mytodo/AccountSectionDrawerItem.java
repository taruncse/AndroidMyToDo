package com.tkb.mytodo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.holder.ImageHolder;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.AbstractDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Tagable;
import com.mikepenz.materialdrawer.model.interfaces.Typefaceable;
import com.mikepenz.materialize.util.UIUtils;

import java.util.List;

import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

public class AccountSectionDrawerItem extends AbstractDrawerItem<AccountSectionDrawerItem, AccountSectionDrawerItem.ViewHolder> implements IProfile<AccountSectionDrawerItem>, Tagable<AccountSectionDrawerItem>, Typefaceable<AccountSectionDrawerItem> {

    private StringHolder name;
    private boolean divider = true;
    private ColorHolder textColor;
    private Typeface typeface = null;
    protected ImageHolder icon;
    protected StringHolder email;

    @Override
    public AccountSectionDrawerItem withIcon(Drawable icon) {
        this.icon = new ImageHolder(icon);
        return this;
    }

    @Override
    public AccountSectionDrawerItem withIcon(@DrawableRes int iconRes) {
        this.icon = new ImageHolder(iconRes);
        return this;
    }

    @Override
    public AccountSectionDrawerItem withIcon(Bitmap iconBitmap) {
        this.icon = new ImageHolder(iconBitmap);
        return this;
    }

    @Override
    public AccountSectionDrawerItem withIcon(IIcon icon) {
        this.icon = new ImageHolder(icon);
        return this;
    }

    @Override
    public AccountSectionDrawerItem withIcon(String url) {
        this.icon = new ImageHolder(url);
        return this;
    }

    @Override
    public AccountSectionDrawerItem withIcon(Uri uri) {
        this.icon = new ImageHolder(uri);
        return this;
    }

    public AccountSectionDrawerItem withName(String name) {
        this.name = new StringHolder(name);
        return this;
    }

    public AccountSectionDrawerItem withName(@StringRes int nameRes) {
        this.name = new StringHolder(nameRes);
        return this;
    }

    public AccountSectionDrawerItem withEmail(String email) {
        this.email = new StringHolder(email);
        return this;
    }

    public AccountSectionDrawerItem withTypeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public AccountSectionDrawerItem withDivider(boolean divider) {
        this.divider = divider;
        return this;
    }

    public ColorHolder getTextColor() {
        return textColor;
    }

    @Override
    public Typeface getTypeface() {
        return typeface;
    }

    public ImageHolder getIcon() {
        return icon;
    }

    @Override
    public AccountSectionDrawerItem withName(CharSequence name) {
        //TODO have to change this later TKB - Shahab
        return this;
    }

    @Override
    public StringHolder getName() {
        return name;
    }

    public StringHolder getEmail() {
        return email;
    }

    public boolean hasDivider() {
        return divider;
    }

    @Override
    public int getType() {
        return R.id.material_drawer_profile_item_section;
    }

    @Override
    @LayoutRes
    public int getLayoutRes() {
        return com.mikepenz.materialdrawer.R.layout.material_drawer_item_section;
    }

    @Override
    public void bindView(AccountSectionDrawerItem.ViewHolder viewHolder, List payloads) {
        super.bindView(viewHolder, payloads);

        Context ctx = viewHolder.itemView.getContext();

        //set the identifier from the drawerItem here. It can be used to run tests
        viewHolder.itemView.setId(hashCode());

        //define this item to be not clickable nor enabled
        viewHolder.view.setClickable(false);
        viewHolder.view.setEnabled(false);

        //define the text color
        viewHolder.name.setTextColor(ColorHolder.color(getTextColor(), ctx, com.mikepenz.materialdrawer.R.attr.material_drawer_secondary_text, com.mikepenz.materialdrawer.R.color.material_drawer_secondary_text));

        //set the text for the name
        StringHolder.applyTo(this.getName(), viewHolder.name);

        //define the typeface for our textViews
        if (getTypeface() != null) {
            viewHolder.name.setTypeface(getTypeface());
        }

        //hide the divider if we do not need one
        if (this.hasDivider()) {
            viewHolder.divider.setVisibility(View.VISIBLE);
        } else {
            viewHolder.divider.setVisibility(View.GONE);
        }

        //set the color for the divider
        viewHolder.divider.setBackgroundColor(UIUtils.getThemeColorFromAttrOrRes(ctx, com.mikepenz.materialdrawer.R.attr.material_drawer_divider, com.mikepenz.materialdrawer.R.color.material_drawer_divider));

        //call the onPostBindView method to trigger post bind view actions (like the listener to modify the item if required)
        onPostBindView(this, viewHolder.itemView);

      }

    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private View divider;
        private TextView name;

        private ViewHolder(View view) {
            super(view);
            this.view = view;
            this.divider = view.findViewById(com.mikepenz.materialdrawer.R.id.material_drawer_divider);
            this.name = view.findViewById(com.mikepenz.materialdrawer.R.id.material_drawer_name);
        }
    }

}
