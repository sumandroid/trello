package domain.models;

import java.util.UUID;

public abstract class GeneratedId {

    protected UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
}
