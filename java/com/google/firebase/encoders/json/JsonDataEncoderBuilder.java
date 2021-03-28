package com.google.firebase.encoders.json;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
public final class JsonDataEncoderBuilder implements EncoderConfig<JsonDataEncoderBuilder> {
    private static final ValueEncoder<Boolean> BOOLEAN_ENCODER = JsonDataEncoderBuilder$$Lambda$4.lambdaFactory$();
    private static final ValueEncoder<String> STRING_ENCODER = JsonDataEncoderBuilder$$Lambda$1.lambdaFactory$();
    private static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders = new HashMap();
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders = new HashMap();

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    private static final class TimestampEncoder implements ValueEncoder<Date> {
        private static final DateFormat rfc339;

        private TimestampEncoder() {
        }

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public void encode(Date date, ValueEncoderContext valueEncoderContext) throws EncodingException, IOException {
            valueEncoderContext.add(rfc339.format(date));
        }
    }

    public JsonDataEncoderBuilder() {
        registerEncoder(String.class, (ValueEncoder) STRING_ENCODER);
        registerEncoder(Boolean.class, (ValueEncoder) BOOLEAN_ENCODER);
        registerEncoder(Date.class, (ValueEncoder) TIMESTAMP_ENCODER);
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public <T> JsonDataEncoderBuilder registerEncoder(Class<T> cls, ObjectEncoder<? super T> objectEncoder) {
        if (!this.objectEncoders.containsKey(cls)) {
            this.objectEncoders.put(cls, objectEncoder);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public <T> JsonDataEncoderBuilder registerEncoder(Class<T> cls, ValueEncoder<? super T> valueEncoder) {
        if (!this.valueEncoders.containsKey(cls)) {
            this.valueEncoders.put(cls, valueEncoder);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    public JsonDataEncoderBuilder configureWith(Configurator configurator) {
        configurator.configure(this);
        return this;
    }

    public DataEncoder build() {
        return new DataEncoder() {
            /* class com.google.firebase.encoders.json.JsonDataEncoderBuilder.AnonymousClass1 */

            @Override // com.google.firebase.encoders.DataEncoder
            public void encode(Object obj, Writer writer) throws IOException, EncodingException {
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, JsonDataEncoderBuilder.this.objectEncoders, JsonDataEncoderBuilder.this.valueEncoders);
                jsonValueObjectEncoderContext.add(obj);
                jsonValueObjectEncoderContext.close();
            }

            @Override // com.google.firebase.encoders.DataEncoder
            public String encode(Object obj) throws EncodingException {
                StringWriter stringWriter = new StringWriter();
                try {
                    encode(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }
}
