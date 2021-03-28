package com.facebook.internal.instrument.errorreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.InstrumentUtility;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;

public final class ErrorReportHandler {
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    public static void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    public static void enable() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    public static void sendErrorReports() {
        File[] listErrorReportFiles = listErrorReportFiles();
        final ArrayList arrayList = new ArrayList();
        int i = 0;
        for (File file : listErrorReportFiles) {
            ErrorReportData errorReportData = new ErrorReportData(file);
            if (errorReportData.isValid()) {
                arrayList.add(errorReportData);
            }
        }
        Collections.sort(arrayList, new Comparator<ErrorReportData>() {
            /* class com.facebook.internal.instrument.errorreport.ErrorReportHandler.AnonymousClass1 */

            public int compare(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
                return errorReportData.compareTo(errorReportData2);
            }
        });
        JSONArray jSONArray = new JSONArray();
        while (i < arrayList.size() && i < 1000) {
            jSONArray.put(arrayList.get(i));
            i++;
        }
        InstrumentUtility.sendReports("error_reports", jSONArray, new GraphRequest.Callback() {
            /* class com.facebook.internal.instrument.errorreport.ErrorReportHandler.AnonymousClass2 */

            @Override // com.facebook.GraphRequest.Callback
            public void onCompleted(GraphResponse graphResponse) {
                try {
                    if (graphResponse.getError() == null && graphResponse.getJSONObject().getBoolean("success")) {
                        for (int i = 0; arrayList.size() > i; i++) {
                            ((ErrorReportData) arrayList.get(i)).clear();
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        });
    }

    public static File[] listErrorReportFiles() {
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        return instrumentReportDir.listFiles(new FilenameFilter() {
            /* class com.facebook.internal.instrument.errorreport.ErrorReportHandler.AnonymousClass3 */

            public boolean accept(File file, String str) {
                return str.matches(String.format("^%s[0-9]+.json$", InstrumentUtility.ERROR_REPORT_PREFIX));
            }
        });
    }
}
