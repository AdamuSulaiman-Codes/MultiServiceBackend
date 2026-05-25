package com.achlys20.domain.model;

import java.util.UUID;

public record CampaignId(UUID value) {

    public static CampaignId generate() {
        return new CampaignId(UUID.randomUUID());
    }

    public static CampaignId of(UUID value) {
        return new CampaignId(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
