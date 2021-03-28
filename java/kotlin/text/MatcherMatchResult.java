package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

public final class MatcherMatchResult implements MatchResult {
    private List<String> groupValues_;
    private final MatchGroupCollection groups = new MatcherMatchResult$groups$1(this);
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher matcher2, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(matcher2, "matcher");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        this.matcher = matcher2;
        this.input = charSequence;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    /* access modifiers changed from: public */
    private final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        return RegexKt.range(getMatchResult());
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(group, "matchResult.group()");
        return group;
    }

    @Override // kotlin.text.MatchResult
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new MatcherMatchResult$groupValues$1(this);
        }
        List<String> list = this.groupValues_;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int end = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (end > this.input.length()) {
            return null;
        }
        Matcher matcher2 = this.matcher.pattern().matcher(this.input);
        Intrinsics.checkNotNullExpressionValue(matcher2, "matcher.pattern().matcher(input)");
        return RegexKt.findNext(matcher2, end, this.input);
    }
}
