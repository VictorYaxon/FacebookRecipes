package orgvictoryaxon.facebookrecipes.recipelist;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by VictorYaxon.
 */
public class StoredRecipesInteractorImpl implements StoredRecipesInteractor {
    private RecipeListRepository repository;

    public StoredRecipesInteractorImpl(RecipeListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void executeUpdate(Recipe recipe) {
        repository.updateRecipe(recipe);
    }

    @Override
    public void executeDelete(Recipe recipe) {
        repository.removeRecipe(recipe);
    }
}
