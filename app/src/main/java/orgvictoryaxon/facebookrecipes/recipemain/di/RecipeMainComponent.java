package orgvictoryaxon.facebookrecipes.recipemain.di;

import javax.inject.Singleton;

import dagger.Component;
import orgvictoryaxon.facebookrecipes.lib.ImageLoader;
import orgvictoryaxon.facebookrecipes.lib.di.LibsModule;
import orgvictoryaxon.facebookrecipes.recipemain.RecipeMainPresenter;

/**
 * Created by ykro.
 */
@Singleton
@Component(modules = {RecipeMainModule.class, LibsModule.class})
public interface RecipeMainComponent {
    //void inject(RecipeMainActivity activity);
    ImageLoader getImageLoader();
    RecipeMainPresenter getPresenter();
}
