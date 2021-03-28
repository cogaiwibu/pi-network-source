package com.rt2zz.reactnativecontacts;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import androidx.core.app.ActivityCompat;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class ContactsManager extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final String PERMISSION_AUTHORIZED = "authorized";
    private static final String PERMISSION_DENIED = "denied";
    private static final String PERMISSION_READ_CONTACTS = "android.permission.READ_CONTACTS";
    private static final int PERMISSION_REQUEST_CODE = 888;
    private static final int REQUEST_OPEN_CONTACT_FORM = 52941;
    private static final int REQUEST_OPEN_EXISTING_CONTACT = 52942;
    private static Callback requestCallback;
    private static Callback updateContactCallback;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Contacts";
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    public ContactsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void getAll(Callback callback) {
        getAllContacts(callback);
    }

    @ReactMethod
    public void getAllWithoutPhotos(Callback callback) {
        getAllContacts(callback);
    }

    private void getAllContacts(final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                WritableArray contacts = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContacts();
                callback.invoke(null, contacts);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getCount(final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                Integer contactsCount = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsCount();
                callback.invoke(contactsCount);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsMatchingString(final String str, final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                WritableArray contactsMatchingString = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsMatchingString(str);
                callback.invoke(null, contactsMatchingString);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsByPhoneNumber(final String str, final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                WritableArray contactsByPhoneNumber = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsByPhoneNumber(str);
                callback.invoke(null, contactsByPhoneNumber);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactsByEmailAddress(final String str, final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                WritableArray contactsByEmailAddress = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactsByEmailAddress(str);
                callback.invoke(null, contactsByEmailAddress);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getPhotoForId(final String str, final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                String photoUriFromContactId = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getPhotoUriFromContactId(str);
                callback.invoke(null, photoUriFromContactId);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void getContactById(final String str, final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass7 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                WritableMap contactById = new ContactsProvider(ContactsManager.this.getReactApplicationContext().getContentResolver()).getContactById(str);
                callback.invoke(null, contactById);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void writePhotoToPath(final String str, final String str2, final Callback callback) {
        new AsyncTask<Void, Void, Void>() {
            /* class com.rt2zz.reactnativecontacts.ContactsManager.AnonymousClass8 */

            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                Throwable th;
                FileNotFoundException e;
                FileOutputStream fileOutputStream;
                InputStream openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(ContactsManager.this.getReactApplicationContext().getContentResolver(), ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(str)));
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        BitmapFactory.decodeStream(openContactPhotoInputStream).compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        callback.invoke(null, true);
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        try {
                            callback.invoke(e.toString());
                            fileOutputStream.close();
                            openContactPhotoInputStream.close();
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    fileOutputStream = null;
                    callback.invoke(e.toString());
                    fileOutputStream.close();
                    openContactPhotoInputStream.close();
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2.close();
                    throw th;
                }
                try {
                    openContactPhotoInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private Bitmap getThumbnailBitmap(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            return decodeFile;
        }
        try {
            InputStream open = getReactApplicationContext().getAssets().open(str);
            decodeFile = BitmapFactory.decodeStream(open);
            open.close();
            return decodeFile;
        } catch (IOException e) {
            e.printStackTrace();
            return decodeFile;
        }
    }

    @ReactMethod
    public void openContactForm(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        String str3;
        String[] strArr;
        Integer[] numArr;
        int i;
        String[] strArr2;
        String[] strArr3;
        int i2;
        int i3;
        String[] strArr4;
        int i4;
        Integer[] numArr2;
        int i5;
        String[] strArr5;
        Integer[] numArr3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i6;
        Integer[] numArr4;
        String[] strArr6;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        int i7;
        String[] strArr10;
        String[] strArr11;
        String[] strArr12;
        Bitmap thumbnailBitmap;
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("displayName") ? readableMap.getString("displayName") : null;
        String string4 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string5 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string6 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string7 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string8 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string9 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string10 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            i = array.size();
            strArr = new String[i];
            str3 = string3;
            numArr = new Integer[i];
            str2 = string10;
            int i8 = 0;
            while (i8 < i) {
                strArr[i8] = array.getMap(i8).getString("number");
                numArr[i8] = Integer.valueOf(mapStringToPhoneType(array.getMap(i8).getString("label")));
                i8++;
                i = i;
                string9 = string9;
            }
            str = string9;
        } else {
            str3 = string3;
            str = string9;
            str2 = string10;
            i = 0;
            numArr = null;
            strArr = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            i2 = array2.size();
            strArr3 = new String[i2];
            strArr2 = strArr;
            int i9 = 0;
            while (i9 < i2) {
                strArr3[i9] = array2.getMap(i9).getString("url");
                i9++;
                i2 = i2;
                array2 = array2;
            }
        } else {
            strArr2 = strArr;
            i2 = 0;
            strArr3 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            i5 = array3.size();
            numArr2 = numArr;
            strArr5 = new String[i5];
            i4 = i;
            numArr3 = new Integer[i5];
            strArr4 = strArr3;
            int i10 = 0;
            while (i10 < i5) {
                strArr5[i10] = array3.getMap(i10).getString("email");
                numArr3[i10] = Integer.valueOf(mapStringToEmailType(array3.getMap(i10).getString("label")));
                i10++;
                i5 = i5;
                i2 = i2;
            }
            i3 = i2;
        } else {
            i4 = i;
            numArr2 = numArr;
            i3 = i2;
            strArr4 = strArr3;
            numArr3 = null;
            strArr5 = null;
            i5 = 0;
        }
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            i7 = array4.size();
            String[] strArr13 = new String[i7];
            strArr9 = new String[i7];
            strArr6 = strArr5;
            String[] strArr14 = new String[i7];
            numArr4 = numArr3;
            String[] strArr15 = new String[i7];
            i6 = i5;
            strArr8 = new String[i7];
            str8 = string8;
            strArr10 = new String[i7];
            str7 = string7;
            String[] strArr16 = new String[i7];
            str6 = string6;
            Integer[] numArr5 = new Integer[i7];
            str5 = string5;
            int i11 = 0;
            while (i11 < i7) {
                strArr13[i11] = array4.getMap(i11).getString("street");
                strArr9[i11] = array4.getMap(i11).getString("city");
                strArr14[i11] = array4.getMap(i11).getString("state");
                strArr15[i11] = array4.getMap(i11).getString("region");
                strArr8[i11] = array4.getMap(i11).getString("postCode");
                strArr10[i11] = array4.getMap(i11).getString(UserDataStore.COUNTRY);
                strArr16[i11] = array4.getMap(i11).getString("formattedAddress");
                numArr5[i11] = Integer.valueOf(mapStringToPostalAddressType(array4.getMap(i11).getString("label")));
                i11++;
                i7 = i7;
                string2 = string2;
            }
            str4 = string2;
            strArr12 = strArr15;
            strArr11 = strArr16;
            strArr7 = strArr13;
        } else {
            str4 = string2;
            numArr4 = numArr3;
            strArr6 = strArr5;
            str5 = string5;
            str6 = string6;
            str7 = string7;
            str8 = string8;
            i6 = i5;
            strArr12 = null;
            strArr11 = null;
            strArr10 = null;
            i7 = 0;
            strArr9 = null;
            strArr8 = null;
            strArr7 = null;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/identity");
        contentValues.put("data2", string);
        contentValues.put("data3", string4);
        contentValues.put("data5", str4);
        contentValues.put("data4", str5);
        contentValues.put("data6", str6);
        arrayList.add(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues2.put("data1", str7);
        contentValues2.put("data4", str8);
        contentValues2.put("data5", str);
        arrayList.add(contentValues2);
        for (int i12 = 0; i12 < i3; i12++) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/website");
            contentValues3.put("data1", strArr4[i12]);
            arrayList.add(contentValues3);
        }
        for (int i13 = 0; i13 < i6; i13++) {
            ContentValues contentValues4 = new ContentValues();
            contentValues4.put("mimetype", "vnd.android.cursor.item/email_v2");
            contentValues4.put("data2", numArr4[i13]);
            contentValues4.put("data1", strArr6[i13]);
            arrayList.add(contentValues4);
        }
        for (int i14 = 0; i14 < i4; i14++) {
            ContentValues contentValues5 = new ContentValues();
            contentValues5.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues5.put("data2", numArr2[i14]);
            contentValues5.put("data1", strArr2[i14]);
            arrayList.add(contentValues5);
        }
        for (int i15 = 0; i15 < i7; i15++) {
            ContentValues contentValues6 = new ContentValues();
            contentValues6.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues6.put("data4", strArr7[i15]);
            contentValues6.put("data7", strArr9[i15]);
            contentValues6.put("data8", strArr12[i15]);
            contentValues6.put("data10", strArr10[i15]);
            contentValues6.put("data9", strArr8[i15]);
            contentValues6.put("data1", strArr11[i15]);
            arrayList.add(contentValues6);
        }
        if (!(str2 == null || str2.isEmpty() || (thumbnailBitmap = getThumbnailBitmap(str2)) == null)) {
            ContentValues contentValues7 = new ContentValues();
            contentValues7.put("raw_contact_id", (Integer) 0);
            contentValues7.put("is_super_primary", (Integer) 1);
            contentValues7.put("data15", toByteArray(thumbnailBitmap));
            contentValues7.put("mimetype", "vnd.android.cursor.item/photo");
            arrayList.add(contentValues7);
        }
        Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("name", str3);
        intent.putExtra("finishActivityOnSaveCompleted", true);
        intent.putParcelableArrayListExtra("data", arrayList);
        updateContactCallback = callback;
        getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_CONTACT_FORM, Bundle.EMPTY);
    }

    @ReactMethod
    public void openExistingContact(ReadableMap readableMap, Callback callback) {
        try {
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null);
            Intent intent = new Intent("android.intent.action.EDIT");
            intent.setDataAndType(withAppendedPath, "vnd.android.cursor.item/contact");
            intent.putExtra("finishActivityOnSaveCompleted", true);
            updateContactCallback = callback;
            getReactApplicationContext().startActivityForResult(intent, REQUEST_OPEN_EXISTING_CONTACT, Bundle.EMPTY);
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    @ReactMethod
    public void addContact(ReadableMap readableMap, Callback callback) {
        String str;
        String str2;
        String str3;
        String str4;
        Integer[] numArr;
        String[] strArr;
        int i;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        int i2;
        String[] strArr5;
        Integer[] numArr2;
        int i3;
        String[] strArr6;
        Integer[] numArr3;
        String[] strArr7;
        int i4;
        String[] strArr8;
        ContactsManager contactsManager;
        Callback callback2;
        Exception e;
        String string = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string2 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string3 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string4 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string5 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string6 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string7 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string8 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        String string9 = readableMap.hasKey("note") ? readableMap.getString("note") : null;
        String string10 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        if (array != null) {
            i = array.size();
            strArr2 = new String[i];
            str4 = string10;
            numArr = new Integer[i];
            str3 = string8;
            strArr = new String[i];
            str2 = string7;
            int i5 = 0;
            while (i5 < i) {
                strArr2[i5] = array.getMap(i5).getString("number");
                String string11 = array.getMap(i5).getString("label");
                numArr[i5] = Integer.valueOf(mapStringToPhoneType(string11));
                strArr[i5] = string11;
                i5++;
                i = i;
                string6 = string6;
            }
            str = string6;
        } else {
            str = string6;
            str2 = string7;
            str3 = string8;
            str4 = string10;
            strArr2 = null;
            i = 0;
            strArr = null;
            numArr = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            int size = array2.size();
            strArr4 = new String[size];
            strArr3 = strArr;
            int i6 = 0;
            while (i6 < size) {
                strArr4[i6] = array2.getMap(i6).getString("url");
                i6++;
                size = size;
                array2 = array2;
            }
            i2 = size;
        } else {
            strArr3 = strArr;
            i2 = 0;
            strArr4 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            int size2 = array3.size();
            strArr8 = new String[size2];
            strArr6 = strArr4;
            numArr3 = new Integer[size2];
            i3 = i2;
            strArr7 = new String[size2];
            numArr2 = numArr;
            int i7 = 0;
            while (i7 < size2) {
                strArr8[i7] = array3.getMap(i7).getString("email");
                String string12 = array3.getMap(i7).getString("label");
                numArr3[i7] = Integer.valueOf(mapStringToEmailType(string12));
                strArr7[i7] = string12;
                i7++;
                size2 = size2;
                strArr2 = strArr2;
            }
            strArr5 = strArr2;
            i4 = size2;
        } else {
            strArr5 = strArr2;
            i3 = i2;
            numArr2 = numArr;
            strArr6 = strArr4;
            strArr8 = null;
            i4 = 0;
            strArr7 = null;
            numArr3 = null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("account_type", null).withValue("account_name", null).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string).withValue("data5", string2).withValue("data3", string3).withValue("data4", string4).withValue("data6", string5).build());
        arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", string9).build());
        ContentProviderOperation.Builder withValue = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", str).withValue("data4", str2).withValue("data5", str3);
        arrayList.add(withValue.build());
        withValue.withYieldAllowed(true);
        for (int i8 = 0; i8 < i; i8++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr5[i8]).withValue("data2", numArr2[i8]).withValue("data3", strArr3[i8]).build());
        }
        for (int i9 = 0; i9 < i3; i9++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr6[i9]).build());
        }
        for (int i10 = 0; i10 < i4; i10++) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr8[i10]).withValue("data2", numArr3[i10]).withValue("data3", strArr7[i10]).build());
        }
        if (str4 == null || str4.isEmpty()) {
            contactsManager = this;
        } else {
            contactsManager = this;
            Bitmap thumbnailBitmap = contactsManager.getThumbnailBitmap(str4);
            if (thumbnailBitmap != null) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", contactsManager.toByteArray(thumbnailBitmap)).build());
            }
        }
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            for (int i11 = 0; i11 < array4.size(); i11++) {
                ReadableMap map = array4.getMap(i11);
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", Integer.valueOf(contactsManager.mapStringToPostalAddressType(map.getString("label")))).withValue("data3", map.getString("label")).withValue("data4", map.getString("street")).withValue("data7", map.getString("city")).withValue("data8", map.getString("state")).withValue("data9", map.getString("postCode")).withValue("data10", map.getString(UserDataStore.COUNTRY)).build());
            }
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (applyBatch != null && applyBatch.length > 0) {
                callback2 = callback;
                try {
                    callback2.invoke(null, new ContactsProvider(contentResolver).getContactByRawId(String.valueOf(ContentUris.parseId(applyBatch[0].uri))));
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            callback2 = callback;
            callback2.invoke(e.toString());
        }
    }

    public byte[] toByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @ReactMethod
    public void updateContact(ReadableMap readableMap, Callback callback) {
        String str;
        ReadableArray readableArray;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Integer[] numArr;
        String[] strArr;
        int i;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        int i2;
        ReadableArray readableArray2;
        String[] strArr6;
        Integer[] numArr2;
        int i3;
        String[] strArr7;
        String[] strArr8;
        String[] strArr9;
        String[] strArr10;
        Integer[] numArr3;
        int i4;
        String str8;
        String str9;
        int i5;
        int i6;
        String[] strArr11;
        Integer[] numArr4;
        String[] strArr12;
        String[] strArr13;
        String[] strArr14;
        String[] strArr15;
        String[] strArr16;
        String[] strArr17;
        String[] strArr18;
        int i7;
        Integer[] numArr5;
        String str10;
        String[] strArr19;
        Callback callback2;
        Exception e;
        Bitmap thumbnailBitmap;
        int i8;
        String[] strArr20;
        ContentProviderOperation.Builder builder;
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        String string2 = readableMap.hasKey("rawContactId") ? readableMap.getString("rawContactId") : null;
        if (string2 == null || string == null) {
            callback.invoke("Invalid recordId or rawContactId");
            return;
        }
        String string3 = readableMap.hasKey("givenName") ? readableMap.getString("givenName") : null;
        String string4 = readableMap.hasKey("middleName") ? readableMap.getString("middleName") : null;
        String string5 = readableMap.hasKey("familyName") ? readableMap.getString("familyName") : null;
        String string6 = readableMap.hasKey("prefix") ? readableMap.getString("prefix") : null;
        String string7 = readableMap.hasKey("suffix") ? readableMap.getString("suffix") : null;
        String string8 = readableMap.hasKey("company") ? readableMap.getString("company") : null;
        String string9 = readableMap.hasKey("jobTitle") ? readableMap.getString("jobTitle") : null;
        String string10 = readableMap.hasKey("department") ? readableMap.getString("department") : null;
        if (readableMap.hasKey("note")) {
            readableMap.getString("note");
        }
        String string11 = readableMap.hasKey("thumbnailPath") ? readableMap.getString("thumbnailPath") : null;
        ReadableArray array = readableMap.hasKey("phoneNumbers") ? readableMap.getArray("phoneNumbers") : null;
        String str11 = "label";
        if (array != null) {
            str7 = string11;
            i = array.size();
            str6 = string2;
            strArr2 = new String[i];
            str5 = string10;
            numArr = new Integer[i];
            str4 = string9;
            strArr = new String[i];
            str3 = string8;
            String[] strArr21 = new String[i];
            str2 = string7;
            int i9 = 0;
            while (i9 < i) {
                ReadableMap map = array.getMap(i9);
                String string12 = map.getString("number");
                String string13 = map.getString(str11);
                String string14 = map.hasKey("id") ? map.getString("id") : null;
                strArr2[i9] = string12;
                numArr[i9] = Integer.valueOf(mapStringToPhoneType(string13));
                strArr[i9] = string13;
                strArr21[i9] = string14;
                i9++;
                i = i;
                array = array;
                string6 = string6;
            }
            readableArray = array;
            str = string6;
        } else {
            str6 = string2;
            str7 = string11;
            readableArray = array;
            str = string6;
            str2 = string7;
            str3 = string8;
            str4 = string9;
            str5 = string10;
            strArr2 = null;
            i = 0;
            strArr = null;
            numArr = null;
        }
        ReadableArray array2 = readableMap.hasKey("urlAddresses") ? readableMap.getArray("urlAddresses") : null;
        if (array2 != null) {
            int size = array2.size();
            strArr5 = new String[size];
            strArr4 = new String[size];
            strArr3 = strArr;
            int i10 = 0;
            while (i10 < size) {
                ReadableMap map2 = array2.getMap(i10);
                strArr5[i10] = map2.getString("url");
                strArr4[i10] = map2.hasKey("id") ? map2.getString("id") : null;
                i10++;
                size = size;
                array2 = array2;
            }
            i2 = size;
        } else {
            strArr3 = strArr;
            i2 = 0;
            strArr5 = null;
            strArr4 = null;
        }
        ReadableArray array3 = readableMap.hasKey("emailAddresses") ? readableMap.getArray("emailAddresses") : null;
        if (array3 != null) {
            int size2 = array3.size();
            strArr8 = strArr5;
            strArr10 = new String[size2];
            strArr7 = strArr4;
            String[] strArr22 = new String[size2];
            i3 = i2;
            numArr3 = new Integer[size2];
            numArr2 = numArr;
            strArr9 = new String[size2];
            strArr6 = strArr2;
            int i11 = 0;
            while (i11 < size2) {
                ReadableMap map3 = array3.getMap(i11);
                strArr10[i11] = map3.getString("email");
                String string15 = map3.getString(str11);
                numArr3[i11] = Integer.valueOf(mapStringToEmailType(string15));
                strArr9[i11] = string15;
                strArr22[i11] = map3.hasKey("id") ? map3.getString("id") : null;
                i11++;
                size2 = size2;
                array3 = array3;
            }
            readableArray2 = array3;
            i4 = size2;
        } else {
            strArr6 = strArr2;
            i3 = i2;
            readableArray2 = array3;
            strArr8 = strArr5;
            strArr7 = strArr4;
            numArr2 = numArr;
            i4 = 0;
            numArr3 = null;
            strArr10 = null;
            strArr9 = null;
        }
        ReadableArray array4 = readableMap.hasKey("postalAddresses") ? readableMap.getArray("postalAddresses") : null;
        if (array4 != null) {
            i7 = array4.size();
            strArr16 = new String[i7];
            strArr14 = new String[i7];
            strArr13 = new String[i7];
            strArr12 = strArr9;
            String[] strArr23 = new String[i7];
            numArr4 = numArr3;
            strArr17 = new String[i7];
            strArr11 = strArr10;
            strArr15 = new String[i7];
            i6 = i4;
            numArr5 = new Integer[i7];
            i5 = i;
            strArr18 = new String[i7];
            str9 = string5;
            int i12 = 0;
            while (i12 < i7) {
                String valueFromKey = getValueFromKey(array4.getMap(i12), str11);
                strArr16[i12] = getValueFromKey(array4.getMap(i12), "street");
                strArr14[i12] = getValueFromKey(array4.getMap(i12), "city");
                strArr13[i12] = getValueFromKey(array4.getMap(i12), "state");
                strArr23[i12] = getValueFromKey(array4.getMap(i12), "region");
                strArr17[i12] = getValueFromKey(array4.getMap(i12), "postCode");
                strArr15[i12] = getValueFromKey(array4.getMap(i12), UserDataStore.COUNTRY);
                numArr5[i12] = Integer.valueOf(mapStringToPostalAddressType(valueFromKey));
                strArr18[i12] = valueFromKey;
                i12++;
                i7 = i7;
                str11 = str11;
                string4 = string4;
            }
            str8 = string4;
        } else {
            i6 = i4;
            i5 = i;
            numArr4 = numArr3;
            str8 = string4;
            str9 = string5;
            strArr11 = strArr10;
            strArr12 = strArr9;
            numArr5 = null;
            i7 = 0;
            strArr18 = null;
            strArr17 = null;
            strArr16 = null;
            strArr15 = null;
            strArr14 = null;
            strArr13 = null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.RawContacts.CONTENT_URI).withSelection("contact_id=?", new String[]{String.valueOf(string)}).withValue("account_type", null).withValue("account_name", null).build());
        arrayList.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=?", new String[]{String.valueOf(string)}).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data2", string3).withValue("data5", str8).withValue("data3", str9).withValue("data4", str).withValue("data6", str2).build());
        ContentProviderOperation.Builder withValue = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("contact_id=? AND mimetype = ?", new String[]{String.valueOf(string), "vnd.android.cursor.item/organization"}).withValue("data1", str3).withValue("data4", str4).withValue("data5", str5);
        arrayList.add(withValue.build());
        withValue.withYieldAllowed(true);
        if (readableArray != null) {
            str10 = "data4";
            strArr19 = strArr14;
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/phone_v2", String.valueOf(str6)}).build());
            int i13 = 0;
            for (int i14 = i5; i13 < i14; i14 = i14) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(str6)).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", strArr6[i13]).withValue("data2", numArr2[i13]).withValue("data3", strArr3[i13]).build());
                i13++;
            }
        } else {
            str10 = "data4";
            strArr19 = strArr14;
        }
        int i15 = i3;
        int i16 = 0;
        while (i16 < i15) {
            if (strArr7[i16] == null) {
                i8 = i15;
                builder = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(str6)).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", strArr8[i16]);
                strArr20 = strArr16;
            } else {
                i8 = i15;
                strArr20 = strArr16;
                builder = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI).withSelection("_id=?", new String[]{String.valueOf(strArr7[i16])}).withValue("data1", strArr8[i16]);
            }
            arrayList.add(builder.build());
            i16++;
            strArr16 = strArr20;
            i15 = i8;
        }
        if (readableArray2 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/email_v2", String.valueOf(str6)}).build());
            for (int i17 = 0; i17 < i6; i17++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(str6)).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", strArr11[i17]).withValue("data2", numArr4[i17]).withValue("data3", strArr12[i17]).build());
            }
        }
        if (!(str7 == null || str7.isEmpty() || (thumbnailBitmap = getThumbnailBitmap(str7)) == null)) {
            arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", 0).withValue("mimetype", "vnd.android.cursor.item/photo").withValue("data15", toByteArray(thumbnailBitmap)).build());
        }
        if (array4 != null) {
            arrayList.add(ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI).withSelection("mimetype=? AND raw_contact_id = ?", new String[]{"vnd.android.cursor.item/postal-address_v2", String.valueOf(str6)}).build());
            for (int i18 = 0; i18 < i7; i18++) {
                arrayList.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValue("raw_contact_id", String.valueOf(str6)).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data2", numArr5[i18]).withValue("data3", strArr18[i18]).withValue(str10, strArr16[i18]).withValue("data7", strArr19[i18]).withValue("data8", strArr13[i18]).withValue("data9", strArr17[i18]).withValue("data10", strArr15[i18]).build());
            }
        }
        try {
            ContentResolver contentResolver = getReactApplicationContext().getContentResolver();
            ContentProviderResult[] applyBatch = contentResolver.applyBatch("com.android.contacts", arrayList);
            if (applyBatch != null && applyBatch.length > 0) {
                Object[] objArr = {null, new ContactsProvider(contentResolver).getContactById(string)};
                callback2 = callback;
                try {
                    callback2.invoke(objArr);
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            callback2 = callback;
            callback2.invoke(e.toString());
        }
    }

    @ReactMethod
    public void deleteContact(ReadableMap readableMap, Callback callback) {
        String string = readableMap.hasKey("recordID") ? readableMap.getString("recordID") : null;
        try {
            if (getReactApplicationContext().getContentResolver().delete(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI, string), null, null) > 0) {
                callback.invoke(null, string);
            } else {
                callback.invoke(null, null);
            }
        } catch (Exception e) {
            callback.invoke(e.toString(), null);
        }
    }

    @ReactMethod
    public void checkPermission(Callback callback) {
        callback.invoke(null, isPermissionGranted());
    }

    @ReactMethod
    public void requestPermission(Callback callback) {
        requestReadContactsPermission(callback);
    }

    private void requestReadContactsPermission(Callback callback) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            callback.invoke(null, PERMISSION_DENIED);
        } else if (isPermissionGranted().equals(PERMISSION_AUTHORIZED)) {
            callback.invoke(null, PERMISSION_AUTHORIZED);
        } else {
            requestCallback = callback;
            ActivityCompat.requestPermissions(currentActivity, new String[]{PERMISSION_READ_CONTACTS}, PERMISSION_REQUEST_CODE);
        }
    }

    protected static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Callback callback = requestCallback;
        if (callback != null) {
            if (i != PERMISSION_REQUEST_CODE) {
                callback.invoke(null, PERMISSION_DENIED);
                return;
            }
            Hashtable hashtable = new Hashtable();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                hashtable.put(strArr[i2], Boolean.valueOf(iArr[i2] == 0));
            }
            if (!hashtable.containsKey(PERMISSION_READ_CONTACTS) || !((Boolean) hashtable.get(PERMISSION_READ_CONTACTS)).booleanValue()) {
                requestCallback.invoke(null, PERMISSION_DENIED);
            } else {
                requestCallback.invoke(null, PERMISSION_AUTHORIZED);
            }
            requestCallback = null;
        }
    }

    private String getValueFromKey(ReadableMap readableMap, String str) {
        return readableMap.hasKey(str) ? readableMap.getString(str) : "";
    }

    private String isPermissionGranted() {
        return getReactApplicationContext().checkCallingOrSelfPermission(PERMISSION_READ_CONTACTS) == 0 ? PERMISSION_AUTHORIZED : PERMISSION_DENIED;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private int mapStringToPhoneType(String str) {
        char c;
        switch (str.hashCode()) {
            case -1068855134:
                if (str.equals(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -557528811:
                if (str.equals("work_pager")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -487750564:
                if (str.equals("home fax")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -176627312:
                if (str.equals("work_mobile")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3208415:
                if (str.equals("home")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3343801:
                if (str.equals(Constants.ParametersKeys.MAIN)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3655441:
                if (str.equals("work")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 33287566:
                if (str.equals("work fax")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 106426307:
                if (str.equals("pager")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 3;
            case 2:
                return 2;
            case 3:
                return 12;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 18;
            case '\b':
                return 17;
            default:
                return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mapStringToEmailType(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1068855134(0xffffffffc04a90a2, float:-3.1650777)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = 3208415(0x30f4df, float:4.495947E-39)
            if (r0 == r1) goto L_0x0021
            r1 = 3655441(0x37c711, float:5.122364E-39)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "work"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 1
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "home"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "mobile"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0035
            r6 = 2
            goto L_0x0036
        L_0x0035:
            r6 = -1
        L_0x0036:
            if (r6 == 0) goto L_0x0041
            if (r6 == r4) goto L_0x003f
            if (r6 == r3) goto L_0x003d
            goto L_0x0042
        L_0x003d:
            r2 = 4
            goto L_0x0042
        L_0x003f:
            r2 = 2
            goto L_0x0042
        L_0x0041:
            r2 = 1
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rt2zz.reactnativecontacts.ContactsManager.mapStringToEmailType(java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mapStringToPostalAddressType(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3208415(0x30f4df, float:4.495947E-39)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x001b
            r1 = 3655441(0x37c711, float:5.122364E-39)
            if (r0 == r1) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r0 = "work"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0025
            r5 = 1
            goto L_0x0026
        L_0x001b:
            java.lang.String r0 = "home"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0025
            r5 = 0
            goto L_0x0026
        L_0x0025:
            r5 = -1
        L_0x0026:
            if (r5 == 0) goto L_0x002d
            if (r5 == r3) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            r2 = 2
            goto L_0x002e
        L_0x002d:
            r2 = 1
        L_0x002e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rt2zz.reactnativecontacts.ContactsManager.mapStringToPostalAddressType(java.lang.String):int");
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Callback callback;
        if ((i != REQUEST_OPEN_CONTACT_FORM && i != REQUEST_OPEN_EXISTING_CONTACT) || (callback = updateContactCallback) == null) {
            return;
        }
        if (i2 != -1) {
            callback.invoke(null, null);
            updateContactCallback = null;
        } else if (intent == null) {
            callback.invoke("Error received activity result with no data!", null);
            updateContactCallback = null;
        } else {
            try {
                Uri data = intent.getData();
                if (data == null) {
                    updateContactCallback.invoke("Error wrong data. No content uri found!", null);
                    updateContactCallback = null;
                    return;
                }
                updateContactCallback.invoke(null, new ContactsProvider(getReactApplicationContext().getContentResolver()).getContactById(data.getLastPathSegment()));
                updateContactCallback = null;
            } catch (Exception e) {
                updateContactCallback.invoke(e.getMessage(), null);
            }
        }
    }
}
