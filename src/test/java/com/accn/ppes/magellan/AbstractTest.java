package com.accn.ppes.magellan;


import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accn.ppes.magellan.LocationApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=LocationApplication.class)
@WebAppConfiguration
public abstract class AbstractTest {


}
