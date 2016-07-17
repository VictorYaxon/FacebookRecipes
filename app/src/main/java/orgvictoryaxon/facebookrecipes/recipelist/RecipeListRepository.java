package orgvictoryaxon.facebookrecipes.recipelist;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by ykro.
 */
public interface RecipeListRepository {
    void getSavedRecipes();
    void updateRecipe(Recipe recipe);
    void removeRecipe(Recipe recipe);
}
