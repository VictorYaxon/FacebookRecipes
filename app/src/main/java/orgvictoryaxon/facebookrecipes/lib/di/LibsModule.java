package orgvictoryaxon.facebookrecipes.lib.di;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import orgvictoryaxon.facebookrecipes.lib.EventBus;
import orgvictoryaxon.facebookrecipes.lib.GlideImageLoader;
import orgvictoryaxon.facebookrecipes.lib.GreenRobotEventBus;
import orgvictoryaxon.facebookrecipes.lib.ImageLoader;

/**
 * Created by VictorYaxon.
 */
@Module
public class LibsModule {
    Activity activity;

    public LibsModule() {
    }
    public LibsModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Activity activity) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (activity != null) {
            imageLoader.setLoaderContext(activity);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    Activity provideActivity(){
        return this.activity;
    }

}
