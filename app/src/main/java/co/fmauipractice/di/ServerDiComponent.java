package co.fmauipractice.di;

import co.fmauipractice.ServerCall.ServerCall;
import dagger.Component;

/**
 * Created by span0008 on 5/1/2017.
 */
@Component(modules = {ServerProviderModule.class})
public interface ServerDiComponent {
    ServerCall serverCaller();
}
