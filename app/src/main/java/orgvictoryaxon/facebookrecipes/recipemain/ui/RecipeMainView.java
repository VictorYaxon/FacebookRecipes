package orgvictoryaxon.facebookrecipes.recipemain.ui;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by ykro.
 */
public interface RecipeMainView {
    void showProgress();
    void hideProgress();
    void showUIElements();
    void hideUIElements();
    void saveAnimation();
    void dismissAnimation();

    void onRecipeSaved();
    void setRecipe(Recipe recipe);
    void onGetRecipeError(String error);
}
