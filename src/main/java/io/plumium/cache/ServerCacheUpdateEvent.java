package io.plumium.cache;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class ServerCacheUpdateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final String key;
    private final Object oldValue;
    private final Object newValue;

    public ServerCacheUpdateEvent(@NotNull String key, @Nullable Object oldValue, @Nullable Object newValue) {
        super();
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @NotNull
    public String getKey() {
        return key;
    }

    @Nullable
    public Object getOldValue() {
        return oldValue;
    }

    @Nullable
    public Object getNewValue() {
        return newValue;
    }
}
