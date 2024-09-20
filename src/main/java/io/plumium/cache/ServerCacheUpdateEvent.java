package io.plumium.cache;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class ServerCacheUpdateEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final String key;
    private final Object value;
    private boolean handled;

    public ServerCacheUpdateEvent(final @NotNull String key, final @Nullable Object value) {
        super();
        this.key = key;
        this.value = value;
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
    public Object getValue() {
        return value;
    }

    public void markAsHandled() {
        handled = true;
    }

    public boolean isHandled() {
        return handled;
    }
}
