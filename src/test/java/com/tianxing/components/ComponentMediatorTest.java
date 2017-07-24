package com.tianxing.components;

import com.tianxing.components.mediator.ComponentMediator;
import com.tianxing.components.mediator.ComponentMediatorImpl;
import org.junit.Test;

/**
 * Created by tianxing on 2017/3/28.
 */
public class ComponentMediatorTest {

    //@Test
    public void mediator(){
        ComponentMediator mediator = new ComponentMediatorImpl();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
