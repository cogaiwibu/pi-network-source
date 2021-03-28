package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.internal.measurement.zzct;
import com.google.android.gms.internal.measurement.zzde;
import com.ironsource.sdk.constants.Constants;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzas {
    public static zzej<Long> zza;
    public static zzej<Long> zzaa;
    public static zzej<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbp.zza);
    public static zzej<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbo.zza);
    public static zzej<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbr.zza);
    public static zzej<Integer> zzae = zza("measurement.audience.filter_result_max_count", 200, 200, zzbt.zza);
    public static zzej<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, null);
    public static zzej<Integer> zzag = zza("measurement.upload.max_event_name_cardinality", 500, 500, null);
    public static zzej<Integer> zzah = zza("measurement.upload.max_public_event_params", 25, 25, null);
    public static zzej<Long> zzai = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbs.zza);
    public static zzej<Boolean> zzaj = zza("measurement.test.boolean_flag", false, false, zzbv.zza);
    public static zzej<String> zzak = zza("measurement.test.string_flag", "---", "---", zzbu.zza);
    public static zzej<Long> zzal = zza("measurement.test.long_flag", -1L, -1L, zzbx.zza);
    public static zzej<Integer> zzam = zza("measurement.test.int_flag", -2, -2, zzbw.zza);
    public static zzej<Double> zzan;
    public static zzej<Integer> zzao = zza("measurement.experiment.max_ids", 50, 50, zzby.zza);
    public static zzej<Integer> zzap = zza("measurement.max_bundles_per_iteration", 100, 100, zzcb.zza);
    public static zzej<Boolean> zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzca.zza);
    public static zzej<Boolean> zzar = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcc.zza);
    public static zzej<Boolean> zzas = zza("measurement.collection.efficient_engagement_reporting_enabled_2", true, true, zzcf.zza);
    public static zzej<Boolean> zzat = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzce.zza);
    public static zzej<Boolean> zzau = zza("measurement.client.freeride_engagement_fix", true, true, zzch.zza);
    public static zzej<Boolean> zzav = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcg.zza);
    public static zzej<Boolean> zzaw = zza("measurement.quality.checksum", false, false, null);
    public static zzej<Boolean> zzax = zza("measurement.sdk.dynamite.allow_remote_dynamite3", true, true, zzcj.zza);
    public static zzej<Boolean> zzay = zza("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzci.zza);
    public static zzej<Boolean> zzaz = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcl.zza);
    public static zzej<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzau.zza);
    public static zzej<Boolean> zzba = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzck.zza);
    public static zzej<Boolean> zzbb = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcn.zza);
    public static zzej<Boolean> zzbc = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcp.zza);
    public static zzej<Boolean> zzbd = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzco.zza);
    public static zzej<Boolean> zzbe = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzcr.zza);
    public static zzej<Boolean> zzbf = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzcq.zza);
    public static zzej<Boolean> zzbg = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzct.zza);
    public static zzej<Boolean> zzbh = zza("measurement.upload.file_lock_state_check", false, false, zzcs.zza);
    public static zzej<Boolean> zzbi = zza("measurement.ga.ga_app_id", false, false, zzcv.zza);
    public static zzej<Boolean> zzbj = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzcu.zza);
    public static zzej<Boolean> zzbk = zza("measurement.integration.disable_firebase_instance_id", false, false, zzcx.zza);
    public static zzej<Boolean> zzbl = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzcw.zza);
    public static zzej<Boolean> zzbm = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzcy.zza);
    public static zzej<Boolean> zzbn = zza("measurement.service.use_appinfo_modified", false, false, zzdb.zza);
    public static zzej<Boolean> zzbo = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzda.zza);
    public static zzej<Boolean> zzbp = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzdd.zza);
    public static zzej<Boolean> zzbq = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzdc.zza);
    public static zzej<Boolean> zzbr = zza("measurement.upload.file_truncate_fix", false, false, zzdf.zza);
    public static zzej<Boolean> zzbs = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzde.zza);
    public static zzej<Boolean> zzbt = zza("measurement.sdk.screen.disabling_automatic_reporting", true, true, zzdh.zza);
    public static zzej<Boolean> zzbu = zza("measurement.sdk.screen.manual_screen_view_logging", true, true, zzdg.zza);
    public static zzej<Boolean> zzbv = zza("measurement.service.configurable_service_limits", true, true, zzdl.zza);
    public static zzej<Boolean> zzbw = zza("measurement.client.configurable_service_limits", true, true, zzdk.zza);
    public static zzej<Boolean> zzbx = zza("measurement.androidId.delete_feature", true, true, zzdn.zza);
    public static zzej<Boolean> zzby = zza("measurement.client.global_params", true, true, zzdm.zza);
    public static zzej<Boolean> zzbz = zza("measurement.service.global_params", true, true, zzdp.zza);
    public static zzej<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbh.zza);
    public static zzej<Boolean> zzca = zza("measurement.service.global_params_in_payload", true, true, zzdo.zza);
    public static zzej<Boolean> zzcb = zza("measurement.client.string_reader", true, true, zzdr.zza);
    public static zzej<Boolean> zzcc = zza("measurement.sdk.attribution.cache", true, true, zzdq.zza);
    public static zzej<Long> zzcd = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzdt.zza);
    public static zzej<Boolean> zzce = zza("measurement.service.database_return_empty_collection", true, true, zzds.zza);
    public static zzej<Boolean> zzcf = zza("measurement.service.ssaid_removal", true, true, zzdu.zza);
    public static zzej<Boolean> zzcg = zza("measurement.client.consent_state_v1", true, true, zzdx.zza);
    public static zzej<Boolean> zzch = zza("measurement.client.3p_consent_state_v1", true, true, zzdw.zza);
    public static zzej<Boolean> zzci = zza("measurement.service.consent_state_v1_W36", false, false, zzdz.zza);
    public static zzej<Integer> zzcj = zza("measurement.service.storage_consent_support_version", 203590, 203590, zzdy.zza);
    public static zzej<Boolean> zzck = zza("measurement.client.ad_impression", true, true, zzeb.zza);
    public static zzej<Boolean> zzcl = zza("measurement.service.ad_impression", true, true, zzea.zza);
    public static zzej<Boolean> zzcm = zza("measurement.service.separate_public_internal_event_blacklisting", true, true, zzed.zza);
    public static zzej<Boolean> zzcn = zza("measurement.service.directly_maybe_log_error_events", false, false, zzec.zza);
    private static List<zzej<?>> zzco = Collections.synchronizedList(new ArrayList());
    private static Set<zzej<?>> zzcp = Collections.synchronizedSet(new HashSet());
    private static zzej<Boolean> zzcq = zza("measurement.collection.synthetic_data_mitigation", false, false, zzdj.zza);
    public static zzej<String> zzd = zza("measurement.config.url_scheme", UriUtil.HTTPS_SCHEME, UriUtil.HTTPS_SCHEME, zzbq.zza);
    public static zzej<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcd.zza);
    public static zzej<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzcm.zza);
    public static zzej<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcz.zza);
    public static zzej<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdi.zza);
    public static zzej<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdv.zza);
    public static zzej<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzef.zza);
    public static zzej<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzax.zza);
    public static zzej<Integer> zzl;
    public static zzej<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzaz.zza);
    public static zzej<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzay.zza);
    public static zzej<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzbb.zza);
    public static zzej<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzba.zza);
    public static zzej<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzbd.zza);
    public static zzej<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzbc.zza);
    public static zzej<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbf.zza);
    public static zzej<Long> zzt;
    public static zzej<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbg.zza);
    public static zzej<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbj.zza);
    public static zzej<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbi.zza);
    public static zzej<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbl.zza);
    public static zzej<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbk.zza);
    public static zzej<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbn.zza);

    public static Map<String, String> zza(Context context) {
        zzct zza2 = zzct.zza(context.getContentResolver(), zzde.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    private static <V> zzej<V> zza(String str, V v, V v2, zzeh<V> zzeh) {
        zzej<V> zzej = new zzej<>(str, v, v2, zzeh);
        zzco.add(zzej);
        return zzej;
    }

    static {
        Long valueOf = Long.valueOf((long) TapjoyConstants.TIMER_INCREMENT);
        zza = zza("measurement.ad_id_cache_time", valueOf, valueOf, zzav.zza);
        Integer valueOf2 = Integer.valueOf((int) Constants.ControllerParameters.LOAD_RUNTIME);
        zzl = zza("measurement.upload.max_public_events_per_day", valueOf2, valueOf2, zzaw.zza);
        zzt = zza("measurement.upload.realtime_upload_interval", valueOf, valueOf, zzbe.zza);
        Long valueOf3 = Long.valueOf((long) TapjoyConstants.SESSION_ID_INACTIVITY_TIME);
        zzaa = zza("measurement.upload.retry_time", valueOf3, valueOf3, zzbm.zza);
        Double valueOf4 = Double.valueOf(-3.0d);
        zzan = zza("measurement.test.double_flag", valueOf4, valueOf4, zzbz.zza);
    }
}
