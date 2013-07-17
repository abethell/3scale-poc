package com.informa.resty;

import com.informa.resty.config.WebConfig;
import com.informa.resty.web.HelloController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Created by bethella on 17/07/13.
 */
@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration( classes = WebConfig.class)
public class WebTest {

    @Resource
    private HelloController helloController;

    @Test
    public void testController() {

        String output = helloController.getHello("68b8c68b", "1a13bb5f0e0659809a7c6a4b1f294319");
        Assert.assertNotNull(output);
        Assert.assertEquals(output, "HEY THERE");
    }

}
