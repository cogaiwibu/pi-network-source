package okhttp3;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public Route(Address address2, Proxy proxy2, InetSocketAddress inetSocketAddress2) {
        if (address2 == null) {
            throw new NullPointerException("address == null");
        } else if (proxy2 == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress2 != null) {
            this.address = address2;
            this.proxy = proxy2;
            this.inetSocketAddress = inetSocketAddress2;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address address() {
        return this.address;
    }

    public Proxy proxy() {
        return this.proxy;
    }

    public InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.address.equals(this.address) && route.proxy.equals(this.proxy) && route.inetSocketAddress.equals(this.inetSocketAddress);
        }
    }

    public int hashCode() {
        return ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.address.hashCode()) * 31) + this.proxy.hashCode()) * 31) + this.inetSocketAddress.hashCode();
    }

    public String toString() {
        return "Route{" + this.inetSocketAddress + "}";
    }
}
