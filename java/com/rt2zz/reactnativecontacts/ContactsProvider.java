package com.rt2zz.reactnativecontacts;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.Scopes;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContactsProvider {
    private static final List<String> FULL_PROJECTION = new ArrayList<String>() {
        /* class com.rt2zz.reactnativecontacts.ContactsProvider.AnonymousClass2 */

        {
            addAll(ContactsProvider.JUST_ME_PROJECTION);
        }
    };
    public static final int ID_FOR_PROFILE_CONTACT = -1;
    private static final List<String> JUST_ME_PROJECTION = new ArrayList<String>() {
        /* class com.rt2zz.reactnativecontacts.ContactsProvider.AnonymousClass1 */

        {
            add("_id");
            add("contact_id");
            add("raw_contact_id");
            add("lookup");
            add("mimetype");
            add("display_name");
            add("photo_uri");
            add("data1");
            add("data2");
            add("data5");
            add("data3");
            add("data4");
            add("data6");
            add("data1");
            add("data4");
            add("data2");
            add("data3");
            add("data1");
            add("data1");
            add("data2");
            add("data3");
            add("data1");
            add("data4");
            add("data5");
            add("data1");
            add("data2");
            add("data3");
            add("data4");
            add("data5");
            add("data6");
            add("data7");
            add("data8");
            add("data9");
            add("data10");
            add("data1");
            add("data1");
            add("data1");
            add("data2");
        }
    };
    private static final List<String> PHOTO_PROJECTION = new ArrayList<String>() {
        /* class com.rt2zz.reactnativecontacts.ContactsProvider.AnonymousClass3 */

        {
            add("photo_uri");
        }
    };
    private final ContentResolver contentResolver;

    public ContactsProvider(ContentResolver contentResolver2) {
        this.contentResolver = contentResolver2;
    }

    public WritableArray getContactsMatchingString(String str) {
        ContentResolver contentResolver2 = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor query = contentResolver2.query(uri, (String[]) list.toArray(new String[list.size()]), "display_name LIKE ? OR data1 LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null);
        try {
            Map<String, Contact> loadContactsFrom = loadContactsFrom(query);
            WritableArray createArray = Arguments.createArray();
            for (Contact contact : loadContactsFrom.values()) {
                createArray.pushMap(contact.toMap());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public WritableArray getContactsByPhoneNumber(String str) {
        ContentResolver contentResolver2 = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor query = contentResolver2.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ? OR data4 LIKE ?", new String[]{"%" + str + "%", "%" + str + "%"}, null);
        try {
            Map<String, Contact> loadContactsFrom = loadContactsFrom(query);
            WritableArray createArray = Arguments.createArray();
            for (Contact contact : loadContactsFrom.values()) {
                createArray.pushMap(contact.toMap());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public WritableArray getContactsByEmailAddress(String str) {
        ContentResolver contentResolver2 = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor query = contentResolver2.query(uri, (String[]) list.toArray(new String[list.size()]), "data1 LIKE ?", new String[]{"%" + str + "%"}, null);
        try {
            Map<String, Contact> loadContactsFrom = loadContactsFrom(query);
            WritableArray createArray = Arguments.createArray();
            for (Contact contact : loadContactsFrom.values()) {
                createArray.pushMap(contact.toMap());
            }
            return createArray;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public WritableMap getContactByRawId(String str) {
        int columnIndex;
        Cursor query = this.contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id= ?", new String[]{str}, null);
        query.getCount();
        String string = (!query.moveToNext() || (columnIndex = query.getColumnIndex("contact_id")) == -1) ? null : query.getString(columnIndex);
        query.close();
        return getContactById(string);
    }

    public WritableMap getContactById(String str) {
        ContentResolver contentResolver2 = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = FULL_PROJECTION;
        Cursor query = contentResolver2.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        try {
            Map<String, Contact> loadContactsFrom = loadContactsFrom(query);
            if (loadContactsFrom.values().size() > 0) {
                return loadContactsFrom.values().iterator().next().toMap();
            }
            return null;
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    public Integer getContactsCount() {
        return Integer.valueOf(this.contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null).getCount());
    }

    public WritableArray getContacts() {
        ContentResolver contentResolver2 = this.contentResolver;
        Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        List<String> list = JUST_ME_PROJECTION;
        Cursor query = contentResolver2.query(withAppendedPath, (String[]) list.toArray(new String[list.size()]), null, null, null);
        try {
            Map<String, Contact> loadContactsFrom = loadContactsFrom(query);
            ContentResolver contentResolver3 = this.contentResolver;
            Uri uri = ContactsContract.Data.CONTENT_URI;
            List<String> list2 = FULL_PROJECTION;
            Cursor query2 = contentResolver3.query(uri, (String[]) list2.toArray(new String[list2.size()]), "mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=? OR mimetype=?", new String[]{"vnd.android.cursor.item/email_v2", "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/name", "vnd.android.cursor.item/organization", "vnd.android.cursor.item/postal-address_v2", "vnd.android.cursor.item/note", "vnd.android.cursor.item/website", "vnd.android.cursor.item/contact_event"}, null);
            try {
                Map<String, Contact> loadContactsFrom2 = loadContactsFrom(query2);
                WritableArray createArray = Arguments.createArray();
                for (Contact contact : loadContactsFrom.values()) {
                    createArray.pushMap(contact.toMap());
                }
                for (Contact contact2 : loadContactsFrom2.values()) {
                    createArray.pushMap(contact2.toMap());
                }
                return createArray;
            } finally {
                if (query2 != null) {
                    query2.close();
                }
            }
        } finally {
            if (query != null) {
                query.close();
            }
        }
    }

    private Map<String, Contact> loadContactsFrom(Cursor cursor) {
        String str;
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor != null && cursor.moveToNext()) {
            int columnIndex = cursor.getColumnIndex("contact_id");
            int columnIndex2 = cursor.getColumnIndex("_id");
            int columnIndex3 = cursor.getColumnIndex("raw_contact_id");
            char c = 65535;
            if (columnIndex != -1) {
                str = cursor.getString(columnIndex);
            } else {
                str = String.valueOf(-1);
            }
            if (columnIndex2 != -1) {
                str2 = cursor.getString(columnIndex2);
            } else {
                str2 = String.valueOf(-1);
            }
            if (columnIndex3 != -1) {
                str3 = cursor.getString(columnIndex3);
            } else {
                str3 = String.valueOf(-1);
            }
            if (!linkedHashMap.containsKey(str)) {
                linkedHashMap.put(str, new Contact(str));
            }
            Contact contact = (Contact) linkedHashMap.get(str);
            String string = cursor.getString(cursor.getColumnIndex("mimetype"));
            String string2 = cursor.getString(cursor.getColumnIndex("display_name"));
            contact.rawContactId = str3;
            if (!TextUtils.isEmpty(string2) && TextUtils.isEmpty(contact.displayName)) {
                contact.displayName = string2;
            }
            if (TextUtils.isEmpty(contact.photoUri)) {
                String string3 = cursor.getString(cursor.getColumnIndex("photo_uri"));
                if (!TextUtils.isEmpty(string3)) {
                    contact.photoUri = string3;
                    contact.hasPhoto = true;
                }
            }
            switch (string.hashCode()) {
                case -1569536764:
                    if (string.equals("vnd.android.cursor.item/email_v2")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1328682538:
                    if (string.equals("vnd.android.cursor.item/contact_event")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1079224304:
                    if (string.equals("vnd.android.cursor.item/name")) {
                        c = 0;
                        break;
                    }
                    break;
                case -601229436:
                    if (string.equals("vnd.android.cursor.item/postal-address_v2")) {
                        c = 5;
                        break;
                    }
                    break;
                case 456415478:
                    if (string.equals("vnd.android.cursor.item/website")) {
                        c = 3;
                        break;
                    }
                    break;
                case 684173810:
                    if (string.equals("vnd.android.cursor.item/phone_v2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 689862072:
                    if (string.equals("vnd.android.cursor.item/organization")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            String str4 = TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE;
            String str5 = "";
            switch (c) {
                case 0:
                    contact.givenName = cursor.getString(cursor.getColumnIndex("data2"));
                    contact.middleName = cursor.getString(cursor.getColumnIndex("data5"));
                    contact.familyName = cursor.getString(cursor.getColumnIndex("data3"));
                    contact.prefix = cursor.getString(cursor.getColumnIndex("data4"));
                    contact.suffix = cursor.getString(cursor.getColumnIndex("data6"));
                    break;
                case 1:
                    String string4 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string4)) {
                        if (i == 1) {
                            str4 = "home";
                        } else if (i != 2) {
                            str4 = i != 3 ? "other" : "work";
                        }
                        contact.phones.add(new Contact.Item(str4, string4, str2));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    String string5 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (!TextUtils.isEmpty(string5)) {
                        if (i2 == 0) {
                            str4 = cursor.getString(cursor.getColumnIndex("data3")) != null ? cursor.getString(cursor.getColumnIndex("data3")).toLowerCase() : str5;
                        } else if (i2 == 1) {
                            str4 = "home";
                        } else if (i2 == 2) {
                            str4 = "work";
                        } else if (i2 != 4) {
                            str4 = "other";
                        }
                        contact.emails.add(new Contact.Item(str4, string5, str2));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    String string6 = cursor.getString(cursor.getColumnIndex("data1"));
                    int i3 = cursor.getInt(cursor.getColumnIndex("data2"));
                    if (TextUtils.isEmpty(string6)) {
                        break;
                    } else {
                        switch (i3) {
                            case 0:
                                if (cursor.getString(cursor.getColumnIndex("data3")) != null) {
                                    str5 = cursor.getString(cursor.getColumnIndex("data3")).toLowerCase();
                                    break;
                                }
                                break;
                            case 1:
                                str5 = "homepage";
                                break;
                            case 2:
                                str5 = "blog";
                                break;
                            case 3:
                                str5 = Scopes.PROFILE;
                                break;
                            case 4:
                                str5 = "home";
                                break;
                            case 5:
                                str5 = "work";
                                break;
                            case 6:
                                str5 = "ftp";
                                break;
                            default:
                                str5 = "other";
                                break;
                        }
                        contact.urls.add(new Contact.Item(str5, string6, str2));
                        break;
                    }
                case 4:
                    contact.company = cursor.getString(cursor.getColumnIndex("data1"));
                    contact.jobTitle = cursor.getString(cursor.getColumnIndex("data4"));
                    contact.department = cursor.getString(cursor.getColumnIndex("data5"));
                    break;
                case 5:
                    contact.postalAddresses.add(new Contact.PostalAddressItem(cursor));
                    break;
                case 6:
                    if (cursor.getInt(cursor.getColumnIndex("data2")) != 3) {
                        break;
                    } else {
                        try {
                            List asList = Arrays.asList(cursor.getString(cursor.getColumnIndex("data1")).replace("--", str5).split("-"));
                            if (asList.size() != 2) {
                                if (asList.size() != 3) {
                                    break;
                                } else {
                                    int parseInt = Integer.parseInt((String) asList.get(0));
                                    int parseInt2 = Integer.parseInt((String) asList.get(1));
                                    int parseInt3 = Integer.parseInt((String) asList.get(2));
                                    if (parseInt > 0 && parseInt2 >= 1 && parseInt2 <= 12 && parseInt3 >= 1 && parseInt3 <= 31) {
                                        contact.birthday = new Contact.Birthday(parseInt, parseInt2, parseInt3);
                                        break;
                                    }
                                }
                            } else {
                                int parseInt4 = Integer.parseInt((String) asList.get(0));
                                int parseInt5 = Integer.parseInt((String) asList.get(1));
                                if (parseInt4 >= 1 && parseInt4 <= 12 && parseInt5 >= 1 && parseInt5 <= 31) {
                                    contact.birthday = new Contact.Birthday(parseInt4, parseInt5);
                                    break;
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e) {
                            Log.w("ContactsProvider", e.toString());
                            break;
                        }
                    }
            }
        }
        return linkedHashMap;
    }

    public String getPhotoUriFromContactId(String str) {
        ContentResolver contentResolver2 = this.contentResolver;
        Uri uri = ContactsContract.Data.CONTENT_URI;
        List<String> list = PHOTO_PROJECTION;
        Cursor query = contentResolver2.query(uri, (String[]) list.toArray(new String[list.size()]), "contact_id = ?", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("photo_uri"));
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                }
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
        if (query == null) {
            return null;
        }
        query.close();
        return null;
    }

    /* access modifiers changed from: private */
    public static class Contact {
        private Birthday birthday;
        private String company = "";
        private String contactId;
        private String department = "";
        private String displayName;
        private List<Item> emails = new ArrayList();
        private String familyName = "";
        private String givenName = "";
        private boolean hasPhoto = false;
        private String jobTitle = "";
        private String middleName = "";
        private String note = "";
        private List<Item> phones = new ArrayList();
        private String photoUri;
        private List<PostalAddressItem> postalAddresses = new ArrayList();
        private String prefix = "";
        private String rawContactId;
        private String suffix = "";
        private List<Item> urls = new ArrayList();

        public Contact(String str) {
            this.contactId = str;
        }

        public WritableMap toMap() {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("recordID", this.contactId);
            createMap.putString("rawContactId", this.rawContactId);
            createMap.putString("givenName", TextUtils.isEmpty(this.givenName) ? this.displayName : this.givenName);
            createMap.putString("displayName", this.displayName);
            createMap.putString("middleName", this.middleName);
            createMap.putString("familyName", this.familyName);
            createMap.putString("prefix", this.prefix);
            createMap.putString("suffix", this.suffix);
            createMap.putString("company", this.company);
            createMap.putString("jobTitle", this.jobTitle);
            createMap.putString("department", this.department);
            createMap.putString("note", this.note);
            createMap.putBoolean("hasThumbnail", this.hasPhoto);
            String str = this.photoUri;
            if (str == null) {
                str = "";
            }
            createMap.putString("thumbnailPath", str);
            WritableArray createArray = Arguments.createArray();
            for (Item item : this.phones) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString("number", item.value);
                createMap2.putString("label", item.label);
                createMap2.putString("id", item.id);
                createArray.pushMap(createMap2);
            }
            createMap.putArray("phoneNumbers", createArray);
            WritableArray createArray2 = Arguments.createArray();
            for (Item item2 : this.urls) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putString("url", item2.value);
                createMap3.putString("id", item2.id);
                createArray2.pushMap(createMap3);
            }
            createMap.putArray("urlAddresses", createArray2);
            WritableArray createArray3 = Arguments.createArray();
            for (Item item3 : this.emails) {
                WritableMap createMap4 = Arguments.createMap();
                createMap4.putString("email", item3.value);
                createMap4.putString("label", item3.label);
                createMap4.putString("id", item3.id);
                createArray3.pushMap(createMap4);
            }
            createMap.putArray("emailAddresses", createArray3);
            WritableArray createArray4 = Arguments.createArray();
            for (PostalAddressItem postalAddressItem : this.postalAddresses) {
                createArray4.pushMap(postalAddressItem.map);
            }
            createMap.putArray("postalAddresses", createArray4);
            WritableMap createMap5 = Arguments.createMap();
            Birthday birthday2 = this.birthday;
            if (birthday2 != null) {
                if (birthday2.year > 0) {
                    createMap5.putInt("year", this.birthday.year);
                }
                createMap5.putInt("month", this.birthday.month);
                createMap5.putInt("day", this.birthday.day);
                createMap.putMap("birthday", createMap5);
            }
            return createMap;
        }

        public static class Item {
            public String id;
            public String label;
            public String value;

            public Item(String str, String str2, String str3) {
                this.id = str3;
                this.label = str;
                this.value = str2;
            }

            public Item(String str, String str2) {
                this.label = str;
                this.value = str2;
            }
        }

        public static class Birthday {
            public int day = 0;
            public int month = 0;
            public int year = 0;

            public Birthday(int i, int i2, int i3) {
                this.year = i;
                this.month = i2;
                this.day = i3;
            }

            public Birthday(int i, int i2) {
                this.month = i;
                this.day = i2;
            }
        }

        public static class PostalAddressItem {
            public final WritableMap map;

            public PostalAddressItem(Cursor cursor) {
                WritableMap createMap = Arguments.createMap();
                this.map = createMap;
                createMap.putString("label", getLabel(cursor));
                putString(cursor, "formattedAddress", "data1");
                putString(cursor, "street", "data4");
                putString(cursor, "pobox", "data5");
                putString(cursor, "neighborhood", "data6");
                putString(cursor, "city", "data7");
                putString(cursor, "region", "data8");
                putString(cursor, "state", "data8");
                putString(cursor, "postCode", "data9");
                putString(cursor, UserDataStore.COUNTRY, "data10");
            }

            private void putString(Cursor cursor, String str, String str2) {
                String string = cursor.getString(cursor.getColumnIndex(str2));
                if (!TextUtils.isEmpty(string)) {
                    this.map.putString(str, string);
                }
            }

            static String getLabel(Cursor cursor) {
                int i = cursor.getInt(cursor.getColumnIndex("data2"));
                if (i == 0) {
                    String string = cursor.getString(cursor.getColumnIndex("data3"));
                    return string != null ? string : "";
                } else if (i != 1) {
                    return i != 2 ? "other" : "work";
                } else {
                    return "home";
                }
            }
        }
    }
}
