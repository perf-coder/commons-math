package org.apache.commons.math4.legacy.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.math4.legacy.core.provider.AccurateMathImplWrapper;
import org.apache.commons.math4.legacy.core.provider.JdkMathWrapper;
import org.apache.commons.math4.legacy.core.provider.MathAPI;

/**
 * @author <a href="mailto:erik.svensson@nasdaq.com">Erik Svensson</a>
 * Date: 2021-08-19
 * Time: 10:23
 */
public class MathProfile {

    private static final Map<String, MathProfile> profiles = new HashMap<>();
    private static final MathProfile am = new MathProfile("AccurateMath", new AccurateMathImplWrapper());
    private static final MathProfile jdk = new MathProfile("JDK_MATH", new JdkMathWrapper());

//    private static MathProfile defaultProfile;
    private static MathProfile currentProfile;

    private final static String PROPERTY_KEY = "org.apache.commons.math.provider";

    static {
        profiles.put("JDK_MATH", jdk);
        profiles.put("ACCURATE_MATH", am);
        currentProfile = jdk;

        String prop = System.getProperty(PROPERTY_KEY);
        if (null != prop && prop.toUpperCase().equals(jdk.profileName.toUpperCase())) {
                currentProfile = jdk;
        }

        System.out.println("Current profile is " + currentProfile.getProfileName());
    }

    private String profileName;
    private MathAPI implementation;

    public MathProfile(final String pProfileName, final MathAPI pImplementation) {
        profileName = pProfileName;
        implementation = pImplementation;
        profiles.put(pProfileName.toUpperCase(), this);
    }

    public static void setCurrentProfile(String profileName) {
        if (null == profileName || !profiles.containsKey(profileName.toUpperCase())) {
            currentProfile = am;
        } else {
            currentProfile = profiles.get(profileName.toUpperCase());
        }
    }

    public static MathAPI getDefaultAPI() {
        return am.implementation;
    }

    public static MathAPI getCurrentAPI() {
        return currentProfile.implementation;
    }

    public static MathProfile getCurrentProfile() {
        return currentProfile;
    }

    public static MathProfile getProfile(String name) {
        MathProfile res;
        if ((res = profiles.get(name.toUpperCase())) == null) {
            return am;
        }
        return res;
    }

    public static void addProfile( MathProfile profile) {
        if (!(null == profile)) {
            profiles.put(profile.profileName.toUpperCase(), profile);
        }
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(final String pProfileName) {
        profileName = pProfileName;
    }

    public MathAPI getImplementation() {
        return implementation;
    }

    public void setImplementation(final MathAPI pImplementation) {
        implementation = pImplementation;
    }

    public boolean add() {
        if (profileName != null && implementation != null) {
            profiles.put(profileName, this);
            return true;
        }
        return false;
    }
}
