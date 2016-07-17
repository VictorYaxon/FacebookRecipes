package orgvictoryaxon.facebookrecipes.recipemain;

import orgvictoryaxon.facebookrecipes.entities.Recipe;
import orgvictoryaxon.facebookrecipes.recipemain.events.RecipeMainEvent;
import orgvictoryaxon.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by ykro.
 */
public interface RecipeMainPresenter {
    void onCreate();
    void onDestroy();

    void dismissRecipe();
    void getNextRecipe();
    void saveRecipe(Recipe recipe);
    void onEventMainThread(RecipeMainEvent event);

    RecipeMainView getView();
}
