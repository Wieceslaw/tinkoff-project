package ru.tinkoff.edu.java.parser.handler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.tinkoff.edu.java.parser.data.StackOverflowLinkData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StackOverflowLinkHandler extends LinkHandler {
    private final Pattern pattern = Pattern.compile(
            "^https://stackoverflow\\.com/questions/(\\d+)/[^/]+/?$"
    );

    @Override
    protected @Nullable StackOverflowLinkData handle(@NotNull String link) {
        Matcher matcher = pattern.matcher(link);
        if (!matcher.matches()) return null;
        Integer questionId = Integer.valueOf(matcher.group(1));
        return new StackOverflowLinkData(questionId);
    }
}
