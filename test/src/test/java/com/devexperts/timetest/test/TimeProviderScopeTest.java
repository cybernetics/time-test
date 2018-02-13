package com.devexperts.timetest.test;

/*
 * #%L
 * test
 * %%
 * Copyright (C) 2015 - 2017 Devexperts, LLC
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.devexperts.timetest.TestTimeProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TimeProviderScopeTest {

    @After
    public void tearDown() {
        TestTimeProvider.reset();
    }

    @Test
    public void testTimeProviderInAnotherThread() throws InterruptedException {
        long time = 100;
        TestTimeProvider.start(time);
        MyThread thread = new MyThread();
        thread.start();
        thread.join();
        Assert.assertEquals(time, thread.time);
    }
}
