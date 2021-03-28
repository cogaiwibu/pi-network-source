package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
public interface EncodedDestination extends Destination {
    Set<Encoding> getSupportedEncodings();
}
