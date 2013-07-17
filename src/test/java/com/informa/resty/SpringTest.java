package com.informa.resty;

import com.informa.resty.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by bethella on 16/07/13.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationConfig.class},
        loader = AnnotationConfigContextLoader.class )
public class SpringTest{

    @Test
    public void whenSpringContextIsInstantiated_thenNoExceptions(){
        // When
    }
}
