package co.fmauipractice.di;

import co.fmauipractice.ServerCall.ServerCall;
import dagger.Module;
import dagger.Provides;

/**
 * Created by span0008 on 5/1/2017.
 */

@Module
public class ServerProviderModule {

    @Provides
    public ServerCall providesServerCaller(){
        return new ServerCall();
    }
}
