package com.example.valentinerutto.chatapp.Service;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * Created by valentinerutto on 8/22/18.
 */
public class SensorServiceTest {
    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();
    @Test
    public void testWithBoundService() throws TimeoutException {
        // Create the service Intent.
        Intent serviceIntent =
                new Intent(InstrumentationRegistry.getTargetContext(),
                        SensorService.class);

}