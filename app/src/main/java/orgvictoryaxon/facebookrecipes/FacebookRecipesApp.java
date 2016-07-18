package orgvictoryaxon.facebookrecipes;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raizlabs.android.dbflow.config.FlowManager;

import orgvictoryaxon.facebookrecipes.lib.di.LibsModule;
import orgvictoryaxon.facebookrecipes.recipelist.di.DaggerRecipeListComponent;
import orgvictoryaxon.facebookrecipes.recipelist.di.RecipeListComponent;
import orgvictoryaxon.facebookrecipes.recipelist.di.RecipeListModule;
import orgvictoryaxon.facebookrecipes.recipelist.ui.RecipeListActivity;
import orgvictoryaxon.facebookrecipes.recipelist.ui.RecipeListView;
import orgvictoryaxon.facebookrecipes.recipelist.ui.adapters.OnItemClickListener;
import orgvictoryaxon.facebookrecipes.recipemain.di.DaggerRecipeMainComponent;
import orgvictoryaxon.facebookrecipes.recipemain.di.RecipeMainComponent;
import orgvictoryaxon.facebookrecipes.recipemain.di.RecipeMainModule;
import orgvictoryaxon.facebookrecipes.recipemain.ui.RecipeMainActivity;
import orgvictoryaxon.facebookrecipes.recipemain.ui.RecipeMainView;

/**
 * Created by VictorYaxon.
 */
public class FacebookRecipesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
        initFacebook();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    public RecipeMainComponent getRecipeMainComponent(RecipeMainActivity activity, RecipeMainView view) {
        return DaggerRecipeMainComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeMainModule(new RecipeMainModule(view))
                .build();
    }

    public RecipeListComponent getRecipeListComponent(RecipeListActivity activity, RecipeListView view, OnItemClickListener onItemClickListener) {
        return DaggerRecipeListComponent
                .builder()
                .libsModule(new LibsModule(activity))
                .recipeListModule(new RecipeListModule(view, onItemClickListener))
                .build();
    }
}
