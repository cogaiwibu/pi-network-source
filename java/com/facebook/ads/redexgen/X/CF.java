package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.UUID;

public interface CF {
    byte[] executeKeyRequest(UUID uuid, C6 c6, @Nullable String str) throws Exception;

    byte[] executeProvisionRequest(UUID uuid, CA ca) throws Exception;
}
