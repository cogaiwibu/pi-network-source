package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.When;

@Nonnull(when = When.UNKNOWN)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Nullable {
}
