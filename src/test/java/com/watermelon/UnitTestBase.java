package com.watermelon;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by wangjue05 on 16/8/26.
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class UnitTestBase {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initial() {
        MockitoAnnotations.initMocks(this);
    }
}
