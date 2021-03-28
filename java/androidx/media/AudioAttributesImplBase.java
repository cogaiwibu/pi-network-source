package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {
    int mContentType = 0;
    int mFlags = 0;
    int mLegacyStream = -1;
    int mUsage = 0;

    @Override // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    AudioAttributesImplBase() {
    }

    AudioAttributesImplBase(int i, int i2, int i3, int i4) {
        this.mContentType = i;
        this.mFlags = i2;
        this.mUsage = i3;
        this.mLegacyStream = i4;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i = this.mLegacyStream;
        if (i != -1) {
            return i;
        }
        return AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mContentType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mUsage;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int i = this.mFlags;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i |= 4;
        } else if (legacyStreamType == 7) {
            i |= 1;
        }
        return i & 273;
    }

    @Override // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        bundle.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        bundle.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int i = this.mLegacyStream;
        if (i != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i);
        }
        return bundle;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.mContentType == audioAttributesImplBase.getContentType() && this.mFlags == audioAttributesImplBase.getFlags() && this.mUsage == audioAttributesImplBase.getUsage() && this.mLegacyStream == audioAttributesImplBase.mLegacyStream) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream != -1) {
            sb.append(" stream=");
            sb.append(this.mLegacyStream);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.usageToString(this.mUsage));
        sb.append(" content=");
        sb.append(this.mContentType);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.mFlags).toUpperCase());
        return sb.toString();
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return new AudioAttributesImplBase(bundle.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle.getInt("androidx.media.audio_attrs.FLAGS", 0), bundle.getInt("androidx.media.audio_attrs.USAGE", 0), bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }
}
