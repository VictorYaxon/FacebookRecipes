package orgvictoryaxon.facebookrecipes.recipelist;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by ykro.
 */
public interface StoredRecipesInteractor {
    void executeUpdate(Recipe recipe);
    void executeDelete(Recipe recipe);
}
