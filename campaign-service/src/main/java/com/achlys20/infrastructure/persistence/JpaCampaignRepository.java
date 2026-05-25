package com.achlys20.infrastructure.persistence;

import org.springframework.stereotype.Repository;


import com.achlys20.domain.model.Campaign;
import com.achlys20.domain.model.CampaignId;
import com.achlys20.domain.port.out.CampaignRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCampaignRepository implements CampaignRepository {

    private final SpringDataCampaignRepository springRepo;

    public JpaCampaignRepository(SpringDataCampaignRepository springRepo) {
        this.springRepo = springRepo;
    }

    @Override
    public Campaign save(Campaign campaign) {
        CampaignEntity entity = toEntity(campaign);
        CampaignEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Campaign> findById(CampaignId id) {
        return springRepo.findById(id.value()).map(this::toDomain);
    }

    @Override
    public List<Campaign> findAll() {
        return springRepo.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(CampaignId id) {
        springRepo.deleteById(id.value());
    }

    private CampaignEntity toEntity(Campaign campaign) {
        CampaignEntity entity = new CampaignEntity();
        entity.setId(campaign.getId().value());
        entity.setName(campaign.getName());
        entity.setDescription(campaign.getDescription());
        entity.setType(campaign.getType());
        entity.setStatus(campaign.getStatus());
        entity.setCreatedAt(campaign.getCreatedAt());
        entity.setUpdatedAt(campaign.getUpdatedAt());
        return entity;
    }

    private Campaign toDomain(CampaignEntity entity) {
        return new Campaign(
                CampaignId.of(entity.getId()),
                entity.getName(),
                entity.getDescription(),
                entity.getType(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}