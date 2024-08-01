package org.bubus.zambara.listener;

import org.bubus.zambara.annotation.Component;
import org.bubus.zambara.configurator.ContextConfigurator;
import org.bubus.zambara.context.state.ContextState;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Component
public interface ContextListener<T extends ContextState> extends ContextConfigurator {
    void listen();
    default Class<T> getConfiguratorType(){
        for (Type genericInterface : getClass().getGenericInterfaces()) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) genericInterface;
                return (Class<T>) (type).getActualTypeArguments()[0];
            }
        }
        throw new RuntimeException("Error get ContextListener type [" + this +"]");
    };

    default <S extends ContextState> boolean support(Class<S> contextState){
        return getConfiguratorType().equals(contextState);
    }
}
