package org.bubus.zambara.reader;

import org.bubus.zambara.context.Context;

public interface BeanDefinitionReader {
    void scan();
    Context run();
}
