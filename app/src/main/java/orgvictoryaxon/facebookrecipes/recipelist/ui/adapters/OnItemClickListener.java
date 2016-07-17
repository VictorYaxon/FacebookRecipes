package orgvictoryaxon.facebookrecipes.recipelist.ui.adapters;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by ykro.
 */
public interface OnItemClickListener {
    void onFavClick(Recipe recipe);
    void onItemClick(Recipe recipe);
    void onDeleteClick(Recipe recipe);
}
