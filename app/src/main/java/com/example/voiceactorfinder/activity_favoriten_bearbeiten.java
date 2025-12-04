package com.example.voiceactorfinder;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class activity_favoriten_bearbeiten extends AppCompatActivity {

    // Declaring TextView from the Layout
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoriten_bearbeiten);

        // initializing the TextView
        textview = findViewById(R.id.text);

        // Creating a string that contains the information to be displayed
        String para = "JAVA IS A TECHNOLOGY OF CHOICE FOR BUILDING APPLICATIONS" +
                " USING MANAGED CODES THAT CAN EXECUTE ON MOBILE DEVICES.\n" +
                "\n" +
                "Android is an open source software platform and Linux-based" +
                " operating system for mobile devices. The Android platform " +
                "allows developers to write managed code using Java to manage " +
                "and control the Android device. Android applications can be" +
                " developed by using the Java programming language and the " +
                "Android SDK. So, familiarity with the basics of the Java " +
                "programming language is a prerequisite for programming on" +
                " the Android platform. This article discusses where Java fits" +
                " in mobile application development and how we can use Java and" +
                " Android SDK to write applications that can work on Android devices.\n" +
                "\n" +
                "THE CHOICE OF JAVA\n" +
                "\n "+
                "What made Java be the technology of choice for mobile development for the" +
                " Android platform? The Java Programming Language emerged in the mid-1990s;" +
                " it was created by James Gosling of Sun Microsystems. Incidentally," +
                " Sun Microsystems was since bought by Oracle." +
                " Java has been widely popular the world over, " +
                "primarily because of a vast array of features it provides. " +
                "Java’s promise of “Write once and run anywhere” was one of the major" +
                " factors for the success of Java over the past few decades.\n" +
                "\n" +
                "Java even made inroads into embedded processors technology as well;" +
                " the Java Mobile Edition was built for creating applications " +
                "that can run on mobile devices. All these, added to Java’s meteoric rise," +
                " were the prime factors that attributed to the decision of adopting " +
                "Java as the primary development language for building " +
                "applications that run on Android. Java programs are secure because" +
                " they run within a sandbox environment. Programs written in Java are compiled " +
                "into intermediate code known as bytecode. This bytecode is then executed inside" +
                " the context of the Java Virtual Machine. You can learn more about Java from" +
                " this link.\n" +
                "\n" +
                "USING JAVA FOR BUILDING MOBILE APPLICATIONS\n" +
                "\n" +
                "The mobile edition of Java is called Java ME. Java ME is based on Java " +
                "SE and is supported by most smartphones and tablets. The Java Platform" +
                " Micro Edition (Java ME) provides a flexible, secure environment for" +
                " building and executing applications that are targeted at embedded and " +
                "mobile devices. The applications that are built using Java ME are portable," +
                " secure, and can take advantage of the native capabilities of the device. " +
                "Java ME addresses the constraints that are involved in building applications " +
                "that are targeted at mobile devices. In essence, Java ME addresses the " +
                "challenge of executing applications on devices " +
                "that are low on available memory, display, and power.\n" +
                "\n" +
                "There are various ways to build applications for Android devices," +
                " but the recommended approach is to leverage the" +
                " Java programming language and the Android SDK." +
                " You can explore more about the Android SDK Manager from here.";

        // set value to the given TextView
        textview.setText(para);

        // to perform the movement action
        // Moves the cursor or scrolls to the
        // top or bottom of the document
        textview.setMovementMethod(new ScrollingMovementMethod());
    }
}