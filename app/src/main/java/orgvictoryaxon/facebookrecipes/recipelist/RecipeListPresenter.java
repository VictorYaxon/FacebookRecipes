package orgvictoryaxon.facebookrecipes.recipelist;

import orgvictoryaxon.facebookrecipes.entities.Recipe;
import orgvictoryaxon.facebookrecipes.recipelist.events.RecipeListEvent;
import orgvictoryaxon.facebookrecipes.recipelist.ui.RecipeListView;

/**
 * Created by VictorYaxon.
 */
public interface RecipeListPresenter {
    void onCreate();
    void onDestroy();

    void getRecipes();
    void removeRecipe(Recipe recipe);
    void toggleFavorite(Recipe recipe);
    void onEventMainThread(RecipeListEvent event);

    RecipeListView getView();
}
