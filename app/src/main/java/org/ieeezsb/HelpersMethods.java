package org.ieeezsb;


import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public final class HelpersMethods {
    private static String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + SocialMediaLinks.FacebookLinksAndID[0];
            } else { //older versions of fb app
                return "fb://page/" + SocialMediaLinks.FacebookLinksAndID[1];
            }
        } catch (PackageManager.NameNotFoundException e) {
            return SocialMediaLinks.FacebookLinksAndID[0]; //normal web url
        }
    }
    public static Intent getOpenFacebookIntent(Context context) {
        try {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(getFacebookPageURL(context)));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(SocialMediaLinks.FacebookLinksAndID[0]));
        }}

    public static Intent openTwitterHandle(Context context) {
        Intent intent = null;
        try {
            context.getPackageManager().getPackageInfo("com.twitter.android", 0);
            new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=id_num" ));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        catch (Exception e) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SocialMediaLinks.TwitterLink));
        }
        return intent;
    }

    public static Intent openLinked(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.linkedin.android", 0);
            return new Intent(Intent.ACTION_VIEW,Uri.parse(SocialMediaLinks.LinkedInLink));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,Uri.parse(SocialMediaLinks.LinkedInLink));
        }}


}
