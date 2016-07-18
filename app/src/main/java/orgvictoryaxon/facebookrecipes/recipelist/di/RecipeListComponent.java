package orgvictoryaxon.facebookrecipes.recipelist.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.facebookrecipes.lib.di.LibsModule;
import orgvictoryaxon.facebookrecipes.recipelist.RecipeListPresenter;
import orgvictoryaxon.facebookrecipes.recipelist.ui.adapters.RecipesAdapter;

/**
 * Created by VictorYaxon.
 */
@Singleton
@Component(modules = {RecipeListModule.class, LibsModule.class})
public interface RecipeListComponent {
    //void inject(RecipeListActivity activity);
    RecipeListPresenter getPresenter();
    RecipesAdapter getAdapter();
}
