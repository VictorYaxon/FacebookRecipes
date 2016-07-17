package orgvictoryaxon.facebookrecipes.recipemain.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.facebookrecipes.api.RecipeClient;
import orgvictoryaxon.facebookrecipes.api.RecipeService;
import orgvictoryaxon.facebookrecipes.lib.EventBus;
import orgvictoryaxon.facebookrecipes.recipemain.GetNextRecipeInteractor;
import orgvictoryaxon.facebookrecipes.recipemain.GetNextRecipeInteractorImpl;
import orgvictoryaxon.facebookrecipes.recipemain.RecipeMainPresenter;
import orgvictoryaxon.facebookrecipes.recipemain.RecipeMainPresenterImpl;
import orgvictoryaxon.facebookrecipes.recipemain.RecipeMainRepository;
import orgvictoryaxon.facebookrecipes.recipemain.RecipeMainRepositoryImpl;
import orgvictoryaxon.facebookrecipes.recipemain.SaveRecipeInteractor;
import orgvictoryaxon.facebookrecipes.recipemain.SaveRecipeInteractorImpl;
import orgvictoryaxon.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by ykro.
 */
@Module
public class RecipeMainModule {
    RecipeMainView view;

    public RecipeMainModule(RecipeMainView view) {
        this.view = view;
    }

    @Provides @Singleton
    RecipeMainView provideRecipeMainView() {
        return this.view;
    }

    @Provides @Singleton
    RecipeMainPresenter provideRecipeMainPresenter(EventBus eventBus, RecipeMainView view, SaveRecipeInteractor save, GetNextRecipeInteractor getNext) {
        return new RecipeMainPresenterImpl(eventBus, view, save, getNext);
    }

    @Provides @Singleton
    SaveRecipeInteractor provideSaveRecipeInteractor(RecipeMainRepository repository) {
        return new SaveRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    GetNextRecipeInteractor provideGetNextRecipeInteractor(RecipeMainRepository repository) {
        return new GetNextRecipeInteractorImpl(repository);
    }

    @Provides @Singleton
    RecipeMainRepository provideRecipeMainRepository(EventBus eventBus, RecipeService service) {
        return new RecipeMainRepositoryImpl(eventBus, service);
    }

    @Provides
    @Singleton
    RecipeService provideRecipeService() {
        RecipeClient client = new RecipeClient();
        return client.getRecipeService();
    }
}
