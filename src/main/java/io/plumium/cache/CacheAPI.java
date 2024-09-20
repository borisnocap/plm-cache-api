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

    /**
     * Чтобы избежать коллизии ключей между разными плагинами, необходимо при инициализации плагинов, которые будут
     * выполнять запись кэша, вызывать метод регистрации ключа.
     * @throws IllegalArgumentException в случае, если такой ключ для кэша сервера уже зарегистрирован.
     */
    void registerServerCacheKey(final @NotNull Plugin plugin, final @NotNull String key);

    /**
     * Чтобы избежать коллизии ключей между разными плагинами, необходимо при инициализации плагинов, которые будут
     * выполнять запись кэша, вызывать метод регистрации ключа.
     * @throws IllegalArgumentException в случае, если такой ключ для кэша игрока уже зарегистрирован.
     */
    void registerPlayerCacheKey(final @NotNull Plugin plugin, final @NotNull String key);

    /**
     * Получить значение кэша игрока по указанному ключу.
     * @param playerName никнейм игрока с учетом регистра.
     * @param key ключ кэша.
     */
    @Nullable
    Object getPlayerCache(final @NotNull String playerName, final @NotNull String key);

    /**
     * Получить значение кэша игрока по указанному ключу.
     * @param player онлайн игрок.
     * @param key ключ кэша.
     */
    @Nullable
    Object getPlayerCache(final @NotNull Player player, final @NotNull String key);

    /**
     * Установить значение кэша игрока по указанному ключу.
     * @param playerName никнейм игрока с учетом регистра.
     * @param key ключ кэша.
     * @param value новое значение кэша.
     */
    void setPlayerCache(final @NotNull String playerName, final @NotNull String key, final @Nullable Object value);

    /**
     * Установить значение кэша игрока по указанному ключу.
     * @param player онлайн игрок.
     * @param key ключ кэша.
     * @param value новое значение кэша.
     */
    void setPlayerCache(final @NotNull Player player, final @NotNull String key, final @Nullable Object value);

    /**
     * Получить значение кэша сервера по указанному ключу.
     * @param key ключ кэша.
     */
    @Nullable
    Object getServerCache(final @NotNull String key);

    /**
     * Установить значение кэша сервера по указанному ключу.
     * @param key ключ кэша.
     * @param value новое значение кэша.
     */
    void setServerCache(final @NotNull String key, final @Nullable Object value);
}
