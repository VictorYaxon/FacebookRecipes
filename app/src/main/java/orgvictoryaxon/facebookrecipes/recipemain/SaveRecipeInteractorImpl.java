package orgvictoryaxon.facebookrecipes.recipemain;

import orgvictoryaxon.facebookrecipes.entities.Recipe;

/**
 * Created by ykro.
 */
public class SaveRecipeInteractorImpl implements SaveRecipeInteractor {
    RecipeMainRepository repository;

    public SaveRecipeInteractorImpl(RecipeMainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Recipe recipe) {
        repository.saveRecipe(recipe);
    }
}
