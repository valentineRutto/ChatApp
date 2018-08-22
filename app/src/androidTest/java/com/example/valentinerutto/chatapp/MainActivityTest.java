package com.example.valentinerutto.chatapp;

        import android.support.test.rule.ActivityTestRule;
        import android.view.View;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.junit.runners.JUnit4;

        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.action.ViewActions.click;
        import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
        import static android.support.test.espresso.action.ViewActions.typeText;
        import static android.support.test.espresso.assertion.ViewAssertions.matches;
        import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static android.support.test.espresso.matcher.ViewMatchers.withText;
        import static org.junit.Assert.*;

/**
 * Created by valentinerutto on 8/19/18.
 */
@RunWith(JUnit4.class)

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mainActivity;

    @Before
    public void setUp() throws Exception {
        mainActivity=mainActivityActivityTestRule.getActivity();
    }
    @Test
    public void testLaunch(){
        View view =mainActivity.btnsave;
        assertNotNull(view);
    }

    @Test
    public void testButtonsave(){
        String text="";
        onView(withId(R.id.msgsent)).perform(typeText(text),closeSoftKeyboard());

        onView(withText("SEND")).perform(click());

        onView(withId(R.id.recvmsg))
                .check(matches(withText(text)));
    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }

}