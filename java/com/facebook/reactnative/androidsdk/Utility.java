package com.facebook.reactnative.androidsdk;

import android.net.Uri;
import com.anythink.reactnativejs.utils.Const;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class Utility {
    public static AccessToken buildAccessToken(ReadableMap readableMap) {
        return new AccessToken(readableMap.getString("accessToken"), readableMap.getString("applicationID"), readableMap.getString(Const.USER_ID), reactArrayToStringList(readableMap.getArray(NativeProtocol.RESULT_ARGS_PERMISSIONS)), reactArrayToStringList(readableMap.getArray("declinedPermissions")), reactArrayToStringList(readableMap.getArray("expiredPermissions")), AccessTokenSource.valueOf(readableMap.getString("accessTokenSource")), new Date((long) readableMap.getDouble("expirationTime")), new Date((long) readableMap.getDouble("lastRefreshTime")), new Date((long) readableMap.getDouble("dataAccessExpirationTime")));
    }

    public static WritableMap accessTokenToReactMap(AccessToken accessToken) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("accessToken", accessToken.getToken());
        createMap.putString("applicationID", accessToken.getApplicationId());
        createMap.putString(Const.USER_ID, accessToken.getUserId());
        createMap.putArray(NativeProtocol.RESULT_ARGS_PERMISSIONS, Arguments.fromJavaArgs(setToStringArray(accessToken.getPermissions())));
        createMap.putArray("declinedPermissions", Arguments.fromJavaArgs(setToStringArray(accessToken.getDeclinedPermissions())));
        createMap.putArray("expiredPermissions", Arguments.fromJavaArgs(setToStringArray(accessToken.getExpiredPermissions())));
        createMap.putString("accessTokenSource", accessToken.getSource().name());
        createMap.putDouble("expirationTime", (double) accessToken.getExpires().getTime());
        createMap.putDouble("lastRefreshTime", (double) accessToken.getLastRefresh().getTime());
        createMap.putDouble("dataAccessExpirationTime", (double) accessToken.getDataAccessExpirationTime().getTime());
        return createMap;
    }

    public static ShareContent buildShareContent(ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString("contentType");
            if (string.equals("link")) {
                return buildShareLinkContent(readableMap);
            }
            if (string.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
                return buildSharePhotoContent(readableMap);
            }
            if (string.equals("video")) {
                return buildShareVideoContent(readableMap);
            }
            if (string.equals("open-graph")) {
                return buildShareOpenGraphContent(readableMap);
            }
        }
        return null;
    }

    public static AppInviteContent buildAppInviteContent(ReadableMap readableMap) {
        AppInviteContent.Builder builder = new AppInviteContent.Builder();
        builder.setApplinkUrl(readableMap.getString("applinkUrl"));
        if (readableMap.hasKey("previewImageUrl")) {
            builder.setPreviewImageUrl(readableMap.getString("previewImageUrl"));
        }
        String valueOrNull = getValueOrNull(readableMap, "promotionText");
        String valueOrNull2 = getValueOrNull(readableMap, "promotionCode");
        if (!(valueOrNull == null || valueOrNull2 == null)) {
            builder.setPromotionDetails(valueOrNull, valueOrNull2);
        }
        return builder.build();
    }

    public static AppGroupCreationContent buildAppGroupCreationContent(ReadableMap readableMap) {
        AppGroupCreationContent.Builder builder = new AppGroupCreationContent.Builder();
        builder.setName(readableMap.getString("name"));
        builder.setDescription(readableMap.getString("description"));
        builder.setAppGroupPrivacy(AppGroupCreationContent.AppGroupPrivacy.valueOf(readableMap.getString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)));
        return builder.build();
    }

    public static GameRequestContent buildGameRequestContent(ReadableMap readableMap) {
        GameRequestContent.Builder builder = new GameRequestContent.Builder();
        String valueOrNull = getValueOrNull(readableMap, "actionType");
        if (valueOrNull != null) {
            builder.setActionType(GameRequestContent.ActionType.valueOf(valueOrNull.toUpperCase()));
        }
        String valueOrNull2 = getValueOrNull(readableMap, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        if (valueOrNull2 != null) {
            builder.setFilters(GameRequestContent.Filters.valueOf(valueOrNull2.toUpperCase()));
        }
        builder.setMessage(readableMap.getString("message"));
        if (readableMap.hasKey("recipients")) {
            builder.setRecipients(reactArrayToStringList(readableMap.getArray("recipients")));
        }
        builder.setTitle(getValueOrNull(readableMap, "title"));
        builder.setData(getValueOrNull(readableMap, "data"));
        builder.setObjectId(getValueOrNull(readableMap, "objectId"));
        if (readableMap.hasKey(ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS)) {
            builder.setSuggestions(reactArrayToStringList(readableMap.getArray(ShareConstants.WEB_DIALOG_PARAM_SUGGESTIONS)));
        }
        return builder.build();
    }

    public static ShareLinkContent buildShareLinkContent(ReadableMap readableMap) {
        ShareLinkContent.Builder builder = new ShareLinkContent.Builder();
        builder.setContentUrl(Uri.parse(readableMap.getString("contentUrl")));
        String valueOrNull = getValueOrNull(readableMap, "imageUrl");
        builder.setImageUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        builder.setContentDescription(getValueOrNull(readableMap, "contentDescription"));
        builder.setContentTitle(getValueOrNull(readableMap, "contentTitle"));
        builder.setQuote(getValueOrNull(readableMap, ShareConstants.WEB_DIALOG_PARAM_QUOTE));
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static SharePhotoContent buildSharePhotoContent(ReadableMap readableMap) {
        SharePhotoContent.Builder builder = new SharePhotoContent.Builder();
        builder.setPhotos(reactArrayToPhotoList(readableMap.getArray("photos")));
        String valueOrNull = getValueOrNull(readableMap, "contentUrl");
        builder.setContentUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static SharePhoto buildSharePhoto(ReadableMap readableMap) {
        SharePhoto.Builder builder = new SharePhoto.Builder();
        builder.setImageUrl(Uri.parse(readableMap.getString("imageUrl")));
        builder.setCaption(getValueOrNull(readableMap, ShareConstants.FEED_CAPTION_PARAM));
        if (readableMap.hasKey(IronSourceConstants.TYPE_USER_GENERATED)) {
            builder.setUserGenerated(readableMap.getBoolean(IronSourceConstants.TYPE_USER_GENERATED));
        }
        return builder.build();
    }

    public static ShareContent buildShareVideoContent(ReadableMap readableMap) {
        ShareVideoContent.Builder builder = new ShareVideoContent.Builder();
        String valueOrNull = getValueOrNull(readableMap, "contentUrl");
        builder.setContentUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        builder.setContentDescription(getValueOrNull(readableMap, "contentDescription"));
        builder.setContentTitle(getValueOrNull(readableMap, "contentTitle"));
        if (readableMap.hasKey("previewPhoto")) {
            builder.setPreviewPhoto(buildSharePhoto(readableMap.getMap("previewPhoto")));
        }
        if (readableMap.hasKey("video")) {
            builder.setVideo(buildShareVideo(readableMap.getMap("video")));
        }
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static ShareContent buildShareOpenGraphContent(ReadableMap readableMap) {
        ShareOpenGraphContent.Builder builder = new ShareOpenGraphContent.Builder();
        String valueOrNull = getValueOrNull(readableMap, "contentUrl");
        builder.setContentUrl(valueOrNull != null ? Uri.parse(valueOrNull) : null);
        builder.setAction(buildShareOpenGraphAction(readableMap.getMap("action")));
        builder.setPreviewPropertyName(readableMap.getString("previewPropertyName"));
        appendGenericContent(builder, readableMap);
        return builder.build();
    }

    public static ShareOpenGraphAction buildShareOpenGraphAction(ReadableMap readableMap) {
        ShareOpenGraphAction.Builder builder = new ShareOpenGraphAction.Builder();
        builder.setActionType(readableMap.getString("actionType"));
        ReadableMap map = readableMap.getMap("_properties");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            builder.putObject(nextKey, buildShareOpenGraphObject(map.getMap(nextKey).getMap("value")));
        }
        return builder.build();
    }

    public static ShareOpenGraphObject buildShareOpenGraphObject(ReadableMap readableMap) {
        ShareOpenGraphObject.Builder builder = new ShareOpenGraphObject.Builder();
        ReadableMap map = readableMap.getMap("_properties");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map2 = map.getMap(nextKey);
            String string = map2.getString("type");
            char c = 65535;
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals("number")) {
                        c = 0;
                        break;
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        c = 3;
                        break;
                    }
                    break;
                case 106642994:
                    if (string.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
                        c = 2;
                        break;
                    }
                    break;
                case 778493761:
                    if (string.equals("open-graph-object")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                builder.putDouble(nextKey, map2.getDouble("value"));
            } else if (c == 1) {
                builder.putObject(nextKey, buildShareOpenGraphObject(map2.getMap("value")));
            } else if (c == 2) {
                builder.putPhoto(nextKey, buildSharePhoto(map2.getMap("value")));
            } else if (c == 3) {
                builder.putString(nextKey, map2.getString("value"));
            }
        }
        return builder.build();
    }

    private static void appendGenericContent(ShareContent.Builder builder, ReadableMap readableMap) {
        if (readableMap.hasKey("commonParameters")) {
            ReadableMap map = readableMap.getMap("commonParameters");
            builder.setPeopleIds(map.hasKey("peopleIds") ? reactArrayToStringList(map.getArray("peopleIds")) : null);
            builder.setPlaceId(getValueOrNull(map, "placeId"));
            builder.setRef(getValueOrNull(map, "ref"));
            if (map.hasKey(ShareConstants.WEB_DIALOG_PARAM_HASHTAG)) {
                builder.setShareHashtag(new ShareHashtag.Builder().setHashtag(map.getString(ShareConstants.WEB_DIALOG_PARAM_HASHTAG)).build());
            }
        }
    }

    public static ShareVideo buildShareVideo(ReadableMap readableMap) {
        ShareVideo.Builder builder = new ShareVideo.Builder();
        if (readableMap.hasKey("localUrl")) {
            builder.setLocalUrl(Uri.parse(readableMap.getString("localUrl")));
        }
        return builder.build();
    }

    public static List<SharePhoto> reactArrayToPhotoList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(buildSharePhoto(readableArray.getMap(i)));
        }
        return arrayList;
    }

    public static String getValueOrNull(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    public static List<String> reactArrayToStringList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            arrayList.add(readableArray.getString(i));
        }
        return arrayList;
    }

    public static WritableArray listToReactArray(List<String> list) {
        WritableArray createArray = Arguments.createArray();
        for (String str : list) {
            createArray.pushString(str);
        }
        return createArray;
    }

    public static String[] setToStringArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        int i = 0;
        for (String str : set) {
            strArr[i] = str;
            i++;
        }
        return strArr;
    }
}
