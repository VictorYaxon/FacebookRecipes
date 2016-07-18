package orgvictoryaxon.facebookrecipes.recipelist.ui;

import java.util.List;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by VictorYaxon.
 */
public interface RecipeListView {
    void setRecipes(List<Recipe> data);
    void recipeUpdated();
    void recipeDeleted(Recipe recipe);
}
