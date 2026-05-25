package com.achlys20.domain.model;


import java.time.LocalDateTime;

public class Campaign {

    private final CampaignId id;
    private String name;
    private String description;
    private CampaignType type;
    private CampaignStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Campaign(CampaignId id, String name, String description,
                    CampaignType type, CampaignStatus status,
                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Campaign create(String name, String description, CampaignType type) {
        return new Campaign(
                CampaignId.generate(),
                name,
                description,
                type,
                CampaignStatus.DRAFT,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public void launch() {
        if (this.status != CampaignStatus.DRAFT) {
            throw new IllegalStateException(
                    "Campaign can only be launched from DRAFT status. Current: " + this.status
            );
        }
        this.status = CampaignStatus.ACTIVE;
        this.updatedAt = LocalDateTime.now();
    }

    public void pause() {
        if (this.status != CampaignStatus.ACTIVE) {
            throw new IllegalStateException(
                    "Campaign can only be paused from ACTIVE status. Current: " + this.status
            );
        }
        this.status = CampaignStatus.PAUSED;
        this.updatedAt = LocalDateTime.now();
    }

    public CampaignId getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public CampaignType getType() { return type; }
    public CampaignStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}