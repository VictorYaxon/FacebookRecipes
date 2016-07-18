package orgvictoryaxon.facebookrecipes.recipelist.di;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.facebookrecipes.entities.Recipe;
import orgvictoryaxon.facebookrecipes.lib.EventBus;
import orgvictoryaxon.facebookrecipes.lib.ImageLoader;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListInteractor;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListInteractorImpl;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListPresenter;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListPresenterImpl;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListRepository;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListRepositoryImpl;
import orgvictoryaxon.facebookrecipes.recipelist.StoredRecipesInteractor;
import orgvictoryaxon.facebookrecipes.recipelist.StoredRecipesInteractorImpl;
import orgvictoryaxon.facebookrecipes.recipelist.ui.RecipeListView;
import orgvictoryaxon.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import orgvictoryaxon.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;

/**
 * Created by VictorYaxon.
 */
@Module
public class RecipeListModule {
    RecipeListView view;
    OnItemClickListener onItemClickListener;

    public RecipeListModule(RecipeListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    RecipeListView provideRecipeListView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeListPresenter provideRecipeListPresenter(EventBus eventBus, RecipeListView view, RecipeListInteractor listInteractor, StoredRecipesInteractor storedInteractor) {
        return new RecipeListPresenterImpl(eventBus, view, listInteractor, storedInteractor);
    }

    @Provides @Singleton
    RecipeListInteractor provideRecipeListInteractor(RecipeListRepository repository) {
        return new RecipeListInteractorImpl(repository);
    }

    @Provides @Singleton
    StoredRecipesInteractor provideStoredRecipesInteractor(RecipeListRepository repository) {
        return new StoredRecipesInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeListRepository provideRecipeListRepository(EventBus eventBus) {
        return new RecipeListRepositoryImpl(eventBus);
    }

    @Provides @Singleton
    RecipesAdapter provideRecipesAdapter(List<Recipe> recipes, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new RecipesAdapter(recipes, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener provideOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides @Singleton
    List<Recipe> provideRecipesList() {
        return new ArrayList<Recipe>();
    }

}
