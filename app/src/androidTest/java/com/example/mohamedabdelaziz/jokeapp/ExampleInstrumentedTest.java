package com.example.mohamedabdelaziz.jokeapp;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest  {

    @Test
    public void testVerifyEchoResponse() {
        String result = null;
        EndpointAsyncTask endpointsAsyncTask = new EndpointAsyncTask();
        endpointsAsyncTask.execute(InstrumentationRegistry.getContext());
        try {
            assertTrue(result.equals("this is java joke"));
            result = endpointsAsyncTask.get();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
