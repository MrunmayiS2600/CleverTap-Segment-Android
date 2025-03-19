//package com.example.segmentnativeandroid;
//
//import android.app.NotificationManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.clevertap.android.sdk.ActivityLifecycleCallback;
//import com.clevertap.android.sdk.CleverTapAPI;
//import com.segment.analytics.Analytics;
//import com.segment.analytics.Properties;
//import com.segment.analytics.Traits;
//import com.segment.analytics.android.integrations.clevertap.CleverTapIntegration;
//
//import java.util.Date;
//
//public class MainActivity extends AppCompatActivity {
//
//
//    //private static final String TAG = String.format("%s.%s", "CLEVERTAP", CleverTapSegmentApplication.class.getName());
//    private static final String TAG = "CLEVERTAP";
//    private static final String CLEVERTAP_KEY = "CleverTap";
//    String WRITE_KEY = "FqgiVUJ87YoBaXNDmO0yAcep2jw1l3tF"; //This you will receive under source in segment.
//    public static boolean sCleverTapSegmentEnabled = false;
//    private CleverTapAPI cleverTapInstance;
//    private Analytics analytics;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)  {
//        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
//
//        ActivityLifecycleCallback.register(getApplication());
//        super.onCreate(savedInstanceState);
//        analytics = new Analytics.Builder(getApplicationContext(), WRITE_KEY)
//                .logLevel(Analytics.LogLevel.VERBOSE)
//                .use(CleverTapIntegration.FACTORY)
//                .build();
//
//        analytics.onIntegrationReady(CLEVERTAP_KEY, new Analytics.Callback<CleverTapAPI>() {
//            @Override
//            public void onReady(CleverTapAPI instance) {
//                Log.i(TAG, "analytics.onIntegrationReady() called");
//                CleverTapIntegrationReady(instance);
//            }
//        });
//        Analytics.setSingletonInstance(analytics);
//
//
//        Traits traits = new Traits();
//        traits.putEmail("foo@foo.com");
//        traits.putName("FooName");
//        traits.putPhone("+14155551234");
//        Analytics.with(getApplicationContext()).identify(String.valueOf(61026032), traits, null);
////Replace all the example values with your required dynamic ones.
//        Analytics.with(getApplicationContext()).track("testEvent",
//                new Properties().putValue("value", "testValue") .putValue("testDate", new Date(System.currentTimeMillis()))
//        );
//
//        final String orderId = "123456";
//        final int revenue = 100;
//        Properties properties = new Properties();
//        properties.putValue("orderId", orderId);
//        properties.putValue("revenue", revenue);
//        Properties.Product product1 = new Properties.Product("id1", "sku1", 100);
//        Properties.Product product2 = new Properties.Product("id2", "sku2", 200);
//        properties.putProducts(product1, product2);
//        Analytics.with(getApplicationContext()).track("Order Completed", properties);
//
//
//
//    }
//
//    private void CleverTapIntegrationReady(CleverTapAPI instance) {
//        instance.enablePersonalization();
//        sCleverTapSegmentEnabled = true;
//        cleverTapInstance = instance;
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CleverTapAPI.createNotificationChannel(getApplicationContext(), "Promotion", "Promotion Channel",
//                    "For Promotion PN",
//                    NotificationManager.IMPORTANCE_MAX, true);
//        }
//    }
//
//    public CleverTapAPI getCleverTapInstance() {
//        return cleverTapInstance;
//    }
//
//    public Analytics getAnalytics() {
//        return analytics;
//    }
//
//
//}

//package com.example.segmentnativeandroid;
//
//import android.app.NotificationManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.clevertap.android.sdk.ActivityLifecycleCallback;
//import com.clevertap.android.sdk.CleverTapAPI;
//import com.segment.analytics.Analytics;
//import com.segment.analytics.Properties;
//import com.segment.analytics.Traits;
//import com.segment.analytics.android.integrations.clevertap.CleverTapIntegration;
//
//import java.util.Date;
//
//public class MainActivity extends AppCompatActivity {
//
//    private static final String TAG = "CLEVERTAP";
//    private static final String CLEVERTAP_KEY = "CleverTap";
//    String WRITE_KEY = "FqgiVUJ87YoBaXNDmO0yAcep2jw1l3tF"; // Your Segment write key
//    public static boolean sCleverTapSegmentEnabled = false;
//    private CleverTapAPI cleverTapInstance;
//    private Analytics analytics;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);  // Make sure to set the layout
//
//        // Initialize CleverTap and Segment Analytics
//        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
//        ActivityLifecycleCallback.register(getApplication());
//
//        analytics = new Analytics.Builder(getApplicationContext(), WRITE_KEY)
//                .logLevel(Analytics.LogLevel.VERBOSE)
//                .use(CleverTapIntegration.FACTORY)
//                .build();
//
//        analytics.onIntegrationReady(CLEVERTAP_KEY, new Analytics.Callback<CleverTapAPI>() {
//            @Override
//            public void onReady(CleverTapAPI instance) {
//                Log.i(TAG, "analytics.onIntegrationReady() called");
//                CleverTapIntegrationReady(instance);
//            }
//        });
//        Analytics.setSingletonInstance(analytics);
//
//        // Find buttons and set their listeners
//        Button identifyUserButton = findViewById(R.id.identifyUserButton);
//        identifyUserButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Identify User event
//                Traits traits = new Traits();
//                traits.putEmail("foo@foo.com");
//                traits.putName("FooName");
//                traits.putPhone("+14155551234");
//                Analytics.with(getApplicationContext()).identify(String.valueOf(61026032), traits, null);
//                Log.i(TAG, "User Identified");
//            }
//        });
//
//        Button trackTestEventButton = findViewById(R.id.trackTestEventButton);
//        trackTestEventButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Track Test Event
//                Analytics.with(getApplicationContext()).track("testEvent",
//                        new Properties().putValue("value", "testValue")
//                                .putValue("testDate", new Date(System.currentTimeMillis())));
//                Log.i(TAG, "Test Event Tracked");
//            }
//        });
//
//        Button pushButton = findViewById(R.id.PushB);
//        pushButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Ensure you have the CleverTap instance initialized
//                if (cleverTapInstance != null) {
//                    // Track Push Notification Event
//                    cleverTapInstance.pushEvent("Android Event");
//                    Log.i(TAG, "Push Notification Triggered");
//                } else {
//                    Log.e(TAG, "CleverTap instance is not initialized");
//                }
//            }
//        });
//
//
//        Button trackOrderCompletedButton = findViewById(R.id.trackOrderCompletedButton);
//        trackOrderCompletedButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Track Order Completed event
//                final String orderId = "123456";
//                final int revenue = 100;
//                Properties properties = new Properties();
//                properties.putValue("orderId", orderId);
//                properties.putValue("revenue", revenue);
//                Properties.Product product1 = new Properties.Product("id1", "sku1", 100);
//                Properties.Product product2 = new Properties.Product("id2", "sku2", 200);
//                properties.putProducts(product1, product2);
//                Analytics.with(getApplicationContext()).track("Order Completed", properties);
//                Log.i(TAG, "Order Completed Event Tracked");
//            }
//        });
//    }
//
//    private void CleverTapIntegrationReady(CleverTapAPI instance) {
//        instance.enablePersonalization();
//        sCleverTapSegmentEnabled = true;
//        cleverTapInstance = instance;
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CleverTapAPI.createNotificationChannel(getApplicationContext(), "HI", "Promotion Channel",
//                    "For Promotion PN", NotificationManager.IMPORTANCE_MAX, true);
//        }
//    }
//
//    public CleverTapAPI getCleverTapInstance() {
//        return cleverTapInstance;
//    }
//
//    public Analytics getAnalytics() {
//        return analytics;
//    }
//}
//


//
//package com.example.segmentnativeandroid;
//
//import android.app.NotificationManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.clevertap.android.sdk.ActivityLifecycleCallback;
//import com.clevertap.android.sdk.CTInboxListener;
//import com.clevertap.android.sdk.CleverTapAPI;
//import com.clevertap.android.sdk.CTInboxStyleConfig;
//import com.segment.analytics.Analytics;
//import com.segment.analytics.Properties;
//import com.segment.analytics.Traits;
//import com.segment.analytics.android.integrations.clevertap.CleverTapIntegration;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//public class MainActivity extends AppCompatActivity implements CTInboxListener { // Make sure to implement CTInboxListener interface
//
//    private static final String TAG = "CLEVERTAP";
//    private static final String CLEVERTAP_KEY = "CleverTap";
//    String WRITE_KEY = "FqgiVUJ87YoBaXNDmO0yAcep2jw1l3tF"; // Your Segment write key
//    public static boolean sCleverTapSegmentEnabled = false;
//    private CleverTapAPI cleverTapInstance;
//    private Analytics analytics;
//    private CleverTapAPI ctApiGlobalInstance = null;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        setContentView(R.layout.activity_main);  // Make sure to set the layout
//
//        // Initialize CleverTap and Segment Analytics
//        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
//
//        ActivityLifecycleCallback.register(getApplication());
//
//        analytics = new Analytics.Builder(getApplicationContext(), WRITE_KEY)
//                .logLevel(Analytics.LogLevel.VERBOSE)
//                .use(CleverTapIntegration.FACTORY)
//                .build();
//
//        analytics.onIntegrationReady(CLEVERTAP_KEY, new Analytics.Callback<CleverTapAPI>() {
//            @Override
//            public void onReady(CleverTapAPI instance) {
//                Log.i(TAG, "analytics.onIntegrationReady() called");
//                CleverTapIntegrationReady(instance);
//            }
//        });
//        Analytics.setSingletonInstance(analytics);
//
//        // Find buttons and set their listeners
//        Button identifyUserButton = findViewById(R.id.identifyUserButton);
//        identifyUserButton.setOnClickListener(v -> {
//            // Identify User event
//            Traits traits = new Traits();
//            traits.putEmail("mrunnnn@gmail.com");
//            traits.putName("Mrunnnnn");
//            traits.putPhone("+14155557890");
//            Analytics.with(getApplicationContext()).identify(String.valueOf(61026031), traits, null);
//            Log.i(TAG, "User Identified");
//        });
//
//        Button trackTestEventButton = findViewById(R.id.trackTestEventButton);
//        trackTestEventButton.setOnClickListener(v -> {
//            // Track Test Event
//            Analytics.with(getApplicationContext()).track("testEvent",
//                    new Properties().putValue("value", "testValue")
//                            .putValue("testDate", new Date(System.currentTimeMillis())));
//            Log.i(TAG, "Test Event Tracked");
//        });
//
//        Button pushButton = findViewById(R.id.PushB);
//        pushButton.setOnClickListener(v -> {
//            // Ensure you have the CleverTap instance initialized
//            if (cleverTapInstance != null) {
//                // Track Push Notification Event
//                cleverTapInstance.pushEvent("Android Event");
//                Analytics.with(getApplicationContext()).track("Push Notification");
//                Log.i(TAG, "Push Notification Triggered");
//            } else {
//                Log.e(TAG, "CleverTap instance is not initialized");
//            }
//        });
//
//        Button trackOrderCompletedButton = findViewById(R.id.trackOrderCompletedButton);
//        trackOrderCompletedButton.setOnClickListener(v -> {
//            // Track Order Completed event
//            final String orderId = "123456";
//            final int revenue = 100;
//            Properties properties = new Properties();
//            properties.putValue("orderId", orderId);
//            properties.putValue("revenue", revenue);
//            Properties.Product product1 = new Properties.Product("id1", "sku1", 100);
//            Properties.Product product2 = new Properties.Product("id2", "sku2", 200);
//            properties.putProducts(product1, product2);
//            Analytics.with(getApplicationContext()).track("Order Completed", properties);
//            Log.i(TAG, "Order Completed Event Tracked");
//        });
//    }
//
//    private void CleverTapIntegrationReady(CleverTapAPI instance) {
//        instance.enablePersonalization();
//        sCleverTapSegmentEnabled = true;
//        cleverTapInstance = instance;
//
//        // Register Notification Channel for Android Oreo (API 26) and above
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CleverTapAPI.createNotificationChannel(getApplicationContext(), "HI", "Promotion Channel",
//                    "For Promotion PN", NotificationManager.IMPORTANCE_MAX, true);
//        }
//
//        // Set up the CleverTap inbox listener and initialize inbox
//        ctApiGlobalInstance = instance;
//        ctApiGlobalInstance.setCTNotificationInboxListener(this);  // Now, this is valid
//        ctApiGlobalInstance.initializeInbox();  // Initialize inbox
//    }
//
//    @Override
//    public void inboxDidInitialize() {
//        Analytics.with(getApplicationContext()).track("InboxEvent");
//        // Add an on click to your inbox button to call showAppInbox() with custom or default styling
//        Button yourInboxButton = findViewById(R.id.Inbox); // Make sure you have a button with this ID in your layout
//        yourInboxButton.setOnClickListener(v -> {
//            ArrayList<String> tabs = new ArrayList<>();
//            tabs.add("Promotions");
//            tabs.add("Offers"); // We support up to 2 tabs only. Additional tabs will be ignored
//
//            CTInboxStyleConfig styleConfig = new CTInboxStyleConfig();
//            styleConfig.setFirstTabTitle("First Tab");
//            styleConfig.setTabs(tabs); // Do not use this if you don't want to use tabs
//            styleConfig.setTabBackgroundColor("#FF0000");
//            styleConfig.setSelectedTabIndicatorColor("#0000FF");
//            styleConfig.setSelectedTabColor("#0000FF");
//            styleConfig.setUnselectedTabColor("#FFFFFF");
//            styleConfig.setBackButtonColor("#FF0000");
//            styleConfig.setNavBarTitleColor("#FF0000");
//            styleConfig.setNavBarTitle("MY INBOX");
//            styleConfig.setNavBarColor("#FFFFFF");
//            styleConfig.setInboxBackgroundColor("#ADD8E6");
//
//            if (ctApiGlobalInstance != null) {
//                ctApiGlobalInstance.showAppInbox(styleConfig); // With Tabs
//                // ctApiGlobalInstance.showAppInbox(); // Opens Activity with default style configs
//            }
//        });
//    }
//
//    @Override
//    public void inboxMessagesDidUpdate() {
//        // Callback on Inbox Message update/delete/read (any activity)
//        Log.i(TAG, "Inbox messages updated");
//    }
//
//    public CleverTapAPI getCleverTapInstance() {
//        return cleverTapInstance;
//    }
//
//    public Analytics getAnalytics() {
//        return analytics;
//    }
//}

package com.example.segmentnativeandroid;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CTInboxListener;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.displayunits.DisplayUnitListener;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.segment.analytics.Analytics;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.android.integrations.clevertap.CleverTapIntegration;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements CTInboxListener, DisplayUnitListener {

    private static final String TAG = "CLEVERTAP";
    private static final String CLEVERTAP_KEY = "CleverTap";
    String WRITE_KEY = "FqgiVUJ87YoBaXNDmO0yAcep2jw1l3tF"; // Your Segment write key
    public static boolean sCleverTapSegmentEnabled = false;
    private CleverTapAPI cleverTapInstance;
    private Analytics analytics;
    private CleverTapAPI ctApiGlobalInstance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Initialize CleverTap and Segment Analytics
            CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
            ActivityLifecycleCallback.register(getApplication());

            // Single initialization for Segment and CleverTap
            analytics = new Analytics.Builder(getApplicationContext(), WRITE_KEY)
                    .logLevel(Analytics.LogLevel.VERBOSE)
                    .use(CleverTapIntegration.FACTORY)
                    .build();

            Analytics.setSingletonInstance(analytics);

            // Set up CleverTap integration with both inbox and display unit listeners
            analytics.onIntegrationReady(CLEVERTAP_KEY, new Analytics.Callback<CleverTapAPI>() {
                @Override
                public void onReady(CleverTapAPI instance) {
                    Log.i(TAG, "analytics.onIntegrationReady() called");
                    cleverTapIntegrationReady(instance);
                }
            });

            // Set up button click listeners
            setupButtonListeners();

        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate: " + e.getMessage(), e);
        }
    }

    private void setupButtonListeners() {
        try {
            Button identifyUserButton = findViewById(R.id.identifyUserButton);
            identifyUserButton.setOnClickListener(v -> {
                try {
                    // Identify User event
                    Traits traits = new Traits();
                    traits.putEmail("abc@foo.com");
                    traits.putName("M1");
                    traits.putPhone("+14155555277");
                    Analytics.with(getApplicationContext()).identify(String.valueOf(61089032), traits, null);
                    Log.i(TAG, "User Identified");
                } catch (Exception e) {
                    Log.e(TAG, "Error in identify user: " + e.getMessage(), e);
                }
            });

            Button trackTestEventButton = findViewById(R.id.trackTestEventButton);
            trackTestEventButton.setOnClickListener(v -> {
                try {
                    // Track Test Event
                    Analytics.with(getApplicationContext()).track("testEvent",
                            new Properties().putValue("value", "testValue")
                                    .putValue("testDate", new Date(System.currentTimeMillis())));
                    Log.i(TAG, "Test Event Tracked");
                } catch (Exception e) {
                    Log.e(TAG, "Error in track test event: " + e.getMessage(), e);
                }
            });
            Button Inappbutton = findViewById(R.id.inapp);
            Inappbutton.setOnClickListener(v -> {
                try {
                    // Ensure you have the CleverTap instance initialized
                    if (cleverTapInstance != null) {
                        // Track Push Notification Event
                        cleverTapInstance.pushEvent("In-app Notification Triggered");
                        Analytics.with(getApplicationContext()).track("Inapp");
                        Log.i(TAG, "Inapp triggered");
                    } else {
                        Log.e(TAG, "CleverTap instance is not initialized");
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error in inapp notification: " + e.getMessage(), e);
                }
            });


            Button pushButton = findViewById(R.id.PushB);
            pushButton.setOnClickListener(v -> {
                try {
                    // Ensure you have the CleverTap instance initialized
                    if (cleverTapInstance != null) {
                        // Track Push Notification Event
                        cleverTapInstance.pushEvent("Android Event");
                        Analytics.with(getApplicationContext()).track("Push Notification");
                        Log.i(TAG, "Push Notification Triggered");
                    } else {
                        Log.e(TAG, "CleverTap instance is not initialized");
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error in push notification: " + e.getMessage(), e);
                }
            });

            Button trackOrderCompletedButton = findViewById(R.id.trackOrderCompletedButton);
            trackOrderCompletedButton.setOnClickListener(v -> {
                try {
                    // Track Order Completed event
                    final String orderId = "123456";
                    final int revenue = 100;
                    Properties properties = new Properties();
                    properties.putValue("orderId", orderId);
                    properties.putValue("revenue", revenue);
                    Properties.Product product1 = new Properties.Product("id1", "sku1", 100);
                    Properties.Product product2 = new Properties.Product("id2", "sku2", 200);
                    properties.putProducts(product1, product2);
                    Analytics.with(getApplicationContext()).track("Order Completed", properties);
                    Log.i(TAG, "Order Completed Event Tracked");
                } catch (Exception e) {
                    Log.e(TAG, "Error in track order: " + e.getMessage(), e);
                }
            });

            // Add this if you have the loadDisplayUnitsButton in your layout
            if (findViewById(R.id.loadDisplayUnitsButton) != null) {
                Button loadDisplayUnitsButton = findViewById(R.id.loadDisplayUnitsButton);
                loadDisplayUnitsButton.setOnClickListener(v -> {
                   // ctApiGlobalInstance.pushEvent("Native Display");
                    //cleverTapInstance.pushEvent("Native Display");
                    try {
                        if (ctApiGlobalInstance != null) {

                            ctApiGlobalInstance.pushEvent("Native Display");

                            ctApiGlobalInstance.setDisplayUnitListener(this);
                            // Manually fetch display units
                            ctApiGlobalInstance.getAllDisplayUnits();




                            Log.i(TAG, "Requesting display units");
                            Analytics.with(getApplicationContext()).track("Native Display");
                        } else {
                            Log.e(TAG, "CleverTap instance is not initialized");
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Error loading display units: " + e.getMessage(), e);
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Error setting up buttons: " + e.getMessage(), e);
        }
    }

    private void cleverTapIntegrationReady(CleverTapAPI instance) {
        try {
            instance.enablePersonalization();
            sCleverTapSegmentEnabled = true;
            cleverTapInstance = instance;
            ctApiGlobalInstance = instance;

            // Register Notification Channel for Android Oreo (API 26) and above
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                CleverTapAPI.createNotificationChannel(getApplicationContext(), "HI", "Promotion Channel",
                        "For Promotion PN", NotificationManager.IMPORTANCE_MAX, true);
            }

            // Set up both listeners
            ctApiGlobalInstance.setCTNotificationInboxListener(this);


            // Initialize inbox
            ctApiGlobalInstance.initializeInbox();

            // Get display units
            ctApiGlobalInstance.getAllDisplayUnits();

        } catch (Exception e) {
            Log.e(TAG, "Error in cleverTapIntegrationReady: " + e.getMessage(), e);
        }
    }

    @Override
    public void inboxDidInitialize() {
        try {
            Analytics.with(getApplicationContext()).track("InboxEvent");
            // Add an on click to your inbox button to call showAppInbox() with custom or default styling
            Button yourInboxButton = findViewById(R.id.Inbox);
            if (yourInboxButton != null) {
                yourInboxButton.setOnClickListener(v -> {
                    try {
                        ArrayList<String> tabs = new ArrayList<>();
                        tabs.add("Promotions");
                        tabs.add("Offers");

                        CTInboxStyleConfig styleConfig = new CTInboxStyleConfig();
                        styleConfig.setFirstTabTitle("First Tab");
                        styleConfig.setTabs(tabs);
                        styleConfig.setTabBackgroundColor("#FF0000");
                        styleConfig.setSelectedTabIndicatorColor("#0000FF");
                        styleConfig.setSelectedTabColor("#0000FF");
                        styleConfig.setUnselectedTabColor("#FFFFFF");
                        styleConfig.setBackButtonColor("#FF0000");
                        styleConfig.setNavBarTitleColor("#FF0000");
                        styleConfig.setNavBarTitle("MY INBOX");
                        styleConfig.setNavBarColor("#FFFFFF");
                        styleConfig.setInboxBackgroundColor("#ADD8E6");

                        if (ctApiGlobalInstance != null) {
                            ctApiGlobalInstance.showAppInbox(styleConfig);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Error showing inbox: " + e.getMessage(), e);
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in inboxDidInitialize: " + e.getMessage(), e);
        }
    }

    @Override
    public void inboxMessagesDidUpdate() {
        // Callback on Inbox Message update/delete/read (any activity)
        Log.i(TAG, "Inbox messages updated");
    }

    @Override
    public void onDisplayUnitsLoaded(ArrayList<CleverTapDisplayUnit> units) {
        try {
            Log.i(TAG, "Display units loaded: " + units.size());
            // Process display units
            if (units != null && units.size() > 0) {
                for (int i = 0; i < units.size(); i++) {
                    CleverTapDisplayUnit unit = units.get(i);
                    prepareDisplayView(unit);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in onDisplayUnitsLoaded: " + e.getMessage(), e);
        }
    }

    private void prepareDisplayView(CleverTapDisplayUnit unit) {
        try {
            Log.i(TAG, "Preparing display unit: " + unit.getUnitID());

            // Check if the container exists in the layout
            FrameLayout container = findViewById(R.id.displayUnitContainer);
            if (container == null) {
                Log.e(TAG, "Display unit container not found in layout");
                return;
            }

            // Clear existing content
            container.removeAllViews();

            // Check if unit has contents
            if (unit.getContents() == null || unit.getContents().isEmpty()) {
                Log.e(TAG, "Display unit has no contents");
                return;
            }
            // Get ImageView reference
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));

            // Load image from CleverTap Display Unit
            String imageUrl = unit.getContents().get(0).getMedia();
            if (imageUrl != null && !imageUrl.isEmpty()) {
                Glide.with(this).load(imageUrl).into(imageView); // Requires Glide library
            } else {
                Log.e(TAG, "No image URL found for display unit");
            }

            // Add ImageView to container
            container.addView(imageView);
            // Record Impression
            ctApiGlobalInstance.pushDisplayUnitViewedEventForID(unit.getUnitID());

            // Set click listener
            imageView.setOnClickListener(v -> ctApiGlobalInstance.pushDisplayUnitClickedEventForID(unit.getUnitID()));


            // Create a simple text view to display the unit
            TextView displayView = new TextView(this);
            displayView.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));

            // Set content from the unit
            displayView.setText(unit.getContents().get(0).getTitle());
            displayView.setTextSize(18);
            displayView.setPadding(16, 16, 16, 16);

            // Add the view to container
            container.addView(displayView);

            // Record impression for this unit
            ctApiGlobalInstance.pushDisplayUnitViewedEventForID(unit.getUnitID());

            // Set click listener
            displayView.setOnClickListener(v -> {
                ctApiGlobalInstance.pushDisplayUnitClickedEventForID(unit.getUnitID());
                // Handle the click action if needed
            });
        } catch (Exception e) {
            Log.e(TAG, "Error in prepareDisplayView: " + e.getMessage(), e);
        }
    }

    public CleverTapAPI getCleverTapInstance() {
        return cleverTapInstance;
    }

    public Analytics getAnalytics() {
        return analytics;
    }
}