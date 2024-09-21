package io.plumium.cache;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Чтобы не плодить API для каждого отдельного плагина, которому необходимо пробрасывать или использовать значения
 * из других плагинов, сделал этот API.
 * Это API реализует плагин PLM-Cache.
 * *
 * Когда какой-то плагин обновляет данные, которые должны использоваться другим плагином, он обращается к CacheAPI
 * и вызывает метод setPlayerCache или метод setServerCache.
 * Плагин PLM-Cache соответствующим образом обновляет значение кэша и вызывает {@link PlayerCacheUpdateEvent} или
 * {@link ServerCacheUpdateEvent}.
 * *
 * Тот плагин, который должен использовать значение из другого плагина должен иметь активный обработчик события,
 * чтобы получить вызванный ивент.
 * Когда такой плагин "узнает" об обновлении кэша, он пометит ивент как обработанный, чтобы другие плагины не тратили
 * на него время.
 */
@SuppressWarnings("unused")
public interface CacheAPI {

    void registerServerCacheKey(@NotNull Plugin plugin, @NotNull String key);

    void registerPlayerCacheKey(@NotNull Plugin plugin, @NotNull String key);

    @Nullable
    Object getPlayerCache(@NotNull String playerName, @NotNull String key);

    @Nullable
    Object getPlayerCache(@NotNull Player player, @NotNull String key);

    void setPlayerCache(@NotNull String playerName, @NotNull String key, @Nullable Object value);

    void setPlayerCache(@NotNull Player player, @NotNull String key, @Nullable Object value);

    @Nullable
    Object getServerCache(@NotNull String key);

    void setServerCache(@NotNull String key, @Nullable Object value);
}
